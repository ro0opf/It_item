package com.w3m4.it_item.ui.search;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.databinding.ItemSearchBinding;

import java.util.List;

public class CityAdapter extends BaseRecyclerViewAdapter<City, CityAdapter.ViewHolder> {
    RequestManager requestManager;
    public MutableLiveData<City> cityLiveData = new MutableLiveData<>();

    public CityAdapter(List<City> dataSet) {
        super(dataSet);
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        holder.binding.tvName.setText(getItem(position).getName());
        requestManager.load(getItem(position).getBg())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.binding.ivImage);
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSearchBinding binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(binding);
        binding.clMain.setOnClickListener(v -> {
            cityLiveData.setValue(getItem(viewHolder.getAdapterPosition()));
        });
        return viewHolder;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemSearchBinding binding;

        ViewHolder(ItemSearchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
