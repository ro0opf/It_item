package com.w3m4.it_item.ui.mypage;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Me;
import com.w3m4.it_item.data.model.list.ListRepo;
import com.w3m4.it_item.databinding.ActivityMypageBinding;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

public class MyPageActivity extends AppCompatActivity {
    private ActivityMypageBinding binding;
    private RequestManager requestManager;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MyListAdapter myListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mypage);
        requestManager = Glide.with(this);

        initClickListener();
        initMainData();
        initMyListRcv(binding.rcvList);
        fetchMyListData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initMyListRcv(RecyclerView rcv) {
        myListAdapter = new MyListAdapter(new ArrayList<>());

        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(myListAdapter);
    }

    private void fetchMyListData() {
        disposable.add(ListRepo.getInstance().getMyList(Me.getInstance().getId())
                    .subscribe(data -> {
                        myListAdapter.setItems(data.getLists());
                    }, e-> {
                        e.printStackTrace();
                    })
        );
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
            binding.rcvList.setVisibility(View.VISIBLE);
            binding.rcvComment.setVisibility(View.INVISIBLE);
            setHeaderVisible(true);
        });

        binding.mypageToolbar.vMycomment.setOnClickListener(v -> {
            binding.mypageToolbar.vMycomment.setBackground(getResources().getDrawable(R.drawable.top_rounded_square));
            binding.mypageToolbar.vMylist.setBackground(null);
            binding.mypageToolbar.tvMycomment.setTextColor(getResources().getColor(R.color.colorMypageToolbar));
            binding.mypageToolbar.tvMylist.setTextColor(getResources().getColor(R.color.colorWhite));
            binding.rcvList.setVisibility(View.INVISIBLE);
            binding.rcvComment.setVisibility(View.VISIBLE);
            setHeaderVisible(false);
        });

        binding.fab.setOnClickListener(v -> {
            ListAddDialog listAddDialog = new ListAddDialog(this, android.R.style.Theme_Translucent_NoTitleBar);
            listAddDialog.setOnDismissListener(dialog -> {
                fetchMyListData();
            });
            listAddDialog.show();
        });

        binding.vBack.setOnClickListener(v->{
            onBackPressed();
        });
    }


    private void setHeaderVisible(boolean flag){
        int t = flag ? View.VISIBLE : View.GONE;
        binding.mypageToolbar.vHeader.setVisibility(t);
        binding.mypageToolbar.tvSort.setVisibility(t);
        binding.mypageToolbar.tvDelete.setVisibility(t);
        binding.mypageToolbar.vBorder.setVisibility(t);
        binding.fab.setVisibility(t);
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
