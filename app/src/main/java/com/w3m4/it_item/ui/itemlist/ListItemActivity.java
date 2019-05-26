package com.w3m4.it_item.ui.itemlist;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ro0opf.livebus.livebus.LiveBus;
import com.w3m4.it_item.R;
import com.w3m4.it_item.data.mList;
import com.w3m4.it_item.databinding.ActivityListItemBinding;

import java.util.ArrayList;

public class ListItemActivity extends AppCompatActivity {
    private ActivityListItemBinding binding;
    private ListItemAdapter listItemAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_item);

        initMainUI();
        initItemRcv(binding.rcvItem);
        initObserve();
    }


    private void initItemRcv(RecyclerView rcv) {
        listItemAdapter = new ListItemAdapter(new ArrayList<>());
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(listItemAdapter);
    }

    private void initObserve() {
        LiveBus.getInstance().getBus("MyListAdapter")
                .observe(this, data -> {
                    mList d = (mList)data;
                    listItemAdapter.setItems(d.getItems());
                    if(listItemAdapter.getItemCount() > 0){
                        binding.tvNothing.setVisibility(View.INVISIBLE);
                        binding.vNothing.setVisibility(View.INVISIBLE);
                    }
                    binding.tvTitle.setText(d.getTitle());
                });
    }

    private void initMainUI() {
        Glide.with(this)
                .load(R.drawable.ic_crying)
                .apply(RequestOptions.centerCropTransform())
                .into(binding.vNothing);
    }
}
