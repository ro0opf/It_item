package com.w3m4.it_item.ui.search.city2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.Item;
import com.w3m4.it_item.data.mList;
import com.w3m4.it_item.databinding.ItemCity2ListBinding;

import java.util.ArrayList;
import java.util.List;

public class CityListAdapter extends BaseRecyclerViewAdapter<mList, CityListAdapter.ViewHolder> {
    RequestManager requestManager;
    Context context;
    public CityListAdapter(List<mList> dataSet) {
        super(dataSet);
    }

    @Override
    public void onBindView(CityListAdapter.ViewHolder holder, int position) {
        holder.binding.tvUser.setText(getItem(position).getUserNickname() + context.getString(R.string.search_city_list_user));
        holder.binding.tvTitle.setText(getItem(position).getTitle());
        ArrayList<Item> items = getItem(position).getItems();

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.transforms(new CenterCrop());
        requestOptions.placeholder(R.drawable.ic_no_photo);
        requestManager.load(items.get(0).getImageUrl())
                .apply(requestOptions)
                .into(holder.binding.ivItem1);

        requestManager.load(items.get(1).getImageUrl())
                .apply(requestOptions)
                .into(holder.binding.ivItem2);

        requestManager.load(items.get(2).getImageUrl())
                .apply(requestOptions)
                .into(holder.binding.ivItem3);
        holder.binding.setNumberOfItem("총 " + String.valueOf(items.size()) + " items");
    }

    @Override
    public CityListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCity2ListBinding binding = ItemCity2ListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
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
