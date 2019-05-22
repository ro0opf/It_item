package com.it_item_server.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPage {

	@RequestMapping(value = "myPage", method = RequestMethod.GET)
	public ResponseEntity<String> mainPageQuery(String url) {

		System.out.println("DEBUG 'MY_PAGE and MY_PICK' PAGE \t Input Value: " + url);

		System.out.println("id::::::::" + url);

		StringTokenizer st = new StringTokenizer(url, "/");
		String id = st.nextToken();
		String subPath = st.nextToken();

		JSONObject json = new JSONObject();
		json.put("u_memberDegree", "Bronze");

		// (1) Path - MyPick
		if (subPath.equals("myPick")) {

			ArrayList<JSONObject> items = new ArrayList<>();

			for (int i = 0; i < 3; i++) {

				JSONObject subJson = new JSONObject();
				subJson.put("i_name", "시로이코이비토" + i);
				subJson.put("i_like", 146);
				subJson.put("i_info", "링그드샤");
				subJson.put("i_price_min", 900);
				subJson.put("i_price_max", 1050);
				subJson.put("i_imageUrl", "http:vdi.skcc.com");
				subJson.put("i_start", 5);

				items.add(subJson);
			}

			json.put("items", items);
		}

		// (2) Path - comment
		else if (subPath.equals("comment")) {

			ArrayList<JSONObject> reviews = new ArrayList<>();

			for (int i = 0; i < 3; i++) {

				JSONObject subJson = new JSONObject();
				subJson.put("re_comment", "직구하고싶어요");
				subJson.put("re_date", new Date(System.currentTimeMillis()));

				reviews.add(subJson);
			}

			json.put("reviews", reviews);
		}

		return new ResponseEntity<String>(json.toString(), HttpStatus.OK);
	}

}
