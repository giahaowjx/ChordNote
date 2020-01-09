package com.example.chordnote.ui.main.me;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.chordnote.R;
import com.example.chordnote.ui.collectdynamics.CollectDynamicActivity;
import com.example.chordnote.ui.mydynamics.MyDynamicActivity;
import com.example.chordnote.ui.userinfo.UserInfoActivity;
import com.example.chordnote.ui.widget.MeItemView;
import com.example.chordnote.ui.base.BaseFragment;
import com.example.chordnote.ui.login.LoginActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeFragment extends BaseFragment implements MeView {

    private static final String TAG = "MeFragment";

    // 用户头像
    @BindView(R.id.user_head_img)
    CircleImageView userHeadImg;

    @BindView(R.id.user_name_text)
    TextView userNameText;

    @BindView(R.id.app_setting_menu)
    MeItemView settingMenu;

    @BindView(R.id.user_dynamic_menu)
    MeItemView userDynamic;

    @BindView(R.id.user_like_dynamic_menu)
    MeItemView userLikeDynamic;

    @BindView(R.id.user_collect_comment_menu)
    MeItemView userCollectComment;

    @Inject
    MePresenter<MeView> presenter;

    private Long userId;

    public static final int USER_LOGIN = 1;

    public static final int USER_INFO = 2;


    private OnFragmentInteractionListener mListener;

    public MeFragment() {
    }

    public static MeFragment newInstance(Long userId) {
        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_me, container, false);

        // 碎片中需要解绑控件
        unbinder = ButterKnife.bind(this, view);

        // 绑定presenter
        presenter.onAttach(this);

        // 如果已经是登陆状态，显示用户信息
        presenter.showUserBriefInfo();

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
        
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

        presenter.onDetach();
    }

    @OnClick(R.id.app_setting_menu)
    public void onClickSettingMenu(View view) {
        showToastText("NICE!");
    }

    @OnClick(R.id.user_dynamic_menu)
    public void onClickUserDynamicMenu(View view) {
        Intent intent = MyDynamicActivity.getIntent(getContext());
        startActivity(intent);
    }

    @OnClick(R.id.user_like_dynamic_menu)
    public void onClickUserLikeDynamicMenu(View view) {
        Intent intent = CollectDynamicActivity.getIntent(getContext());
        startActivity(intent);
    }

    @OnClick(R.id.user_collect_comment_menu)
    public void onClickUserCollectCOmmentMenu(View view){

    }

    @OnClick(R.id.user_head_img)
    public void onClickUserHeadImg(View view) {
        presenter.goNextActivity();
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getIntent(getActivity());
        startActivityForResult(intent, USER_LOGIN);
    }

    @Override
    public void openUserInfoActivity() {
        Intent intent = UserInfoActivity.getIntent(getActivity());
        startActivityForResult(intent, USER_INFO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case USER_LOGIN:
                if (resultCode == RESULT_OK) {

                    Log.d(TAG, "onActivityResult: ");
                    presenter.showUserBriefInfo();
                }
                break;
            case USER_INFO:
                if (resultCode == RESULT_OK) {
                    boolean isDirty = data.getBooleanExtra("isDirty", false);
                    boolean isLogout = data.getBooleanExtra("isLogout", false);

                    if (isDirty) {
                        presenter.showUserBriefInfo();
                    }

                    if (isLogout) {
                        resetUserInfoView();
                    }

                }
                break;
            default:
                break;
        }
    }

    @Override
    public void changeUserInfoView(String name, String uri) {

        if (uri != null) {
            Glide.with(this)
                    .load(uri)
                    .placeholder(R.drawable.user_head)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(userHeadImg);
        }

        userNameText.setText(name);
    }

    public void resetUserInfoView() {
        Glide.with(this)
                .load(R.drawable.user_head)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(userHeadImg);

        userNameText.setText("请登录");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
