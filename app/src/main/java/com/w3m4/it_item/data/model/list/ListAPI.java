package com.w3m4.it_item.data.model.list;

import com.google.gson.JsonObject;
import com.w3m4.it_item.data.mList;
import com.w3m4.it_item.data.mLists;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ListAPI {
    @GET("mainPage")
    Single<mLists>getList(
            @Query("id") String userId
    );

    @GET("mainPage")
    Single<JsonObject> getList2(
            @Query("id") String userId
    );
}
