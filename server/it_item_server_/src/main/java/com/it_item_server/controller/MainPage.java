package com.it_item_server.controller;

import java.util.ArrayList;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPage {
	@RequestMapping(value = "mainPage", method = RequestMethod.GET)
	public String isValid(String id) {

		System.out.println(id);

		JSONObject json = new JSONObject();

		ArrayList<String> list = new ArrayList<>();
		list.add("tokyo");
		list.add("osaka");
		list.add("fukuoka");
		list.add("paris");

		json.put("cities", list);

		for (int i = 0; i < list.size(); i++) {
			JSONObject sub = new JSONObject();

			sub.put("city", list.get(i));

			ArrayList<String> i_list = new ArrayList<>();
			i_list.add("family_gift");
			i_list.add("daily_necessity");
			i_list.add("good snack");

			sub.put("items", i_list);

			json.put("it_item", sub);
		}

		return json.toString();
	}
}
