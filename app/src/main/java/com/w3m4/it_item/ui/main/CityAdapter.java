package com.w3m4.it_item.ui.main;

import android.content.Intent;
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
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.data.mList;
import com.w3m4.it_item.databinding.ItemCityBinding;
import com.w3m4.it_item.databinding.ItemListBinding;
import com.w3m4.it_item.ui.city.SearchActivity;

import java.util.List;

public class CityAdapter extends BaseRecyclerViewAdapter<City, CityAdapter.ViewHolder> {

    private RequestManager requestManager;
    public CityAdapter(List<City> dataSet) {
        super(dataSet);
    }

    @Override
    public void onBindView(CityAdapter.ViewHolder holder, int position) {
        if(position != 0){
            requestManager.load(getItem(position).getBg())
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.binding.ivBg);

            holder.binding.ivSearch.setVisibility(View.GONE);
            holder.binding.tvMain.setText(getItem(position).getName());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCityBinding binding = ItemCityBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(binding);
        viewHolder.binding.clMain.setOnClickListener(v->{
            if(viewHolder.getAdapterPosition() == 0){
                parent.getContext().startActivity(new Intent(parent.getContext(), SearchActivity.class));
            }
        });
        return viewHolder;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ItemCityBinding binding;
        public ViewHolder(@NonNull ItemCityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}