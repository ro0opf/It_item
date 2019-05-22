package com.w3m4.it_item.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kakao.auth.ApiErrorCode;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.exception.KakaoException;
import com.w3m4.it_item.R;
import com.w3m4.it_item.databinding.ActivityLoginBinding;

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
                Me.getInstance().setId(response.getId() + "");
                Me.getInstance().setNickname(response.getNickname());
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

                // TODO: Set Accumulated Point, Current Point, Degree

                if (response.hasSignedUp() == OptionalBoolean.TRUE) { // TODO: 회원 아이디가 디비에 있는지
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(getApplicationContext(), InterestActivity.class));
                    finish();
                }
            }
        });
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