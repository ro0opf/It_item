package com.w3m4.it_item.ui.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.data.model.Photo;
import com.w3m4.it_item.databinding.ItemSearchBinding;

import java.util.List;

public class SouvenirAdapter extends BaseRecyclerViewAdapter<Photo, SouvenirAdapter.ViewHolder> {
    RequestManager requestManager;
    private Context context;

    public SouvenirAdapter(Context context, List<Photo> dataSet)
    {
        super(dataSet);
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSearchBinding binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        requestManager = Glide.with(parent.getContext());

        return new ViewHolder(binding);
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        Photo photo = getItem(holder.getAdapterPosition());

        RequestOptions options = new RequestOptions();
        options.circleCrop();

        requestManager.load(photo.getImage())
                .apply(options)
                .into(holder.binding.ivImage);
        holder.binding.tvName.setText(photo.getName());

        holder.binding.clMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                ((Activity)context).startActivityForResult(intent, position);

                City city=City.valueOf(position);
                if(city==City.TOKYO)
                {



                }else if(city==City.OSAKA)
                {

                }else if(city==City.KYOTO)
                {

                }else if(city==City.KYUSU)
                {

                }else if(city==City.SAPPORO)
                {

                }else if(city==City.HOKKAIDO)
                {

                }



            }
        });
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemSearchBinding binding;

        ViewHolder(ItemSearchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
