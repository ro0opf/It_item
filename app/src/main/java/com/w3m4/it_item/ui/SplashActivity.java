package com.w3m4.it_item.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.w3m4.it_item.R;
import com.w3m4.it_item.databinding.ActivitySplashBinding;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_TIME = 1000;
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        initSplashTime();
    }

    private void initSplashTime() {
        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }, SPLASH_TIME);
    }
}
