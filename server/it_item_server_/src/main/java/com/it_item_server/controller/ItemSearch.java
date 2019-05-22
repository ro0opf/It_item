package com.it_item_server.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ItemSearch {
	@RequestMapping(value = "itemSearch", method = RequestMethod.GET)
	public ResponseEntity<String> isValid(String id) {

		System.out.println("DEBUG 'itemSearch' PAGE \t Input Value: " + id);

		try {

			// (1) 검색 가능한 도시 정보 결과 조회
//			User u = userService.printUser(id);

			JSONObject json = new JSONObject();

			List<String> availCities = new ArrayList<>();

			// 지워질 내용 --------시작
			availCities.add("Drink");
			availCities.add("Beauty");
			availCities.add("Drug");
			availCities.add("Snack");
			availCities.add("local_special");
			availCities.add("toy");
			// 지워질 내용 ---------끝

			json.put("availItems", availCities);

			return new ResponseEntity<String>(json.toString(), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

		}
	}

}
