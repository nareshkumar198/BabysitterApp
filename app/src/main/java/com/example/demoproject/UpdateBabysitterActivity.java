package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class UpdateBabysitterActivity extends AppCompatActivity {

    private TextView updateRank, updateFName, updateLName, updatePhone, updateEmail;
    private Button update , delete;
    Spinner updateMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_babysitter);
        /**
         * TexeVIew
         */
        updateRank = findViewById(R.id.updateRank);
        updateFName = findViewById(R.id.updateFirstName);
        updateLName = findViewById(R.id.updateLastName);
        updateMode = findViewById(R.id.updateBabysitter_spinner);
        updatePhone = findViewById(R.id.updateBabysitter_phone);
        updateEmail = findViewById(R.id.updateBabysitter_Email);
        /*
        Button
         */
        update = findViewById(R.id.updateBabysitter);
        delete = findViewById(R.id.DeleteBabysitter);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}