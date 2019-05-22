package com.w3m4.it_item.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.mList;
import com.w3m4.it_item.databinding.ItemListBinding;

import java.util.List;

public class ListAdapter extends BaseRecyclerViewAdapter<mList, ListAdapter.ViewHolder> {

    private RequestManager requestManager;
    public ListAdapter(List<mList> dataSet) {
        super(dataSet);
    }

    @Override
    public void onBindView(ListAdapter.ViewHolder holder, int position) {
        holder.binding.tvTitle.setText(getItem(position).getTitle());
        requestManager.load(R.drawable.kyoto_main)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(35)))
                .into(holder.binding.ivImage);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(binding);
        return viewHolder;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ItemListBinding binding;
        public ViewHolder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
