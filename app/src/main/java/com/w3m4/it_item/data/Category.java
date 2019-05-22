package com.w3m4.it_item.data;

public class Category {
    private String code;
    private String name;
    private int img;
    private boolean isSelected = false;

    public Category(String code, String name, int img) {
        this.code = code;
        this.name = name;
        this.img = img;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
