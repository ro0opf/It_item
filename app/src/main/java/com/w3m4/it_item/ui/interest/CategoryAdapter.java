package com.w3m4.it_item.ui.interest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.Category;
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

        RequestOptions options = new RequestOptions();
        options.circleCrop();

        requestManager.load(category.getImg())
                .apply(options)
                .into(holder.binding.ivCategoryImage);

        requestManager.load(R.drawable.ic_checked)
                .apply(options)
                .into(holder.binding.ivSelected);

        // 체크된 상태 초기화 -> 추후 입력받은 데이터에 따라 로딩
        initCheckedStatus(holder.binding.ivSelected);

        holder.binding.tvCategoryName.setText(category.getName());

        holder.binding.clMain.setOnClickListener(v -> {
            if (holder.binding.ivSelected.getVisibility() == View.VISIBLE) // 보일 경우
            {
                holder.binding.ivSelected.setVisibility(View.INVISIBLE); // -> 안보이게
            } else // 안 보일 경우
            {
                holder.binding.ivSelected.setVisibility(View.VISIBLE); // -> 보이게
            }
        });
    }

    private void initCheckedStatus(ImageView imageView)
    {
        // 선택된 상태에 따라 -> 추후 코드 변경 필요
        //
        imageView.setVisibility(View.INVISIBLE);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemCategoryBinding binding;

        public ViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

