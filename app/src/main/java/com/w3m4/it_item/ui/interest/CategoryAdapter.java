package com.w3m4.it_item.ui.interest;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.Category;
import com.w3m4.it_item.data.Photo;
import com.w3m4.it_item.databinding.ItemCategoryBinding;

import java.util.List;

public class CategoryAdapter extends BaseRecyclerViewAdapter<Category, CategoryAdapter.ViewHolder> {
    RequestManager requestManager;

    public CategoryAdapter(List<Category> dataSet) {
        super(dataSet);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());

        return new ViewHolder(binding);
    }

    @Override
    public void onBindView(CategoryAdapter.ViewHolder holder, int position) {
        Category category = getItem(holder.getAdapterPosition());
        Photo photo = category.getPhoto();

        RequestOptions options = new RequestOptions();
        options.circleCrop();

        requestManager.load(photo.getImage())
                .apply(options)
                .into(holder.binding.ivCategoryImage);
        holder.binding.tvCategoryName.setText(category.getName());

        holder.binding.clMain.setOnClickListener(v -> {
            if (category.isSelected()) {
                category.setSelected((false));
            } else {
                category.setSelected((true));
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryBinding binding;

        public ViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

