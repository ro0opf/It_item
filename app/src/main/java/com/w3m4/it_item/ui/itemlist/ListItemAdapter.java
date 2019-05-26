package com.w3m4.it_item.ui.itemlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.Item;
import com.w3m4.it_item.databinding.ItemListDetailBinding;

import java.util.List;

public class ListItemAdapter extends BaseRecyclerViewAdapter<Item, ListItemAdapter.ViewHolder> {

    private RequestManager requestManager;

    public ListItemAdapter(List<Item> dataSet) {
        super(dataSet);
    }

    @Override
    public void onBindView(ListItemAdapter.ViewHolder holder, int position) {
        holder.binding.tvTitle.setText(getItem(position).getName());
        holder.binding.tvDetail.setText(getItem(position).getInfo());
        requestManager.load(getItem(position).getImageUrl())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.binding.ivImage);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDetailBinding binding = ItemListDetailBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(binding);

        return viewHolder;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemListDetailBinding binding;

        public ViewHolder(@NonNull ItemListDetailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
