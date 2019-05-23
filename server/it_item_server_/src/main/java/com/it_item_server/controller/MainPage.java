package com.it_item_server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it_item_server.model.ItemStruct;
import com.it_item_server.model.MainPageService;
import com.it_item_server.model.MainPageStruct;

@RestController
public class MainPage {

	@Autowired
	private MainPageService mainPageService;

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

		List<MainPageStruct> mP = (List<MainPageStruct>) mainPageService.printMainPage();

		System.out.println("@@@@@@@@@@@@@@@@@@@@");

		Set<String> userNickMap = ConcurrentHashMap.newKeySet();

		JSONObject json = new JSONObject();
		ArrayList<JSONObject> mList = new ArrayList<>();

		for (int i = 0; i < mP.size(); i++) {

			String curID = mP.get(i).getRe_u_id();

			if (curID.equals(id)) {

				String userNick = mP.get(i).getU_nickname();

				// 유효값일 경우
				if (!userNickMap.contains(userNick)) {
					userNickMap.add(userNick);

					JSONObject subJson = new JSONObject();

					subJson.put("userID", userNick);
					subJson.put("city", mP.get(i).getC_id());
					subJson.put("title", mP.get(i).getRe_title());
					
					String thumbnailUrl = "https://192.168.0.49:8080/image/"+ userNick;
					
					subJson.put("thumbnailUrl", thumbnailUrl);
					ArrayList<String> hashTags = new ArrayList<>();
					
					ArrayList<JSONObject> eachItems = new ArrayList<>();
					ConcurrentHashMap<String, ItemStruct> eachItem = new ConcurrentHashMap<>();

					for (int j = 0; j < mP.size(); j++) {
						String cmpNick = mP.get(j).getU_nickname();

						if (userNick.equals(cmpNick)) {
							String hash = mP.get(j).getI_category_specific();
							hashTags.add(hash);

//							ItemStruct item = new ItemStruct();
//							item.setI_name(mP.get(j).getI_name());
//							item.setI_japan_name(mP.get(j).getI_japan_name());
//							item.setI_info(mP.get(j).getI_info());
//							item.setI_image_url(mP.get(j).getI_imageUrl());
//							item.setI_category_specific(mP.get(j).getI_category_specific());
//							item.setI_price_min(Integer.parseInt(mP.get(j).getI_price()) - 100);
//							item.setI_price_max(Integer.parseInt(mP.get(j).getI_price()) + 300);
//							item.setLike(Integer.parseInt(mP.get(j).getI_like()) * 10);
							
							JSONObject itemJSON = new JSONObject();
							
							itemJSON.put("i_name", mP.get(j).getI_name());
							itemJSON.put("i_japan_name", mP.get(j).getI_japan_name());
							itemJSON.put("i_info", mP.get(j).getI_info());
							itemJSON.put("i_image_url", mP.get(j).getI_imageUrl());
							itemJSON.put("i_category_specific", mP.get(j).getI_category_specific());
							itemJSON.put("i_price_min", Integer.parseInt(mP.get(j).getI_price()) - 100);
							itemJSON.put("i_price_max", Integer.parseInt(mP.get(j).getI_price()) + 300);
							itemJSON.put("i_likes", Double.parseDouble(mP.get(j).getI_like()) * 10);
							
							eachItems.add(itemJSON);
						}

					}

					subJson.put("hashtag", hashTags);
					subJson.put("items", eachItems);
					
					mList.add(subJson);

				}

				// 이미 등록된 nick일 때는 패스
				else {

				}

			}

		}

		json.put("mLists", mList);

//		System.out.println("@@@@@@@@@@@@@@@@@@@@");
//
//		// (1) 유저의 성향을 받아 온다.
//
//		// (2) 유저의 추천 리스트를 받아 온다.
//
//		// (3) 응답해준다.
//
//		System.out.println("id::::::::" + id);
//		HttpHeaders responseHeaders = new HttpHeaders();
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

		return new ResponseEntity<String>(json.toString(), HttpStatus.OK);
	}
}
