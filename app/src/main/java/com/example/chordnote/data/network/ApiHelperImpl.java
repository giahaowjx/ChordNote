package com.example.chordnote.data.network;

import com.example.chordnote.data.network.model.BookListResponse;
import com.example.chordnote.data.network.model.ChapterListResponse;
import com.example.chordnote.data.network.model.CommentsResponse;
import com.example.chordnote.data.network.model.CommonResponse;
import com.example.chordnote.data.network.model.DynamicsResponse;
import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.data.network.model.PeriodResponse;
import com.example.chordnote.data.network.model.QuestionsResponse;
import com.example.chordnote.data.network.model.RegisterResponse;
import com.example.chordnote.data.network.model.CheckCodeResponse;
import com.example.chordnote.data.network.model.UserInformationResponse;
import com.example.chordnote.utils.AppSetting;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;


public class ApiHelperImpl implements ApiHelper {

//    private ApiHeader mApiHeader;

    private static final String TAG = "ApiHelperImpl";

    private Retrofit retrofit;

    private NetworkService service;

    @Inject
    public ApiHelperImpl() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);


        retrofit = new Retrofit.Builder()
                .baseUrl(AppSetting.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();

        service = retrofit.create(NetworkService.class);
    }

//    @Override
//    public ApiHeader getApiHeader() {
//        return mApiHeader;
//    }

    @Override
    public Observable<LoginResponse> doLoginApiCall(Map<String, RequestBody> requestBodyMap) {
        return service.postLoginRequest(requestBodyMap);
    }

    @Override
    public Observable<RegisterResponse> doRegisterApiCall(Map<String, RequestBody> requestBodyMap) {

        return service.postRegisterRequest(requestBodyMap);
    }

    @Override
    public Observable<CheckCodeResponse> doSendCheckCodeApiCall(String  email) {

        return service.getCheckCode(email);
    }

    @Override
    public Observable<UserInformationResponse> doGetUserInformationApiCall(String email) {
        return service.getUserInformationRequest(email);
    }

    @Override
    public Observable<CommonResponse> doUpdateUserInfoApiCall(Map<String, RequestBody> map, MultipartBody.Part file) {
        return service.putUserInfomationRequest(map, file);
    }

    // 获得用户发布的动态
    @Override
    public Observable<DynamicsResponse> doGetUserDynamicsApiCall(String email) {
        return service.getUserDynamicsRequest(email);
    }

    // 获取用户发布的评论
    @Override
    public Observable<CommentsResponse> doGetUserCommentsApiCall(String email) {
        return service.getUserCommentsRequest(email);
    }

    // 获得用户收藏的动态,collected = "collected"
    @Override
    public Observable<DynamicsResponse> doGetUserCollectDynamicsApiCall(String email) {
        return service.getUserCollectDynamicsRequest(email, "collected");
    }

    // 获得用过户收藏的评论,collected = "collected"
    @Override
    public Observable<CommentsResponse> doGetUserCollectCommentsApiCall(String email) {
        return service.getUserCollectCommentsRequest(email, "collected");
    }

    // 获得book列表
    @Override
    public Observable<BookListResponse> doGetBookListApiCall() {
        return service.getBookListRequest();
    }

    // 获得book的chapter列表
    @Override
    public Observable<ChapterListResponse> doGetChapterListApiCall(int id) {
        return service.getChapterListRequest(id);
    }

    // 获取chapter的period信息
    @Override
    public Observable<PeriodResponse> doGetPeriodInfoApiCall(int id) {
        return service.getPeriodInfoRequest(id);
    }

    // 获取period的question
    @Override
    public Observable<QuestionsResponse> doGetQuestionsApiCall(int id) {
        return service.getQuestionsRequest(id);
    }

    // 获取period的评论信息
    @Override
    public Observable<CommentsResponse> doGetCommentsApiCall(int id) {
        return service.getCommentsRequest(id);
    }

    // 发布评论
    @Override
    public Observable<CommonResponse> doPostCommentApiCall(Map<String, RequestBody> request) {
        return service.postCommentRequest(request);
    }

    // 删除评论
    @Override
    public Observable<CommonResponse> doDeleteCommentApiCall(int idComment) {
        return service.deleteCommentRequest(idComment);
    }

    // 收藏评论
    @Override
    public Observable<CommonResponse> doPostCollectCommentApiCall(int idComment, String email) {
        return service.postCollectCommentRequest(idComment, email);
    }

    // 取消收藏评论
    @Override
    public Observable<CommonResponse> doDeleteCollectCommentApiCall(int idComment, String email) {
        return service.deleteCollectCommentRequest(idComment, email);
    }

    // 获取动态，一次十条
    @Override
    public Observable<DynamicsResponse> doGetDynamicsApiCall() {
        return service.getDynamicsRequest();
    }

    // 发布动态
    @Override
    public Observable<CommonResponse> doPostDynamicApiCall(Map<String, RequestBody> request, MultipartBody.Part musicFile, List<MultipartBody.Part> imageList) {
        return service.postDynamicRequest(request, musicFile, imageList);
    }

    // 删除动态
    @Override
    public Observable<CommonResponse> doDeleteDynamicApiCall(int idDynamic) {
        return service.deleteDynamicRequest(idDynamic);
    }

    // 点赞动态,addLikeNum = "add_like_num"
    @Override
    public Observable<CommonResponse> doPutLikeDynamicApiCall(int idDynamic) {
        return service.putLikeDynamicRequest(idDynamic, "add_like_num");
    }

    // 取消点赞动态,cancelAddLikeNum = "cacel_add_like_num"
    @Override
    public Observable<CommonResponse> doPutCancelLikeDynamicApiCall(int idDynamic) {
        return service.putCancelLikeDynamicRequest(idDynamic, "cacel_add_like_num");
    }

    // 收藏动态,collectDynamic = "collect_moment"
    @Override
    public Observable<CommonResponse> dpPutCollectDynamicApiCall(int idDynamic, String email) {
        return service.putCollectDynamicRequest(idDynamic, email, "collect_moment");
    }

    // 取消收藏动态,cancelCollectDynamic = "cancel_collect_moment"
    @Override
    public Observable<CommonResponse> doPutCancelCollectDynamicApiCall(int idDynamic, String email) {
        return service.putCancelCollectDynamicRequest(idDynamic, email, "cancel_collect_moment");
    }
}
