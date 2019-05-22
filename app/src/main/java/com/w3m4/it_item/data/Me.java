package com.w3m4.it_item.data;

import java.util.ArrayList;
import java.util.List;

public class Me {
    private String id;
    private String nickname;
    private String thumbnail;
    private String gender;
    private String ageRange;
    private int accuPoint;
    private int curPoint;
    private UserDegree degree;
    private List<String> interestCategories = new ArrayList<String>();
    private List<String> interestCities = new ArrayList<String>();
    public Me(String id, String nickname, String thumbnail, String gender, String ageRange,
              int accuPoint, int curPoint, UserDegree degree,
              ArrayList<String> categories, ArrayList<String> cities) {
        this.id = id;
        this.nickname = nickname;
        this.thumbnail = thumbnail;
        this.gender = gender;
        this.ageRange = ageRange;
        this.accuPoint = accuPoint;
        this.curPoint = curPoint;
        this.degree = degree;
        interestCategories = categories;
        interestCities = cities;
    }

    public Me() {

    }

    public static Me getInstance() {
        return LazyInit.INSTANCE;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<String> getInterestCities() {
        return interestCities;
    }

    public void setInterestCities(List<String> interestCities) {
        this.interestCities = interestCities;
    }

    public List<String> getInterestCategories() {
        return interestCategories;
    }

    public void setInterestCategories(List<String> interestCategories) {
        this.interestCategories = interestCategories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public int getAccuPoint() {
        return accuPoint;
    }

    public void setAccuPoint(int accuPoint) {
        this.accuPoint = accuPoint;
    }

    public int getCurPoint() {
        return curPoint;
    }

    public void setCurPoint(int curPoint) {
        this.curPoint = curPoint;
    }

    public UserDegree getDegree() {
        return degree;
    }

    public void setDegree(UserDegree degree) {
        this.degree = degree;
    }

    private static class LazyInit {
        private static final Me INSTANCE = new Me();
    }
}
