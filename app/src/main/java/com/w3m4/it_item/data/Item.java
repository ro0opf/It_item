package com.w3m4.it_item.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("i_category_specific")
    @Expose
    private String categorySpecific;

    @SerializedName("i_price_max")
    @Expose
    private int maxPrice;

    @SerializedName("i_price_min")
    @Expose
    private int minPrice;

    @SerializedName("i_name")
    @Expose
    private String name;

    @SerializedName("i_likes")
    @Expose
    private int likes;

    @SerializedName("i_info")
    @Expose
    private String info;

    @SerializedName("i_image_url")
    @Expose
    private String imageUrl;
    @SerializedName("i_japan_name")
    @Expose
    private String japanName;

    public Item(String categorySpecific, int maxPrice, int minPrice, String name, int likes, String info, String imageUrl, String japanName) {
        this.categorySpecific = categorySpecific;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.name = name;
        this.likes = likes;
        this.info = info;
        this.imageUrl = imageUrl;
        this.japanName = japanName;
    }

    public String getCategorySpecific() {
        return categorySpecific;
    }

    public void setCategorySpecific(String categorySpecific) {
        this.categorySpecific = categorySpecific;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getJapanName() {
        return japanName;
    }

    public void setJapanName(String japanName) {
        this.japanName = japanName;
    }
}
