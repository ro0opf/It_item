package com.w3m4.it_item.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.usermgmt.LoginButton;
import com.kakao.util.exception.KakaoException;
import com.w3m4.it_item.R;
import com.w3m4.it_item.util.login.KakaoSignupActivity;

/**
 * 카카오 계정으로 로그인 수행하는 액티비티
 * @author 이혁
 */
public class LoginActivity extends AppCompatActivity {

    SessionCallback callback;
    private Button btn_custom_login;
    private LoginButton btn_kakao_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 버튼 할당
        btn_custom_login = findViewById(R.id.btn_custom_login);
        btn_custom_login.setOnClickListener(view -> btn_kakao_login.performClick());
        btn_kakao_login = findViewById(R.id.btn_kakao_login);

        // 콜백
        callback = new SessionCallback();
        Session.getCurrentSession().addCallback(callback);
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

    protected void redirectSignupActivity() { // 세션 연결 성공 시, SignupActivity로 넘김
        final Intent intent = new Intent(this, KakaoSignupActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

    private class SessionCallback implements ISessionCallback {
        @Override
        public void onSessionOpened() {
            redirectSignupActivity();  // 세션 연결 성공 시, redirectSignupActivity() 호출
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            if (exception != null) {
                Log.e("Session Open Failed: ", exception + "");
            }
            setContentView(R.layout.activity_login); // 세션 연결 실패 시, 로그인 화면을 다시 불러옴
        }
    }
}