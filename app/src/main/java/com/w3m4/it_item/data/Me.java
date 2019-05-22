package com.w3m4.it_item.data;

public class Me {
    private String id;
    private String nickname;
    private String gender;
    private String ageRange;
    private int accuPoint;
    private int curPoint;
    private UserDegree degree;

    public Me(String id, String nickname, String gender, String ageRange, int accuPoint, int curPoint, UserDegree degree) {
        this.id = id;
        this.nickname = nickname;
        this.gender = gender;
        this.ageRange = ageRange;
        this.accuPoint = accuPoint;
        this.curPoint = curPoint;
        this.degree = degree;
    }

    public Me() {

    }

    public static Me getInstance() {
        return LazyInit.INSTANCE;
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
