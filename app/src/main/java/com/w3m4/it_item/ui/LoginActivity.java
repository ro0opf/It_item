package com.w3m4.it_item.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kakao.auth.ApiErrorCode;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.OptionalBoolean;
import com.kakao.util.exception.KakaoException;
import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Me;
import com.w3m4.it_item.data.UserDegree;
import com.w3m4.it_item.databinding.ActivityLoginBinding;
import com.w3m4.it_item.ui.main.MainActivity;
import com.w3m4.it_item.ui.signup.SignUpActivity;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private SessionCallback callback;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        if (Session.getCurrentSession().checkAndImplicitOpen()) {
            getUserProfile();
        } else {
            callback = new SessionCallback();
            Session.getCurrentSession().addCallback(callback);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Session.getCurrentSession().removeCallback(callback);
    }

    public void getUserProfile() {
        List<String> keys = new ArrayList<>();

        UserManagement.getInstance().me(keys, new MeV2ResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult) {
                if (errorResult.getErrorCode() == ApiErrorCode.AUTH_ERROR_CODE) {
                    finish();
                }
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
            }

            @Override
            public void onSuccess(MeV2Response response) {
                // TODO: 서버에 등록된 유저인지 판별 후 진행해야 합니다.

                Me.getInstance().setId(response.getId() + "");
                Me.getInstance().setNickname(response.getNickname());
                Me.getInstance().setThumbnail(response.getThumbnailImagePath());
                if (response.getKakaoAccount().getGender() != null) {
                    Me.getInstance().setGender(response.getKakaoAccount().getGender().toString());
                } else {
                    // TODO: Gender Set
                }
                if (response.getKakaoAccount().getAgeRange() != null) {
                    Me.getInstance().setAgeRange(response.getKakaoAccount().getAgeRange().toString());
                } else {
                    // TODO: AgeRange Set
                }

                // TODO: Get
                int point = 0;
                if (isBetween(point, 0, 100)) {
                    Me.getInstance().setDegree(UserDegree.Bronze);
                } else if (isBetween(point, 100, 200)) {
                    Me.getInstance().setDegree(UserDegree.Silver);
                } else if (isBetween(point, 200, 300)) {
                    Me.getInstance().setDegree(UserDegree.Gold);
                } else if (isBetween(point, 300, 400)) {
                    Me.getInstance().setDegree(UserDegree.Platinum);
                } else if (isBetween(point, 400, 500)) {
                    Me.getInstance().setDegree(UserDegree.Diamond);
                } else if (isBetween(point, 500, 99999)) {
                    Me.getInstance().setDegree(UserDegree.Challenger);
                }

                if (response.hasSignedUp() == OptionalBoolean.TRUE) { // TODO: 신규 회원 판별 후 메인 액티비티 or 관심 등록 액티비티로
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                    finish();
                }
            }
        });
    }

    public boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x < upper;
    }

    private class SessionCallback implements ISessionCallback {
        @Override
        public void onSessionOpened() {
            getUserProfile();
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
        }
    }
}