package com.w3m4.it_item.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class mLists {
    @SerializedName("mLists")
    @Expose
    private List<mList> lists;

    public mLists(List<mList> lists) {
        this.lists = lists;
    }

    public List<mList> getLists() {
        return lists;
    }

    public void setLists(List<mList> lists) {
        this.lists = lists;
    }
}
