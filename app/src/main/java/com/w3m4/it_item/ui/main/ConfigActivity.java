package com.w3m4.it_item.ui.main;

import android.app.Activity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Me;
import com.w3m4.it_item.databinding.ActivityConfigBinding;

public class ConfigActivity extends Activity {
    private ActivityConfigBinding binding;
    private final int REQUEST_OK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_config);

        initMainData();
        setResult(REQUEST_OK);
        binding.vOut.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    private void initMainData() {
        binding.tvWelcome.setText(Me.getInstance().getNickname() + binding.tvWelcome.getText());
        Glide.with(this)
                .load(Me.getInstance().getThumbnail())
                .apply(RequestOptions.circleCropTransform())
                .into(binding.ivProfile);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.slide_out_right);
    }
}
