package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ZipCodeValidationActivity extends AppCompatActivity {

private EditText code;
private TextView cityName, stateName, timeZone;
String url ="https://www.zipcodeapi.com/rest/<api_key>/info.<format>/<zip_code>/<units>";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z_ip_code_velidation);

        code = findViewById(R.id.zip_code_edit_text);
        cityName = findViewById(R.id.cityName_text);
        stateName = findViewById(R.id.stateName_text);
        timeZone = findViewById(R.id.time_text_View);

    }
}