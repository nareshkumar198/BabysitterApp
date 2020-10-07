package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.demoproject.model.LoginResponse;

public class HomeActivity extends AppCompatActivity {
    private TextView privacyPolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        /*
       define the privacy policy id
         */
        privacyPolicy = findViewById(R.id.privacy_policy);

        privacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pricacyIntent = new Intent(HomeActivity.this , privacyActivity.class);
                startActivity(pricacyIntent);
            }
        });

    }
    /*
    Home Page Menu Section
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_In:
                Intent signinIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(signinIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}