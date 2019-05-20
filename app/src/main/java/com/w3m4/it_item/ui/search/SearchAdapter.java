package com.w3m4.it_item.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.common.BaseRecyclerViewAdapter;
import com.w3m4.it_item.data.model.Photo;

import java.util.List;

public class SearchAdapter extends BaseRecyclerViewAdapter<Photo,SearchAdapter.ViewHolder> {
    Context context;
    public SearchAdapter(List<Photo> dataSet, Context context) {
        super(dataSet);
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        Photo photo = getItem(holder.getAdapterPosition());

        RequestOptions options = new RequestOptions();
        options.circleCrop();

        Glide.with(context)
                .load(photo.getImage())
                .apply(options)
                .into(holder.image);
        holder.name.setText(photo.getName());
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;

        ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            name = (TextView) itemView.findViewById(R.id.imageName);
        }
    }
}
