package com.it_item_server.model;

public class ItemStruct {

	private String i_name, i_japan_name, i_info, i_image_url, i_category_specific;
	private double i_price_min, i_price_max;
	private int like;

	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}

	public String getI_japan_name() {
		return i_japan_name;
	}

	public void setI_japan_name(String i_japan_name) {
		this.i_japan_name = i_japan_name;
	}

	public String getI_info() {
		return i_info;
	}

	public void setI_info(String i_info) {
		this.i_info = i_info;
	}

	public String getI_image_url() {
		return i_image_url;
	}

	public void setI_image_url(String i_image_url) {
		this.i_image_url = i_image_url;
	}

	public String getI_category_specific() {
		return i_category_specific;
	}

	public void setI_category_specific(String i_category_specific) {
		this.i_category_specific = i_category_specific;
	}

	public double getI_price_min() {
		return i_price_min;
	}

	public void setI_price_min(double i_price_min) {
		this.i_price_min = i_price_min;
	}

	public double getI_price_max() {
		return i_price_max;
	}

	public void setI_price_max(double i_price_max) {
		this.i_price_max = i_price_max;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

}
