package com.it_item_server.model;

import java.sql.Date;

public class Student {
	String name;
	int age;
	String registrationNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public static void main(String... args) {
		Date d = new Date(System.currentTimeMillis());
		
		System.out.println(d);
		
	}
}