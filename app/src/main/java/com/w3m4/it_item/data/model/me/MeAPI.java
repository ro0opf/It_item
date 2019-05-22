package com.w3m4.it_item.data.model.me;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MeAPI {
    @POST("user")

    @GET("user")
    String getUserId(
            @Query("id") String userId
    );
}
