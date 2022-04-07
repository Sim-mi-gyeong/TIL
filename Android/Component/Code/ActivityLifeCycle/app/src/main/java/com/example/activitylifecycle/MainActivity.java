package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity : onCreate");
        Toast.makeText(getApplicationContext(), "MainActivity : onCreate", Toast.LENGTH_SHORT).show();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity : onStart");
        Toast.makeText(getApplicationContext(), "MainActivity : onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity : onResume");
        Toast.makeText(getApplicationContext(), "MainActivity : onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity : onRestart");
        Toast.makeText(getApplicationContext(), "MainActivity : onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity : onPause");
        Toast.makeText(getApplicationContext(), "MainActivity : onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity : onStop");
        Toast.makeText(getApplicationContext(), "MainActivity : onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity : onDestroy");
        Toast.makeText(getApplicationContext(), "MainActivity : onDestroy", Toast.LENGTH_SHORT).show();
    }

}