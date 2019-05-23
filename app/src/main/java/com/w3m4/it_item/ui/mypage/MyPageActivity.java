package com.w3m4.it_item.ui.mypage;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Me;
import com.w3m4.it_item.databinding.ActivityMypageBinding;

public class MyPageActivity extends AppCompatActivity {
    private ActivityMypageBinding binding;
    private RequestManager requestManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mypage);
        requestManager = Glide.with(this);

        initClickListener();
        initMainData();
    }

    private void initMainData() {
        requestManager.load(Me.getInstance().getThumbnail())
                .apply(RequestOptions.circleCropTransform())
                .into(binding.ivProfile);

        requestManager.load(R.drawable.ic_crown)
                .apply(RequestOptions.centerCropTransform())
                .into(binding.ivUserDegree);

        binding.tvUserNick.setText(Me.getInstance().getNickname());
    }

    private void initClickListener() {
        binding.mypageToolbar.vMylist.setOnClickListener(v -> {
            binding.mypageToolbar.vMylist.setBackground(getResources().getDrawable(R.drawable.top_rounded_square));
            binding.mypageToolbar.vMycomment.setBackground(null);
            binding.mypageToolbar.tvMycomment.setTextColor(getResources().getColor(R.color.colorWhite));
            binding.mypageToolbar.tvMylist.setTextColor(getResources().getColor(R.color.colorMypageToolbar));
        });

        binding.mypageToolbar.vMycomment.setOnClickListener(v -> {
            binding.mypageToolbar.vMycomment.setBackground(getResources().getDrawable(R.drawable.top_rounded_square));
            binding.mypageToolbar.vMylist.setBackground(null);
            binding.mypageToolbar.tvMycomment.setTextColor(getResources().getColor(R.color.colorMypageToolbar));
            binding.mypageToolbar.tvMylist.setTextColor(getResources().getColor(R.color.colorWhite));
        });

        binding.fab.setOnClickListener(v -> {
            ListAddDialog listAddDialog = new ListAddDialog(this, android.R.style.Theme_Translucent_NoTitleBar);
            listAddDialog.show();
        });
    }
}
