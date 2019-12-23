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

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;


public interface ApiHelper {

//    ApiHeader getApiHeader();

    Observable<LoginResponse> doLoginApiCall(Map<String, RequestBody> requestBodyMap);

    Observable<RegisterResponse> doRegisterApiCall(Map<String, RequestBody> request);

    Observable<CheckCodeResponse> doSendCheckCodeApiCall(String  email);

    Observable<UserInformationResponse> doGetUserInformationApiCall(String email);

    Observable<CommonResponse> doUpdateUserInfoApiCall(Map<String, RequestBody> map,
                                                       MultipartBody.Part file);

    // 获得用户发布的动态
    Observable<DynamicsResponse> doGetUserDynamicsApiCall(String email);

    // 获取用户发布的评论
    Observable<CommentsResponse> doGetUserCommentsApiCall(String email);

    // 获得用户收藏的动态
    Observable<DynamicsResponse> doGetUserCollectDynamicsApiCall(String email);

    // 获得用过户收藏的评论
    Observable<CommentsResponse> doGetUserCollectCommentsApiCall(String email);

    // 获得book列表
    Observable<BookListResponse> doGetBookListApiCall();

    // 获得book的chapter列表
    Observable<ChapterListResponse> doGetChapterListApiCall(int id);

    // 获取chapter的period信息
    Observable<PeriodResponse> doGetPeriodInfoApiCall(int id);

    // 获取period的question
    Observable<QuestionsResponse> doGetQuestionsApiCall(int id);

    // 获取period的评论信息
    Observable<CommentsResponse> doGetCommentsApiCall(int id);

    // 发布评论
    Observable<CommonResponse> doPostCommentApiCall(Map<String, RequestBody> request);

    // 删除评论
    Observable<CommonResponse> doDeleteCommentApiCall(int idComment);

    // 收藏评论
    Observable<CommonResponse> doPostCollectCommentApiCall(int idComment, String email);

    // 取消收藏评论
    Observable<CommonResponse> doDeleteCollectCommentApiCall(int idComment, String email);

    // 获取动态，一次十条
    Observable<DynamicsResponse> doGetDynamicsApiCall();

    // 发布动态
    Observable<CommonResponse> doPostDynamicApiCall(Map<String, RequestBody> request, MultipartBody.Part musicFile,
                                                    List<MultipartBody.Part> imageList);

    // 删除动态
    Observable<CommonResponse> doDeleteDynamicApiCall(int idDynamic);

    // 点赞动态
    Observable<CommonResponse> doPutLikeDynamicApiCall(int idDynamic);

    // 取消点赞动态
    Observable<CommonResponse> doPutCancelLikeDynamicApiCall(int idDynamic);

    // 收藏动态
    Observable<CommonResponse> dpPutCollectDynamicApiCall(int idDynamic, String email);

    // 取消收藏动态
    Observable<CommonResponse> doPutCancelCollectDynamicApiCall(int idDynamic, String email);
}
