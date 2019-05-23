package com.w3m4.it_item.ui.interest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
    private Context context;

    public CityAdapter(List<City> dataSet, Context context) {
        super(dataSet);
        this.context=context;
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

        // 체크된 상태 초기화 -> 추후 입력받은 데이터에 따라 로딩
        initCheckedStatus(holder.binding.ivSelected);

        holder.binding.tvCityName.setText(city.getName());

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
        ItemCityBinding binding;

        public ViewHolder(@NonNull ItemCityBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
