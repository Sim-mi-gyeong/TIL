package com.example.androidspringconnectiontest.repository;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface RetrofitService {
    // 회원가입
    @POST("/user/signup")
    Call<ResponseBody> userSignUp(@Field("objJson") String objJson);

//    fun getLoginResponse(@Body user : Map<String, String>): Call<String>
}
//interface BaeminService {
//    @GET("contents?typeCode=notice&size=10")
//    fun loadNotice(@Query("page") page: String): Call<Baemin>
//}