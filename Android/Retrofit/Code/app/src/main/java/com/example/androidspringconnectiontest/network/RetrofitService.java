package com.example.androidspringconnectiontest.network;

import com.example.androidspringconnectiontest.data.SignUpData;
import com.example.androidspringconnectiontest.data.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitService {
    // 회원가입
    @POST("/user/signup")
    Call<SignUpResponse> userSignUp(@Body SignUpData data);
//    fun getLoginResponse(@Body user : Map<String, String>): Call<String>
}
