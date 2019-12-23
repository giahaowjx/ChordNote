package com.example.chordnote.data;

import com.example.chordnote.data.db.DbHelper;
import com.example.chordnote.data.db.model.User;
import com.example.chordnote.data.network.ApiHelper;
import com.example.chordnote.data.network.model.BookListResponse;
import com.example.chordnote.data.network.model.ChapterListResponse;
import com.example.chordnote.data.network.model.CheckCodeResponse;
import com.example.chordnote.data.network.model.CommentsResponse;
import com.example.chordnote.data.network.model.CommonResponse;
import com.example.chordnote.data.network.model.DynamicsResponse;
import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.data.network.model.PeriodResponse;
import com.example.chordnote.data.network.model.QuestionsResponse;
import com.example.chordnote.data.network.model.RegisterResponse;
import com.example.chordnote.data.network.model.UserInformationResponse;
import com.example.chordnote.data.prefs.PreferencesHelper;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

public class DataManager implements DataManagerApi {

    private PreferencesHelper preferencesHelper;

    private ApiHelper apiHelper;

    private DbHelper dbHelper;

    @Override
    public String getCurrentUserEmail() {
        return preferencesHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String email) {
        preferencesHelper.setCurrentUserEmail(email);
    }

    @Override
    public String getCurrentUserPass() {
        return preferencesHelper.getCurrentUserPass();
    }

    @Override
    public void setCurrentUserPass(String password) {
        preferencesHelper.setCurrentUserPass(password);
    }

    public DataManager(PreferencesHelper preferencesHelper, ApiHelper apiHelper, DbHelper dbHelper) {
        this.preferencesHelper = preferencesHelper;
        this.apiHelper = apiHelper;
        this.dbHelper = dbHelper;
    }

    // PreferencesHelper Interface
    @Override
    public boolean getCurrentLoginState() {
        return preferencesHelper.getCurrentLoginState();
    }

    @Override
    public void setCurrentLoginState(boolean state) {
        preferencesHelper.setCurrentLoginState(state);
    }

    // ApiHelper interface
    public Observable<LoginResponse> doLoginApiCall(Map<String, RequestBody> requestBodyMap) {
        return apiHelper.doLoginApiCall(requestBodyMap);
    }

    public Observable<RegisterResponse> doRegisterApiCall(Map<String, RequestBody> requestBodyMap) {
        return apiHelper.doRegisterApiCall(requestBodyMap);
    }

    public Observable<CheckCodeResponse> doSendCheckCodeApiCall(String email) {
        return apiHelper.doSendCheckCodeApiCall(email);
    }

    @Override
    public Observable<UserInformationResponse> doGetUserInformationApiCall(String email) {
        return apiHelper.doGetUserInformationApiCall(email);
    }

    @Override
    public Observable<CommonResponse> doUpdateUserInfoApiCall(Map<String, RequestBody> map, MultipartBody.Part file) {
        return apiHelper.doUpdateUserInfoApiCall(map, file);
    }

    // 获得用户发布的动态
    @Override
    public Observable<DynamicsResponse> doGetUserDynamicsApiCall(String email){
        return apiHelper.doGetUserDynamicsApiCall(email);
    }

    // 获取用户发布的评论
    @Override
    public Observable<CommentsResponse> doGetUserCommentsApiCall(String email) {
        return apiHelper.doGetUserCommentsApiCall(email);
    }

    // 获得用户收藏的动态,collected = "collected"
    @Override
    public Observable<DynamicsResponse> doGetUserCollectDynamicsApiCall(String email) {
        return apiHelper.doGetUserCollectDynamicsApiCall(email);
    }

    // 获得用过户收藏的评论,collected = "collected"
    @Override
    public Observable<CommentsResponse> doGetUserCollectCommentsApiCall(String email) {
        return apiHelper.doGetUserCollectCommentsApiCall(email);
    }

    // 获得book列表
    @Override
    public Observable<BookListResponse> doGetBookListApiCall() {
        return apiHelper.doGetBookListApiCall();
    }

    // 获得book的chapter列表
    @Override
    public Observable<ChapterListResponse> doGetChapterListApiCall(int id) {
        return apiHelper.doGetChapterListApiCall(id);
    }

