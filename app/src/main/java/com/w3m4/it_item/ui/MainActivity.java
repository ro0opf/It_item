package com.w3m4.it_item.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;

import com.w3m4.it_item.R;
import com.w3m4.it_item.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initMotionLayout();
    }

    void initMotionLayout() {
        binding.nsvMain.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (scrollY > 1000 && !flag) {
                binding.mlMain.transitionToEnd();
                flag = true;
            }
            if (scrollY < 1000 && flag) {
                binding.mlMain.transitionToStart();
                flag = false;
            }
        });
    }


}
