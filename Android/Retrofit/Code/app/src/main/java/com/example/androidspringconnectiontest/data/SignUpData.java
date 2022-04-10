package com.example.androidspringconnectiontest.data;

import com.google.gson.annotations.SerializedName;

/**
 * Json 데이터를 받아오는 Class
 */
public class SignUpData {
    /**
     * SerializedName 으로 JSON 객체와 해당 변수를 매칭
     * @SerializedName 괄호 안에는 해당 JSON 객체의 변수 명 적기
     * 이때, POST 매핑으로 받아올 값은, 굳이 annotation 을 붙이지 않고, JSON 객체의 변수명과 일치하는 변수만 선언하면 됨
     */
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private String id;
    @SerializedName("password")
    private String password;
    @SerializedName("passwordCheck")
    private String passwordCheck;

    public SignUpData(String name, String id, String password, String passwordCheck) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.passwordCheck = passwordCheck;
    }
}
