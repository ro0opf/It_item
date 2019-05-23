package com.w3m4.it_item.ui.main;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.Category;
import com.w3m4.it_item.databinding.ItemMainCategoryBinding;
import com.w3m4.it_item.ui.search.SearchCategoryActivity;

import java.util.List;

public class CategoryAdapter extends BaseRecyclerViewAdapter<Category, CategoryAdapter.ViewHolder> {

    private RequestManager requestManager;

    public CategoryAdapter(List<Category> dataSet) {
        super(dataSet);
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.transforms(new CenterCrop(),
                new RoundedCorners(20));

        if (position != 0) {
            requestManager.load(getItem(position).getImg())
                    .apply(requestOptions)
                    .into(holder.binding.ivBg);

            holder.binding.ivSearch.setVisibility(View.GONE);
            holder.binding.tvMain.setVisibility(View.GONE);
        }else{
            requestManager.load(R.drawable.square)
                    .apply(requestOptions)
                    .into(holder.binding.ivBg);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMainCategoryBinding binding = ItemMainCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(binding);
        viewHolder.binding.clMain.setOnClickListener(v -> {
            if (viewHolder.getAdapterPosition() == 0) {
                parent.getContext().startActivity(new Intent(parent.getContext(), SearchCategoryActivity.class));
            }
        });
        return viewHolder;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemMainCategoryBinding binding;

        public ViewHolder(@NonNull ItemMainCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
