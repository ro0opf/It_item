package com.it_item_server.model;

import java.sql.Date;

public class User {

	private String u_id, u_gender, u_nickname, u_personality, u_memberDegree, u_email;
	private int u_age;
	private Date u_date;
	private double u_point;

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_nickname() {
		return u_nickname;
	}

	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}

	public String getU_personality() {
		return u_personality;
	}

	public void setU_personality(String u_personality) {
		this.u_personality = u_personality;
	}

	public String getU_memberDegree() {
		return u_memberDegree;
	}

	public void setU_memberDegree(String u_memberDegree) {
		this.u_memberDegree = u_memberDegree;
	}

	public int getU_age() {
		return u_age;
	}

	public void setU_age(int u_age) {
		this.u_age = u_age;
	}

	public double getU_point() {
		return u_point;
	}

	public void setU_point(double u_point) {
		this.u_point = u_point;
	}

	public Date getU_date() {
		return u_date;
	}

	public void setU_date(Date u_date) {
		this.u_date = u_date;
	}

}
