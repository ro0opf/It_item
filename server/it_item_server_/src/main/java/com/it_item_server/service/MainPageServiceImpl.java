package com.it_item_server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it_item_server.DAO.MainPageDao;
import com.it_item_server.model.MainPageService;
import com.it_item_server.model.MainPageStruct;

@Service
public class MainPageServiceImpl implements MainPageService {

	@Autowired
	private MainPageDao mainPage_dao;

	@Override
	public List<MainPageStruct> printMainPage() {

		List<MainPageStruct> mainP = mainPage_dao.getMainPage();

		return mainP;
	}

}
