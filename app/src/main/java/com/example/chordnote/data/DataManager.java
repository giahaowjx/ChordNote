package com.example.chordnote.data;

import com.example.chordnote.data.db.DbHelper;
import com.example.chordnote.data.db.model.User;
import com.example.chordnote.data.network.ApiHelper;
import com.example.chordnote.data.network.model.CheckCodeResponse;
import com.example.chordnote.data.network.model.CommonResponse;
import com.example.chordnote.data.network.model.LoginResponse;
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
