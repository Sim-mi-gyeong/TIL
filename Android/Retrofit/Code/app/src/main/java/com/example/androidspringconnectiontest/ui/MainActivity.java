package com.example.androidspringconnectiontest.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidspringconnectiontest.R;
import com.example.androidspringconnectiontest.data.SignUpData;
import com.example.androidspringconnectiontest.data.SignUpResponse;
import com.example.androidspringconnectiontest.network.RetrofitClient;
import com.example.androidspringconnectiontest.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText id;
    private EditText password;
    private EditText passwordCheck;
    private Button signUpButton;
    private RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView signUpText = (TextView) findViewById(R.id.signUpText);
        name = (EditText) findViewById(R.id.name);
        id = (EditText) findViewById(R.id.id);   // email 형태 : AutoCompleteTextView
        password = (EditText) findViewById(R.id.password);
        passwordCheck = (EditText) findViewById(R.id.passwordCheck);
        signUpButton = (Button) findViewById(R.id.signUpButton);

        service = RetrofitClient.getClient().create(RetrofitService.class);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptSignUp();
            }
        });

    }

    // 유효성 검사 및 회원가입 메서드 호
    private void attemptSignUp() {
        name.setError(null);
        id.setError(null);
        password.setError(null);
        passwordCheck.setError(null);

        boolean cancel = false;
        View focusView = null;

        String nameText = name.getText().toString();
        String idText = id.getText().toString();
        String passwordText = password.getText().toString();
        String passwordCheckText = passwordCheck.getText().toString();

        // 이름 유효성 검사사
        if (nameText.isEmpty()) {
            name.setError("이름을 입력해주세요.");
            focusView = name;
            cancel = true;
        }

        // 아이디 유효성 검사
        if (idText.isEmpty()) {
            id.setError("아이디 입력해주세요.");
            focusView = id;
            cancel = true;
        }

        // 비밀번호 유효성 검사
        if (passwordText.isEmpty()) {
            password.setError("비밀번호를 입력해주세요.");
            focusView = password;
            cancel = true;
        } else if (!isPasswordValid(passwordText)) {
            password.setError("6자 이상의 비밀번호를 입력해주세요.");
            focusView = password;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            startSignUp(new SignUpData(nameText, idText, passwordText, passwordCheckText));
        }

    }

    // 회원가입 처리
    private void startSignUp(SignUpData data) {
        // enqueue()에 파라미터로 넘긴 콜백 - 통신이 성공/실패 했을 때 수행할 동작을 재정의
        service.userSignUp(data).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                SignUpResponse result = response.body();
                Toast.makeText(MainActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();

                if (result.getCode() == 200) {
                    finish();
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "회원가입 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("회원가입 에러 발생", t.getMessage());

            }
        });
    }

    private boolean isPasswordValid(String passwordText) {
        return passwordText.length() >= 8;
    }

}