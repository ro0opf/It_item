package com.w3m4.it_item.data.model.list;

import com.w3m4.it_item.data.mLists;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ListAPI {
    @GET("mainPage")
    Single<mLists> getList(
            @Query("id") String userId
    );

    @GET("cityList")
    Single<mLists> getCityList(
        @Query("id") String city
    );
}
