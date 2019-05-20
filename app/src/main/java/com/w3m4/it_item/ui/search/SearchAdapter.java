package com.w3m4.it_item.ui.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.Photo;
import com.w3m4.it_item.databinding.ItemSearchBinding;

import java.util.List;

public class SearchAdapter extends BaseRecyclerViewAdapter<Photo, SearchAdapter.ViewHolder> {
    RequestManager requestManager;

    public SearchAdapter(List<Photo> dataSet) {
        super(dataSet);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSearchBinding binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());
        return new ViewHolder(binding);
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        Photo photo = getItem(holder.getAdapterPosition());

        RequestOptions options = new RequestOptions();
        options.circleCrop();

        requestManager.load(photo.getImage())
                .apply(options)
                .into(holder.binding.ivImage);
        holder.binding.tvName.setText(photo.getName());
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemSearchBinding binding;

        ViewHolder(ItemSearchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
