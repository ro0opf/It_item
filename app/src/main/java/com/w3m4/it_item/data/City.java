package com.w3m4.it_item.data;

public class City {
    private int bg;
    private String name;
    private boolean isSelected = false;

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public City(int bg, String name) {
        this.bg = bg;
        this.name = name;
    }
}
