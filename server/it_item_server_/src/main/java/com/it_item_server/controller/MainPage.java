package com.it_item_server.controller;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPage {
//	@RequestMapping(value = "mainPage", method = RequestMethod.GET)
//	public String isValid(String id) {
//
//		System.out.println("id::::::::"+ id);
//		
//		id = "jaehyeok";
//		System.out.println(id);
//
//		JSONObject json = new JSONObject();
//
//		ArrayList<JSONObject> temp = new ArrayList<>();
//		for (int i = 0; i < 3; i++) {
//			JSONObject sub = new JSONObject();
//
//			sub.put("userID", id);
//			sub.put("city", "오사카");
//			sub.put("title", id + "recommend " + "Osaka ITtem");
//
//			ArrayList<String> i_list = new ArrayList<>();
//			i_list.add("family_gift");
//			i_list.add("daily_necessity");
//			i_list.add("good snack");
//
//			sub.put("hashTag", i_list);
//
//			temp.add(sub);
//		}
//
//		json.put("mLists", temp);
//
//		return json.toString();
//	}
	@RequestMapping(value = "mainPage", method = RequestMethod.GET)
	public ResponseEntity<String> mainPageQuery(String id) {

		System.out.println("DEBUG 'MAIN_PAGE' PAGE \t Input Value: " + id);

		// (1) 유저의 성향을 받아 온다.

		// (2) 유저의 추천 리스트를 받아 온다.

		// (3) 응답해준다.

		System.out.println("id::::::::" + id);
		HttpHeaders responseHeaders = new HttpHeaders();

		id = "jaehyeok";
		System.out.println(id);

		JSONObject json = new JSONObject();

		ArrayList<JSONObject> temp = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			JSONObject sub = new JSONObject();

			sub.put("userID", id);
			sub.put("city", "오사카");
			sub.put("title", id + "recommend " + "Osaka ITtem");

			ArrayList<String> i_list = new ArrayList<>();
			i_list.add("family_gift");
			i_list.add("daily_necessity");
			i_list.add("good snack");

			sub.put("hashTag", i_list);

			temp.add(sub);
		}

		json.put("mLists", temp);

		return ResponseEntity.ok().headers(responseHeaders).body(json.toString());
	}
}
