package com.w3m4.it_item.data.model.me;

import com.w3m4.it_item.data.model.ServiceGenerator;

public class MeRepo {
    private MeAPI service = ServiceGenerator.createService(MeAPI.class);

    public static MeRepo getInstance() {
        return LazyInit.INSTANCE;
    }

    private static class LazyInit {
        private static final MeRepo INSTANCE = new MeRepo();
    }

}
