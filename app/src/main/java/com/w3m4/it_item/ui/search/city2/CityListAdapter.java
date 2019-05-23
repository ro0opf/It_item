package com.w3m4.it_item.ui.search.city2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.mList;
import com.w3m4.it_item.databinding.ItemCity2ListBinding;

import java.util.List;

public class CityListAdapter extends BaseRecyclerViewAdapter<mList, CityListAdapter.ViewHolder> {
    RequestManager requestManager;

    public CityListAdapter(List<mList> dataSet) {
        super(dataSet);
    }

    @Override
    public void onBindView(CityListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public CityListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCity2ListBinding binding = ItemCity2ListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(binding);

        return viewHolder;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemCity2ListBinding binding;

        ViewHolder(ItemCity2ListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
