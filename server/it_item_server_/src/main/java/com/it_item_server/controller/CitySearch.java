package com.it_item_server.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CitySearch {

	@RequestMapping(value = "citySearch", method = RequestMethod.GET)
	public ResponseEntity<String> isValid(String id) {

		System.out.println("DEBUG 'citySearch' PAGE \t Input Value: " + id);

		try {

			// (1) 검색 가능한 도시 정보 결과 조회
//			User u = userService.printUser(id);

			JSONObject json = new JSONObject();

			List<String> availCities = new ArrayList<>();

			// 지워질 내용 --------시작
			availCities.add("osaka");
			availCities.add("tokyo");
			availCities.add("hokkaido");
			availCities.add("kyushu");
			availCities.add("hongkong");
			availCities.add("singapore");
			// 지워질 내용 ---------끝
			
			json.put("availCities", availCities);

			return new ResponseEntity<String>(json.toString(), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

		}
	}

	public static void main(String[] args) {

		JSONObject json = new JSONObject();

		List<String> availCities = new ArrayList<>();

		// 지워질 내용 --------시작
		availCities.add("osaka");
		availCities.add("tokyo");
		availCities.add("hokkaido");
		availCities.add("kyushu");
		availCities.add("hongkong");
		availCities.add("singapore");
		// 지워질 내용 ---------끝
		json.put("availCities", availCities);
		
		System.out.println(json);

	}

}
