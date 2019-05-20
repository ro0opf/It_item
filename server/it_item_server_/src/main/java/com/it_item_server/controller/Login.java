package com.it_item_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.it_item_server.database.UserMapper;
import com.it_item_server.model.User;

@RestController
public class Login {

	// 유효한 사용자
//
//	@Autowired
//	private UserMapper userMapper;
//
//	@RequestMapping(value = "user", method = RequestMethod.GET)
//	public String isValid(@PathVariable("u_id") String id) {
//
//		User user = userMapper.findById(id);
//		
//		System.err.println("User NickName" + user.getU_nickname());
//		
//		return "hi";
//	}

	// 유효하지 않은 사용자 - 새로운 사용자 등록
	@RequestMapping(value = "user", method = RequestMethod.POST)
	@ResponseBody
	public String registerStudent(@RequestBody String student) {
		System.err.println("In registerStudent");
//		StudentRegistrationReply stdregreply = new StudentRegistrationReply();
////		StudentRegistration.getInstance().add(student);
//		// We are setting the below value just to reply a message back to the caller
//		stdregreply.setName(student.getName());
//		stdregreply.setAge(student.getAge());
//		stdregreply.setRegistrationNumber(student.getRegistrationNumber());
//		stdregreply.setRegistrationStatus("Successful");
		return "hello";
	}

}
