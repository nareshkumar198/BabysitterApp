package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.demoproject.model.Babysitter;

import java.util.ArrayList;
import java.util.List;

public class BabySitterAddActivity extends AppCompatActivity {
     String[] commMode = {"Message/Text", "Email", "Both"};
     TextView rankBabysitter, firstNameBabysitter, lastNameBabysitter, phoneBabysitter, emailBabysitter;
     Spinner communicationMode;
     Button saveBabysitter;
     Button clearBabysitter;
     Babysitter babysitter = new Babysitter();

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_sitter_add);
        // Text View
        rankBabysitter = findViewById(R.id.babyAdd_rank);
        firstNameBabysitter = findViewById(R.id.firstName_Babysitter);
        lastNameBabysitter = findViewById(R.id.lastNameBabysitter);
        phoneBabysitter = findViewById(R.id.addBabysitter_phone);
        emailBabysitter = findViewById(R.id.addBabysitter_Email);
        //Button
        saveBabysitter = findViewById(R.id.saveBabysitter);
        clearBabysitter = findViewById(R.id.clearBabysitter);
        //Spinner
        communicationMode = (Spinner) findViewById(R.id.addBabysitter_spinner);

        ArrayAdapter  adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, commMode);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        communicationMode.setAdapter(adapter);

        communicationMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                communicationMode.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        saveBabysitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveBabysitter();

            }
        });

        clearBabysitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (view.getId() == R.id.clearBabysitter);
               firstNameBabysitter.setText(" ");
               lastNameBabysitter.setText(" ");
               phoneBabysitter.setText(" ");
               emailBabysitter.setText(" ");
            }
        });
    }
    public void saveBabysitter(){

        babysitter.setCommunicationMode(communicationMode.getSelectedItemPosition());
        babysitter.setFirstName(firstNameBabysitter.getText().toString());
        babysitter.setLastName(lastNameBabysitter.getText().toString());
        babysitter.setPhone(phoneBabysitter.getText().toString());
        babysitter.setEmail(emailBabysitter.getText().toString());

        if (babysitter.getFirstName().isEmpty()){
            firstNameBabysitter.setError("First Name should not be empty");
            firstNameBabysitter.requestFocus();
            return;
        }
        if (babysitter.getLastName().isEmpty()){
            lastNameBabysitter.setError("Last Name should not be empty");
            lastNameBabysitter.requestFocus();
            return;
        }
        if (babysitter.getPhone().isEmpty() || babysitter.getPhone().length() != 10) {
            phoneBabysitter.setError("Phone No should not be empty OR your Phone Number Not corect");
            phoneBabysitter.requestFocus();
            return ;
        }


        if (babysitter.getEmail().isEmpty()){
            emailBabysitter.setError("Email should not be empty");
            emailBabysitter.requestFocus();
            return;
        }



    }

}