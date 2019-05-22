package com.w3m4.it_item.data;

import java.util.HashMap;
import java.util.Map;

public enum City {

    TOKYO(0),
    OSAKA(1),
    KYOTO(2),
    KYUSU(3),
    SAPPORO(4),
    HOKKAIDO(5);

    private int value;
    private static Map map = new HashMap<>();

    City(int value) {
        this.value = value;
    }

    public static City valueOf(int pageType) {
        return (City) map.get(pageType);
    }

    public int getValue() {
        return value;
    }



}
