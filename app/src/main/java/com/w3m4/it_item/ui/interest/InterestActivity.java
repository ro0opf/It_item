package com.w3m4.it_item.ui.interest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.w3m4.it_item.R;
import com.w3m4.it_item.databinding.ActivityInterestBinding;

public class InterestActivity extends AppCompatActivity {
    private ActivityInterestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_interest);
    }
}
