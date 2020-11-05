package com.example.demoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoproject.model.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.Calendar;


public class AfterLoginActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

  GoogleSignInClient mGoogleSignInClient;
  private Button showPastAppointments , scheduleAppointment , hidePastAppoi;
  private LinearLayout hidePostLinear , linearBabysitter;
    private TextView date;
    private ImageView calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        showPastAppointments = findViewById(R.id.show_Past_Appoin);
        scheduleAppointment = findViewById(R.id.scheduleAppointment);
        hidePostLinear = findViewById(R.id.hide_post_linear);
        linearBabysitter = findViewById(R.id.linear_Babysitter);
        hidePastAppoi = findViewById(R.id.hide_Past_Appoi);
        date = findViewById(R.id.date);
        calendar = findViewById(R.id.clander);


        showPastAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidePostLinear.setVisibility(View.VISIBLE);
                showPastAppointments.setVisibility(View.GONE);

            }
        });
        scheduleAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearBabysitter.setVisibility(View.VISIBLE);
                scheduleAppointment.setVisibility(View.GONE);

            }
        });

        hidePastAppoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPastAppointments.setVisibility(View.VISIBLE);
                hidePostLinear.setVisibility(View.GONE);

            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        Intent intent = getIntent();
        if (intent.getExtras() != null){
            User loginResponse = (User) intent.getSerializableExtra("data");
            Log.e("TAG","hello" + loginResponse.getEmail().toString());
        }

    }
    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(AfterLoginActivity.this, "signout", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
        Intent loginIntent = new Intent(AfterLoginActivity.this, MainActivity.class);
        startActivity(loginIntent);
    }
    /*
   After login  Page Menu Section
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.afterloginmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.Appointments_menu:
                Intent appointmentsIntent = new Intent(String.valueOf( AfterLoginActivity.class));
                startActivity(appointmentsIntent);
                break;
            case R.id.Babysitter_menu:
                Intent babysitterIntent = new Intent(AfterLoginActivity.this , BabySitterActivity.class);
                startActivity(babysitterIntent);
                break;

            case R.id.logout_menu:
                signOut();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void clickHere(View view) {
        Intent clickIntent = new Intent(AfterLoginActivity.this, BabySitterActivity.class);
        startActivity(clickIntent);
    }

    /**
     * date Picker
     */
    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this
                , Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String datecalender =  month +"/"+dayOfMonth + "/"+ year;
//        dateset.setText(date);
        date.setText(datecalender);

    }
}