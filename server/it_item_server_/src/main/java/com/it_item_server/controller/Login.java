package com.it_item_server.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it_item_server.model.User;
import com.it_item_server.model.UserService;

@RestController
public class Login {

	// 유효한 사용자
	@Autowired
	private UserService userService;

	// (1) ACCESS VALID USER
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ResponseEntity<String> isValid(String id) {

		System.out.println("DEBUG 'LOGIN' PAGE \t Input Value: " + id);

		try {

			User u = userService.printUser(id);

			JSONObject json = new JSONObject();

			json.put("u_id", u.getU_id());
			json.put("u_age", u.getU_age());
			json.put("u_gender", u.getU_gender());
			json.put("u_date", u.getU_date());
			json.put("u_nickname", u.getU_nickname());
			json.put("u_point", u.getU_point());
			json.put("u_personality", u.getU_personality());

			return new ResponseEntity<String>(json.toString(), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

		}
	}

	// (2) Register USER, 추가작업 필요
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public ResponseEntity<String> addUser() {

		System.out.println("DEBUG 'REGISTER' PAGE");

		JSONObject json = new JSONObject();

		json.put("responseCode", 200);
		json.put("responseDescription", "OK");
		json.put("status", "user_register");

		return new ResponseEntity<String>(json.toString(), HttpStatus.OK);

	}

//	@RequestMapping(value = "user", method = RequestMethod.GET)
//	public String isValid(@PathVariable("u_id") String id) {
//
//		System.out.println("ID" + id);
//
//		return "hi";
//	}

}
