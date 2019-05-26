package com.w3m4.it_item.data.model.list;

import com.google.gson.JsonObject;
import com.w3m4.it_item.data.mLists;
import com.w3m4.it_item.data.model.ServiceGenerator;

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

    public Single<mLists> getCityList(String city){
        return service.getCityList(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<mLists> getMyList(String userId){
        return service.getMyList(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<JsonObject> addMyList(JsonObject jsonObject){
        return service.addMyList(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
