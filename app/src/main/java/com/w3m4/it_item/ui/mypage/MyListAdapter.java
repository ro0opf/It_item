package com.w3m4.it_item.ui.mypage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.ro0opf.livebus.livebus.LiveBus;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.mList;
import com.w3m4.it_item.databinding.ItemMypageListBinding;
import com.w3m4.it_item.ui.itemlist.ListItemActivity;

import java.util.List;

public class MyListAdapter extends BaseRecyclerViewAdapter<mList, MyListAdapter.ViewHolder> {
    RequestManager requestManager;
    Context context;

    public MyListAdapter(List<mList> dataSet) {
        super(dataSet);
    }

    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMypageListBinding binding = ItemMypageListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(binding);
        context = parent.getContext();
        return new ViewHolder(binding);
    }

    @Override
    public void onBindView(MyListAdapter.ViewHolder holder, int position) {
        holder.binding.tvTitle.setText(getItem(position).getTitle());
        holder.binding.clMain.setOnClickListener(v-> {
            Intent i = new Intent(context, ListItemActivity.class);
            Log.e("#$Main", getItem(position).getItems().size() + "");
            LiveBus.getInstance().sendBus("MyListAdapter", getItem(position));
            context.startActivity(i);
        });
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemMypageListBinding binding;

        ViewHolder(ItemMypageListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
