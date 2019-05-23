package com.w3m4.it_item.ui.interest;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.databinding.ItemCityBinding;

import java.util.List;

public class CityAdapter extends BaseRecyclerViewAdapter<City, CityAdapter.ViewHolder> {
    RequestManager requestManager;

    public CityAdapter(List<City> dataSet) {
        super(dataSet);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCityBinding binding = ItemCityBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());

        return new ViewHolder(binding);
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        City city = getItem(holder.getAdapterPosition());

        RequestOptions options = new RequestOptions();
        options.circleCrop();

        requestManager.load(city.getBg())
                .apply(options)
                .into(holder.binding.ivCityImage);
        holder.binding.tvCityName.setText((city.getName()));

        holder.binding.clMain.setOnClickListener(v -> {
            if (city.isSelected()) {
                city.setSelected(false);
            } else {
                city.setSelected(true);
            }
        });

//        ViewGroup.LayoutParams layoutParams=holder.binding.clMain.getLayoutParams();
//        ViewGroup parent=(ViewGroup)holder.binding.clMain.getParent();
//        layoutParams.height=(int)(parent.getHeight()*0.5);
//        holder.binding.clMain.setLayoutParams(layoutParams);
//
//
//
////        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
////        View itemView = inflater.inflate(R.layout.item_category, parent, false);
////
////        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
////        layoutParams.height = (int) (parent.getHeight() * 0.5);
////        itemView.setLayoutParams(layoutParams);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemCityBinding binding;

        public ViewHolder(@NonNull ItemCityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
