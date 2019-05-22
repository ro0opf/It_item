package com.w3m4.it_item.ui.interest;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.Category;
import com.w3m4.it_item.databinding.ItemCategoryBinding;

import java.util.List;

public class CategoryAdapter extends BaseRecyclerViewAdapter<Category, CategoryAdapter.ViewHolder> {
    public CategoryAdapter(List<Category> dataSet) {
        super(dataSet);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindView(CategoryAdapter.ViewHolder holder, int position) {
        holder.binding.ivCategoryImage.setImageDrawable(Drawable.createFromPath(getItem(position).getCode()));
        holder.binding.ivCategoryImage.setImageDrawable(Drawable.createFromPath(getItem(position).getName()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryBinding binding;

        public ViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

