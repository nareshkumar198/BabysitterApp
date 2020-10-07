package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.demoproject.model.LoginResponse;

public class AfterLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        Intent intent = getIntent();
        if (intent.getExtras() != null){
            LoginResponse loginResponse = (LoginResponse) intent.getSerializableExtra("data");
            Log.e("TAG","hello" + loginResponse.getEmail().toString());
        }
    }
}