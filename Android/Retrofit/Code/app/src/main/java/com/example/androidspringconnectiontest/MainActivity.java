package com.example.androidspringconnectiontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText signUpText = (EditText) findViewById(R.id.signUpText);
        EditText name = (EditText) findViewById(R.id.name);
        EditText id = (EditText) findViewById(R.id.id);
        EditText password = (EditText) findViewById(R.id.password);
        EditText passwordCheck = (EditText) findViewById(R.id.passwordCheck);
        Button joinButton = (Button) findViewById(R.id.joinButton);

    }
}