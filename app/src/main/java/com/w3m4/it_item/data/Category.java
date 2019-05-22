package com.w3m4.it_item.data;

public class Category {
    private String code;
    private String name;
    private Photo photo;

    public Category(String code, String name, Photo photo) {
        this.code = code;
        this.name = name;
        this.photo = photo;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
