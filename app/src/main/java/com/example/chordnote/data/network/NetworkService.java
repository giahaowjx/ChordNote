package com.example.chordnote.data.network;

import com.example.chordnote.data.network.model.BookListResponse;
import com.example.chordnote.data.network.model.ChapterListResponse;
import com.example.chordnote.data.network.model.CheckCodeResponse;
import com.example.chordnote.data.network.model.Comment;
import com.example.chordnote.data.network.model.CommentsResponse;
import com.example.chordnote.data.network.model.CommonResponse;
import com.example.chordnote.data.network.model.DynamicsResponse;
import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.data.network.model.PeriodResponse;
import com.example.chordnote.data.network.model.QuestionsResponse;
import com.example.chordnote.data.network.model.RegisterResponse;
import com.example.chordnote.data.network.model.UserInformationResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

public interface NetworkService {

    // 注册
    @GET("register/")
    Observable<CheckCodeResponse> getCheckCode(@Query("email") String email);

    @Multipart
    @POST("register/")
    Observable<RegisterResponse> postRegisterRequest(@PartMap Map<String, RequestBody> requestBodyMap);

    // 登录认证
    @Multipart
    @POST("auth/")
    Observable<LoginResponse> postLoginRequest(@PartMap Map<String, RequestBody> requestBodyMap);

    // 获得用户信息
    @GET("user_information/")
    Observable<UserInformationResponse> getUserInformationRequest(@Query("email") String email);

    // 修改用户信息
    @Multipart
    @PUT("user_information/")
    Observable<CommonResponse> putUserInfomationRequest(@PartMap Map<String, RequestBody> map,
                                                        @Part MultipartBody.Part file);

    // 获得用户发布的动态
    @Multipart
    @GET("moment_detail/")
    Observable<DynamicsResponse> getUserDynamicsRequest(@Part("email") String email);

    // 获取用户发布的评论
    @Multipart
    @GET("comment_detail/")
    Observable<CommentsResponse> getUserCommentsRequest(@Part("email") String email);

    // 获得用户收藏的动态,collected = "collected"
    @Multipart
    @GET("moment_detail/")
    Observable<DynamicsResponse> getUserCollectDynamicsRequest(@Part("email") String email,
                                                               @Part("type") String collected);

    // 获得用过户收藏的评论,collected = "collected"
    @Multipart
    @GET("comment_detail/")
    Observable<CommentsResponse> getUserCollectCommentsRequest(@Part("email") String email,
                                                               @Part("type") String collected);

    // 获得book列表
    @Multipart
    @GET("book/all")
    Observable<BookListResponse> getBookListRequest();

    // 获得book的chapter列表
    @Multipart
    @GET("book/chapter/all")
    Observable<ChapterListResponse> getChapterListRequest(@Part("id") int id);

    // 获取chapter的period信息
    @Multipart
    @GET("book/period")
    Observable<PeriodResponse> getPeriodInfoRequest(@Part("id") int id);

    // 获取period的question
    @Multipart
    @GET("book/period/question")
    Observable<QuestionsResponse> getQuestionsRequest(@Part("id") int id);

    // 获取period的评论信息
    @Multipart
    @GET("book/period.comment")
    Observable<CommentsResponse> getCommentsRequest(@Part("id") int id);

    // 发布评论
    @Multipart
    @POST("book/period/comment")
    Observable<CommonResponse> postCommentRequest(@PartMap Map<String, RequestBody> request);

    // 删除评论
    @Multipart
    @DELETE("book/period/comment")
    Observable<CommonResponse> deleteCommentRequest(@Part("id_comment") int idComment);

    // 收藏评论
    @Multipart
    @POST("book/period/comment/collect")
    Observable<CommonResponse> postCollectCommentRequest(@Part("id_comment") int idComment,
                                                         @Part("email") String email);

    // 取消收藏评论
    @Multipart
    @DELETE("book/period/comment/collect")
    Observable<CommonResponse> deleteCollectCommentRequest(@Part("id_comment") int idComment,
                                                           @Part("email") String email);
    // 获取动态，一次十条
    @Multipart
    @GET("moment/")
    Observable<DynamicsResponse> getDynamicsRequest();

    // 发布动态
    @Multipart
    @POST("moment/")
    Observable<CommonResponse> postDynamicRequest(@PartMap Map<String, RequestBody> request,
                                                  @Part("music") MultipartBody.Part musicFile,
                                                  @Part("images")List<MultipartBody.Part> imageList);

    // 删除动态
    @Multipart
    @DELETE("moment/")
    Observable<CommonResponse> deleteDynamicRequest(@Part("moment_id") int idDynamic);

    // 点赞动态,addLikeNum = "add_like_num"
    @Multipart
    @PUT("moment/")
    Observable<CommonResponse> putLikeDynamicRequest(@Part("moment_id") int idDynamic,
                                                     @Part("method") String addLikeNum);

    // 取消点赞动态,cancelAddLikeNum = "cacel_add_like_num"
    @Multipart
    @PUT("moment/")
    Observable<CommonResponse> putCancelLikeDynamicRequest(@Part("moment_id") int idDynamic,
                                                        @Part("method") String cancelAddLikeNum);

    // 收藏动态,collectDynamic = "collect_moment"
    @Multipart
    @PUT("moment/")
    Observable<CommonResponse> putCollectDynamicRequest(@Part("moment_id") int idDynamic,
                                                        @Part("email") String email,
                                                        @Part("method") String collectDynamic);

    // 取消收藏动态,cancelCollectDynamic = "cancel_collect_moment"
    @Multipart
    @PUT("moment/")
    Observable<CommonResponse> putCancelCollectDynamicRequest(@Part("moment_id") int idDynamic,
                                                              @Part("email") String email,
                                                              @Part("method") String cancelCollectDynamic);

}
