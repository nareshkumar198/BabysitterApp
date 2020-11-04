package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BabySitterActivity extends AppCompatActivity {
    private Button addBabysitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_sitter);

        addBabysitter = findViewById(R.id.baby_AddBabysitter);
        addBabysitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BabySitterActivity.this, BabySitterAddActivity.class);
                startActivity(intent);
            }
        });
    }
}