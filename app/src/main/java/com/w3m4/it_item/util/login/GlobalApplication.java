package com.w3m4.it_item.util.login;

import android.app.Activity;
import android.app.Application;

import com.kakao.auth.KakaoSDK;

/**
 * 앱 실행 시 Kakao SDK 초기화하기 위한 싱글톤 클래스
 * @author 이혁
 */
public class GlobalApplication extends Application {
    // Thread Safe하게...
    private static volatile GlobalApplication instance = null;
    private static volatile Activity currentActivity = null;

    public static GlobalApplication getGlobalApplicationContext() {
        if (instance == null) {
            throw new IllegalStateException("This Application does not inherit com.kakao.GlobalApplication");
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        KakaoSDK.init(new KakaoSDKAdapter()); // Kakao SDK 초기화
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }

    public static Activity getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(Activity currentActivity) {
        GlobalApplication.currentActivity = currentActivity;
    }
}