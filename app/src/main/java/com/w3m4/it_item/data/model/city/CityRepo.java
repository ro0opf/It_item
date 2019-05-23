package com.w3m4.it_item.data.model.city;

import com.w3m4.it_item.data.model.ServiceGenerator;

public class CityRepo {
    private CityAPI service = ServiceGenerator.createService(CityAPI.class);

    public static CityRepo getInstance() {
        return CityRepo.LazyInit.INSTANCE;
    }

    private static class LazyInit {
        private static final CityRepo INSTANCE = new CityRepo();
    }
}
