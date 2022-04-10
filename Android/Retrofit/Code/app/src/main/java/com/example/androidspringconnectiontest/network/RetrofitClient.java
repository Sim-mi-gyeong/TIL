package com.example.androidspringconnectiontest.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final static String BASE_URL = "http://ec2-3-84-71-239.compute-1.amazonaws.com:8080/";

    public static RetrofitService getApiService() {
        return getClient().create(RetrofitService.class);
    }

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()   // Retrofit 객체 초기화
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
