package com.w3m4.it_item.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class mList {
    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("userID")
    @Expose
    private String userNickname;

    @SerializedName("hashtag")
    @Expose
    private ArrayList<String> tags;

    @SerializedName("thumbnailUrl")
    @Expose
    private String listThumbnailUrl;

    @SerializedName("items")
    @Expose
    private ArrayList<Item> items;

    public mList(String city, String title, String userNickname, ArrayList<String> tags, String listThumbnailUrl) {
        this.city = city;
        this.title = title;
        this.userNickname = userNickname;
        this.tags = tags;
        this.listThumbnailUrl = listThumbnailUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getListThumbnailUrl() {
        return listThumbnailUrl;
    }

    public void setListThumbnailUrl(String listThumbnailUrl) {
        this.listThumbnailUrl = listThumbnailUrl;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
