package com.example.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private static String TAG = "SubActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Log.d(TAG, "SubActivity : onCreate");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SubActivity : onStart");
        Toast.makeText(getApplicationContext(), "SubActivity : onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SubActivity : onResume");
        Toast.makeText(getApplicationContext(), "SubActivity : onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "SubActivity : onRestart");
        Toast.makeText(getApplicationContext(), "SubActivity : onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SubActivity : onPause");
        Toast.makeText(getApplicationContext(), "SubActivity : onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SubActivity : onStop");
        Toast.makeText(getApplicationContext(), "SubActivity : onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "SubActivity : onDestroy");
        Toast.makeText(getApplicationContext(), "SubActivity : onDestroy", Toast.LENGTH_SHORT).show();
    }
}
