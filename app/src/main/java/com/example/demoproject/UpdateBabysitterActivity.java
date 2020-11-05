package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.demoproject.model.Babysitter;
import com.example.demoproject.model.User;

public class UpdateBabysitterActivity extends AppCompatActivity {
    String[] updtMode = {"Message/Text", "Email", "Both"};

    private TextView updateRank, updateFName, updateLName, updatePhone, updateEmail;
    private Button update, delete;
    Spinner updateMode;
    Babysitter babysitter = new Babysitter();



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
        updatePhone = findViewById(R.id.updateBabysitter_phone);
        updateEmail = findViewById(R.id.updateBabysitter_Email);
//        Button
        update = findViewById(R.id.updateBabysitter);
        delete = findViewById(R.id.DeleteBabysitter);
//        Spinner
        updateMode = (Spinner) findViewById(R.id.updateBabysitter_spinner);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, updtMode);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        updateMode.setAdapter(adapter);

        updateMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateMode.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBabysitter();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void updateBabysitter(){

        babysitter.setCommunicationMode(updateMode.getSelectedItemPosition());
//        babysitter.setRank(updateRank.getText().toString());
        babysitter.setFirstName(updateFName.getText().toString());
        babysitter.setLastName(updateLName.getText().toString());
        babysitter.setPhone(updatePhone.getText().toString());
        babysitter.setEmail(updateEmail.getText().toString());


    }
}