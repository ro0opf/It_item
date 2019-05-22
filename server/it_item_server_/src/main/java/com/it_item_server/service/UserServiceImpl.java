package com.it_item_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it_item_server.DAO.UserDao;
import com.it_item_server.model.User;
import com.it_item_server.model.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao user_dao;

	@Override
	public User printUser(String u_id) {
		
		User user = user_dao.getUser(u_id);

		return user;
	}

}
