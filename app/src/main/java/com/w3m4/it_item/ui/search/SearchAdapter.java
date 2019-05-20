package com.w3m4.it_item.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Dimension;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.data.model.Photo;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    private ArrayList<Photo> photoList;
    private int itemLayout;
    private Context context;

    /**
     * RecyclerAdapter 생성자
     * */
    public SearchAdapter(ArrayList<Photo> photoList, int itemLayout, Context context) {
        this.photoList = photoList;
        this.itemLayout = itemLayout;
        this.context = context;
    }

    /**
     * Layout 을 ViewHolder 에 저장
     * */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    public static int sCorner = 15;
    public static int sMargin = 2;
    public static int sBorder = 10;
    public static String sColor = "#7D9067";

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Photo photo = photoList.get(position);

        RequestOptions options = new RequestOptions();
        options.circleCrop();

        Glide.with(context)
                .load(photo.getImage())
                .apply(options)
                .into(holder.image);

        holder.name.setText(photo.getName());
    }

    /**
     * List의 크기
     * */
    @Override
    public int getItemCount() {
        return photoList.size();
    }

    /**
     * View 재활용을 위한 ViewHolder
     * */
    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageView);
            name = (TextView) itemView.findViewById(R.id.imageName);
        }
    }
}
