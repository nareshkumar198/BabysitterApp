package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class HomeActivity extends AppCompatActivity {
    private TextView privacyPolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CarouselView carouselView = (CarouselView)  findViewById(R.id.carousel);
        carouselView.setPageCount(3);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.brothers);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.children);
                        break;
                    default:
                        imageView.setImageResource(R.drawable.girls);
                }
            }
        });



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