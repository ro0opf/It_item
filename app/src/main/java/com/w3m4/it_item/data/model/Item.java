package com.w3m4.it_item.data.model;

public class Item {

    private String userId;
    private String name;
    private int [] photoId;

    public Item(String userId, String name, int[] photoId) {
        this.userId = userId;
        this.name = name;
        this.photoId = photoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int[] photoId) {
        this.photoId = photoId;
    }
}
