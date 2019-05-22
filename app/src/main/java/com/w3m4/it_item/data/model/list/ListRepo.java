package com.w3m4.it_item.data.model.list;

import com.google.gson.JsonObject;
import com.kakao.usermgmt.response.model.User;
import com.w3m4.it_item.data.mList;
import com.w3m4.it_item.data.mLists;
import com.w3m4.it_item.data.model.ServiceGenerator;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ListRepo {
    private ListAPI service = ServiceGenerator.createService(ListAPI.class);

    public static ListRepo getInstance() {
        return LazyInit.INSTANCE;
    }

    private static class LazyInit {
        private static final ListRepo INSTANCE = new ListRepo();
    }

    public Single<mLists> getList(String userId) {
        return service.getList(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<JsonObject> getList2(String userId) {
        return service.getList2(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
