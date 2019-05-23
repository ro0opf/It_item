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
    private String userID;

    @SerializedName("userNickname")
    @Expose
    private String userNickname;


    @SerializedName("hashTag")
    @Expose
    private ArrayList<String> tags;

    public mList(String city, String title, String userID, ArrayList<String> tags) {
        this.city = city;
        this.title = title;
        this.userID = userID;
        this.tags = tags;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
