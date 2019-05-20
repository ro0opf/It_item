package com.w3m4.it_item.data.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ServiceGenerator {
    private final static String BASE_URL = "https://192.168.0.49/";

    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .build();
    }

    private static Retrofit getInstance() {
        return LazyInit.INSTANCE;
    }

    private static class LazyInit {
        private static final Retrofit INSTANCE = createInstance(BASE_URL);

        private static Gson createGson() {
            return new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
        }

        private static Retrofit createInstance(String url) {
            return new Retrofit.Builder()
                    .baseUrl(url)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(createGson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
    }

    public static <T> T createService(Class<T> serviceClass, int flag) {
        return getInstance().create(serviceClass);
    }
}