    // 获取chapter的period信息
    @Override
    public Observable<PeriodResponse> doGetPeriodInfoApiCall(int id) {
        return apiHelper.doGetPeriodInfoApiCall(id);
    }

    // 获取period的question
    @Override
    public Observable<QuestionsResponse> doGetQuestionsApiCall(int id) {
        return apiHelper.doGetQuestionsApiCall(id);
    }

    // 获取period的评论信息
    @Override
    public Observable<CommentsResponse> doGetCommentsApiCall(int id) {
        return apiHelper.doGetCommentsApiCall(id);
    }

    // 发布评论
    @Override
    public Observable<CommonResponse> doPostCommentApiCall(Map<String, RequestBody> request) {
        return apiHelper.doPostCommentApiCall(request);
    }

    // 删除评论
    @Override
    public Observable<CommonResponse> doDeleteCommentApiCall(int idComment) {
        return apiHelper.doDeleteCommentApiCall(idComment);
    }

    // 收藏评论
    @Override
    public Observable<CommonResponse> doPostCollectCommentApiCall(int idComment, String email) {
        return apiHelper.doPostCollectCommentApiCall(idComment, email);
    }

    // 取消收藏评论
    @Override
    public Observable<CommonResponse> doDeleteCollectCommentApiCall(int idComment, String email) {
        return apiHelper.doDeleteCollectCommentApiCall(idComment, email);
    }

    // 获取动态，一次十条
    @Override
    public Observable<DynamicsResponse> doGetDynamicsApiCall() {
        return apiHelper.doGetDynamicsApiCall();
    }

    // 发布动态
    @Override
    public Observable<CommonResponse> doPostDynamicApiCall(Map<String, RequestBody> request, MultipartBody.Part musicFile, List<MultipartBody.Part> imageList) {
        return apiHelper.doPostDynamicApiCall(request, musicFile, imageList);
    }

    // 删除动态
    @Override
    public Observable<CommonResponse> doDeleteDynamicApiCall(int idDynamic) {
        return apiHelper.doDeleteDynamicApiCall(idDynamic);
    }

    // 点赞动态,addLikeNum = "add_like_num"
    @Override
    public Observable<CommonResponse> doPutLikeDynamicApiCall(int idDynamic) {
        return apiHelper.doPutLikeDynamicApiCall(idDynamic);
    }

    // 取消点赞动态,cancelAddLikeNum = "cacel_add_like_num"
    @Override
    public Observable<CommonResponse> doPutCancelLikeDynamicApiCall(int idDynamic) {
        return apiHelper.doPutCancelLikeDynamicApiCall(idDynamic);
    }

    // 收藏动态,collectDynamic = "collect_moment"
    @Override
    public Observable<CommonResponse> dpPutCollectDynamicApiCall(int idDynamic, String email) {
        return apiHelper.dpPutCollectDynamicApiCall(idDynamic, email);
    }

    // 取消收藏动态,cancelCollectDynamic = "cancel_collect_moment"
    @Override
    public Observable<CommonResponse> doPutCancelCollectDynamicApiCall(int idDynamic, String email) {
        return apiHelper.doPutCancelCollectDynamicApiCall(idDynamic, email);
    }

    // Shared Preference Interface
    @Override
    public void setEmailToIdMap(String email, long id) {
        preferencesHelper.setEmailToIdMap(email, id);
    }

    @Override
    public Long getIdUsingEmail(String email) {
        return preferencesHelper.getIdUsingEmail(email);
    }

    @Override
    public long insertUser(User user) {
        return dbHelper.insertUser(user);
    }

    @Override
    public void deleteUser(User user) {
        dbHelper.deleteUser(user);
    }

    @Override
    public List<User> getUser(String id) {
        return dbHelper.getUser(id);
    }

    @Override
    public void deleteEmailToIdMap(String email) {

    }

    @Override
    public void resetCurrentLoginInfo() {
        preferencesHelper.resetCurrentLoginInfo();
    }

    @Override
    public String getCurrentUserNickName() {
        return preferencesHelper.getCurrentUserNickName();
    }

    @Override
    public void setCurrentUserNickName(String name) {
        preferencesHelper.setCurrentUserNickName(name);
    }
}
