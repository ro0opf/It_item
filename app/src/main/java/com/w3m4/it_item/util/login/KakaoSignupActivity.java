package com.w3m4.it_item.util.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.kakao.auth.ApiErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.util.helper.log.Logger;
import com.w3m4.it_item.ui.LoginActivity;
import com.w3m4.it_item.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Sign up or Login
 * @author 이혁
 */
public class KakaoSignupActivity extends Activity {
    /**
     * Main으로 넘길지 가입 페이지를 그릴지 판단하기 위해 me를 호출
     *
     * @param savedInstanceState 기존 session 정보가 저장된 객체
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestMe();
    }

    /**
     * 사용자 프로필 조회
     */
    public void requestMe() {
        List<String> keys = new ArrayList<>();
        keys.add("properties.id");
        keys.add("properties.nickname");
        keys.add("properties.profile_image");

        UserManagement.getInstance().me(keys, new MeV2ResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult) {
                String message = "failed to get user info. msg=" + errorResult;
                Logger.d(message);

                if (errorResult.getErrorCode() == ApiErrorCode.AUTH_ERROR_CODE) {
                    finish();
                } else {
                    redirectLoginActivity();
                }
            }

            @Override
            public void onSessionClosed(ErrorResult errorResult) {
                redirectLoginActivity();
            }

            @Override
            public void onSuccess(MeV2Response response) { // 성공 시
                String id = "" + response.getId();
                String nickname = "" + response.getNickname();
                String imagePath = "" + response.getProfileImagePath();

                Log.e("Profile : ", "Nickname: " + id + "");
                Log.e("Profile : ", "Id: " + nickname + "");
                Log.e("Profile : ", "Image: " + imagePath + "");
                redirectMainActivity();
            }
        });
    }

    private void redirectMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    protected void redirectLoginActivity() {
        final Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }
}