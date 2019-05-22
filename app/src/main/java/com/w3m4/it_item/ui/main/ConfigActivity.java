package com.w3m4.it_item.ui.main;

import android.app.Activity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.w3m4.it_item.R;
import com.w3m4.it_item.databinding.ActivityConfigBinding;

public class ConfigActivity extends Activity {
    private ActivityConfigBinding binding;
    private final int REQUEST_OK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_config);

        setResult(REQUEST_OK);
        binding.clMain.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.slide_out_right);
    }
}
