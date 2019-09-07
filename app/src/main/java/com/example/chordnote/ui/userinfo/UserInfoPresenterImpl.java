package com.example.chordnote.ui.userinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.db.model.User;
import com.example.chordnote.data.network.model.CommonResponse;
import com.example.chordnote.data.network.model.UserInformationResponse;
import com.example.chordnote.di.ActivityContext;
import com.example.chordnote.ui.base.BasePresenter;
import com.example.chordnote.utils.FileUtils;
import com.example.chordnote.utils.NetworkUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserInfoPresenterImpl<V extends UserInfoView> extends BasePresenter<V>
        implements UserInfoPresenter<V> {

    private static final String TAG = "UserInfoPresenterImpl";

    private Context context;

    public UserInfoPresenterImpl(@ActivityContext Context context, DataManager manager) {
        super(manager);

        if (context instanceof UserInfoActivity) {
            this.context = (UserInfoActivity) context;
        }
    }

    @Override
    public void refreshUserInfo() {
        if (getMvpView().isConnected()) {
            getDataManager().doGetUserInformationApiCall(getDataManager().getCurrentUserEmail())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<UserInformationResponse>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "onCompleted: ");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: ");
                        }

                        @Override
                        public void onNext(UserInformationResponse userInformationResponse) {
                            Log.d(TAG, "onNext: ");

                            // 将获取的信息设置到界面上
                            User user = userInformationResponse.getUserInformation();

                            Log.d(TAG, "onNext: " + user.getImageUrl());

                            String uri = user.getImageUrl();

                            if (!uri.equals("http://212.64.92.236:10000/media/")) {
                                Log.d(TAG, "onNext: 有头像");
                                
                                getMvpView().setUserUri(user.getImageUrl());
                            } else {
                                getMvpView().setUserUri();
                            }
                            getMvpView().setUserName(user.getUserName());
                            getMvpView().setUserEmail(user.getEmail());
                            getMvpView().setUserSex(user.getSex());
                            getMvpView().setUserBirthDate(user.getBirthDate());
                            getMvpView().setUserDescription(user.getDescription());
                        }
                    });
        } else {
            // 如果没有网就从本地得数据库读取
            List<User> users = getDataManager().getUser("" + getDataManager().getIdUsingEmail(getDataManager()
                    .getCurrentUserEmail()));

            if (users.size() != 1) {
                getMvpView().showToastText("同一邮箱用户超过一个");
            } else {
                User user = users.get(0);

                String uri = user.getImageUrl();

                if (!uri.equals("http://212.64.92.236:10000/media/")) {
                    getMvpView().setUserUri(user.getImageUrl());
                } else {
                    getMvpView().setUserUri();
                }
                getMvpView().setUserName(user.getUserName());
                getMvpView().setUserEmail(user.getEmail());
                getMvpView().setUserSex(user.getSex());
                getMvpView().setUserBirthDate(user.getBirthDate());
                getMvpView().setUserDescription(user.getDescription());
            }
        }
    }

    @Override
    public void saveBitmap(Context context, Uri uri) {
        try {
            Log.d(TAG, "saveBitmap: Before Create Bitmap");
            // 获取图片
            Bitmap bitmap = BitmapFactory.decodeStream(context.getContentResolver()
                    .openInputStream(uri));

            Log.d(TAG, "saveBitmap: Before save bitmap");
            // 保存压缩头像图片
            File file = new File(FileUtils.getPathUsingUri(context, uri));
            FileOutputStream bitmapOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bitmapOut);
            bitmapOut.flush();
            bitmapOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Uri iniImgFile(Context context) {

        long time = System.currentTimeMillis();

        File imgFile = new File(context.getCacheDir(), "head" + time + ".jpg");

        Log.d(TAG, "openCamera: initialize image file");

        Uri imgUri;

        try {
            if (imgFile.exists()) {
                imgFile.delete();
            }
            imgFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Build.VERSION.SDK_INT >= 24) {

            imgUri = FileProvider.getUriForFile(context,
                    "com.example.chordnote.fileprovider", imgFile);
        } else {
            imgUri = Uri.fromFile(imgFile);
        }

        return imgUri;
    }

    // 获取修改用户信息的申请的两个必要信息
    public Map<String, String> getUpdateUserInfoRequestHeader() {
        Map<String, String> request = new HashMap<>();
        request.put("email", getDataManager().getCurrentUserEmail());
        request.put("nickname", getDataManager().getCurrentUserNickName());
        return request;
    }

    @Override
    public void uploadHeadImg(Uri uri) {
        if (!getMvpView().isConnected()) {
            // 如果没有网就显示没网无法上传
            getMvpView().showToastText("没有网络！请联网后重新上传");
        } else {
            File file = new File(FileUtils.getPathUsingUri(context, uri));

            Log.d(TAG, "uploadHeadImg: before upload");
            // 上传图片
            Map<String, String> request = getUpdateUserInfoRequestHeader();
            getDataManager().doUpdateUserInfoApiCall(NetworkUtils.generateRegisterRequestBody(request),
                    NetworkUtils.generateMultipartBody(file, "image", NetworkUtils.IMAGE))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<CommonResponse>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "onCompleted: ");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: ");
                        }

                        @Override
                        public void onNext(CommonResponse commonResponse) {
                            Log.d(TAG, "onNext: upload image");

                            if (commonResponse.getCode() == 1000) {
                                getMvpView().showToastText("修改成功!" + commonResponse.getMessage());

                                getMvpView().setUserUri(file.getAbsolutePath());
                                getMvpView().isDirty(true);
                            } else if (commonResponse.getCode() == 1001) {
                                getMvpView().showToastText(commonResponse.getMessage());
                            }

                        }
                    });
        }
    }

    @Override
    public void uploadUserName(String name) {
        if (!getMvpView().isConnected()) {
            // 如果没有网就显示没网无法上传
            getMvpView().showToastText("没有网络！请联网后重新修改");
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("email", getDataManager().getCurrentUserEmail());
            map.put("nickname", name);

            getDataManager().doUpdateUserInfoApiCall(NetworkUtils.generateRegisterRequestBody(map), null)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<CommonResponse>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "onCompleted: ");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: ");
                        }

                        @Override
                        public void onNext(CommonResponse commonResponse) {
                            if (commonResponse.getCode() == 1000) {
                                // 成功上传后修改本地用户信息
                                getDataManager().setCurrentUserNickName(name);
                                getMvpView().showToastText("修改成功");
                                getMvpView().isDirty(true);
                                getMvpView().setUserName(name);
                            } else if (commonResponse.getCode() == 1001) {
                                getMvpView().showToastText("修改失败");
                            }
                        }
                    });
        }
    }

    @Override
    public void uploadUserDesc(String desc) {
        if (!getMvpView().isConnected()) {
            // 如果没有网就显示没网无法上传
            getMvpView().showToastText("没有网络！请联网后重新修改");
        } else {
            Map<String, String> request = getUpdateUserInfoRequestHeader();
            request.put("description", desc);

            getMvpView().showLoading();

            getDataManager().doUpdateUserInfoApiCall(NetworkUtils.generateRegisterRequestBody(request),
                    null)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<CommonResponse>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "onCompleted: ");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: ");
                        }

                        @Override
                        public void onNext(CommonResponse commonResponse) {
                            Log.d(TAG, "onNext: ");

                            if (commonResponse.getCode() == 1000) {
                                getMvpView().showToastText("修改成功");
                                getMvpView().isDirty(true);
                                getMvpView().setUserDescription(desc);
                            } else if (commonResponse.getCode() == 1001) {
                                getMvpView().showToastText("修改失败");
                            }
                        }
                    });
            getMvpView().hideLoading();
        }
    }

    @Override
    public void resetLoginState() {
        getDataManager().resetCurrentLoginInfo();
    }
}
