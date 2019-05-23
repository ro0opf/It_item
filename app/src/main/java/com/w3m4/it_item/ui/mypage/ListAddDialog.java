package com.w3m4.it_item.ui.mypage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.w3m4.it_item.R;
import com.w3m4.it_item.databinding.DialogListAddBinding;

public class ListAddDialog extends Dialog {
    private DialogListAddBinding binding;

    public ListAddDialog(@NonNull Context context) {
        super(context);
    }

    public ListAddDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.dialog_list_add, null, false);
        setContentView(binding.getRoot());

        initClickListener();
    }

    private void initClickListener() {
        binding.clMain.setOnClickListener(v -> {
            this.dismiss();
        });

        binding.btnCancel.setOnClickListener(v -> {
            this.dismiss();
        });

        binding.btnCreate.setOnClickListener(v -> {
            // TODO :: List Create
        });
        binding.vBody.setOnClickListener(v -> {
            Log.e("#ListAddDialog", "1");
        });
    }
}