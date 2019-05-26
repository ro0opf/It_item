package com.w3m4.it_item.ui.mypage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.google.gson.JsonObject;
import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Me;
import com.w3m4.it_item.data.model.list.ListRepo;
import com.w3m4.it_item.databinding.DialogListAddBinding;

import io.reactivex.disposables.CompositeDisposable;

public class ListAddDialog extends Dialog {
    private DialogListAddBinding binding;
    private CompositeDisposable disposable = new CompositeDisposable();

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
            dismiss();
        });

        binding.btnCancel.setOnClickListener(v -> {
            dismiss();
        });

        binding.btnCreate.setOnClickListener(v -> {
            fetchAddMyList();
        });
        binding.vBody.setOnClickListener(v -> {
            Log.e("#ListAddDialog", "1");
        });
    }

    private void fetchAddMyList(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", Me.getInstance().getId());
        jsonObject.addProperty("title", binding.edtList.getText().toString());

        disposable.add(ListRepo.getInstance().addMyList(jsonObject)
                .doOnSuccess(data -> {
                    dismiss();
                })
                .subscribe(data -> {

                }, e->{
                    Log.e("#$Main", e.getMessage());
                })
        );
    }

    @Override
    public void dismiss() {
        disposable.dispose();
        super.dismiss();
    }
}