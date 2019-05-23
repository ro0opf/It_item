package com.w3m4.it_item.ui.search.city2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.mList;
import com.w3m4.it_item.databinding.ItemCity2CategoryBinding;

import java.util.List;

public class CityCategoryAdapter extends BaseRecyclerViewAdapter<mList, CityCategoryAdapter.ViewHolder> {
    RequestManager requestManager;

    public CityCategoryAdapter(List<mList> dataSet) {
        super(dataSet);
    }

    @Override
    public void onBindView(CityCategoryAdapter.ViewHolder holder, int position) {

    }

    @Override
    public CityCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCity2CategoryBinding binding = ItemCity2CategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(binding);

        return viewHolder;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemCity2CategoryBinding binding;

        ViewHolder(ItemCity2CategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
