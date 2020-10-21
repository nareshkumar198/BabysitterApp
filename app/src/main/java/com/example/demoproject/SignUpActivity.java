package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoproject.ApiClient.ApiClient;
import com.example.demoproject.ApiClient.Md5;
import com.example.demoproject.model.AuthResponse;
import com.example.demoproject.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private TextView login;
    private EditText  emailId, reEmailId, password, rePassword, firstName, lastName, phoneNo;
    private Spinner communication;
    private Button signUp;

    User user = new User();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        login = findViewById(R.id.sign_login);
        emailId = findViewById(R.id.signUp_Email);
        reEmailId = findViewById(R.id.signUp_reEmail);
        password = findViewById(R.id.signUp_Password);
        rePassword = findViewById(R.id.re_enterpassword);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        phoneNo = findViewById(R.id.phone_No);
        communication = findViewById(R.id.communicationMode);
        signUp = findViewById(R.id.signUp);

/**
 * Login TextView go to Login Activity
 */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });

        /**
         * SignUp Button
          */

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSignUp();
                saveUsers(user);
            }
        });

    }

    public void userSignUp(){

        user.setEmail(emailId.getText().toString());
        user.setEmail(reEmailId.getText().toString());
        user.setPassword(password.getText().toString());
        user.setPassword(rePassword.getText().toString());
        user.setFirstName(firstName.getText().toString());
        user.setLastName(lastName.getText().toString());
        user.setPhone(phoneNo.getText().toString());

     // validation

     if (user.getEmail().isEmpty()){
         emailId.setError("Please Enter Your Email");
         emailId.requestFocus();
         return;
        }
        if (user.getEmail().isEmpty()){
            reEmailId.setError("Please Enter Your Email Again");
            reEmailId.requestFocus();
            return;
        }
        if (user.getPassword().isEmpty()){
            password.setError("Please Enter Your Password");
            password.requestFocus();
            return;
        }
        if (user.getPassword().isEmpty()){
            rePassword.setError("Please Enter Your Password");
            rePassword.requestFocus();
            return;
        }
        if (user.getFirstName().isEmpty()){
            firstName.setError("Please Enter Your FirstName");
            firstName.requestFocus();
            return;

        }
        if (user.getLastName().isEmpty()){
            lastName.setError("Please Enter Your LastName");
            lastName.requestFocus();
            return;

        }
        if (user.getPhone().isEmpty()){
            phoneNo.setError("Please Enter Your Phone No");
            phoneNo.requestFocus();
            return;
        }
        Md5 md5 = new Md5(password.getText().toString());
        String a =  md5.getMd5();
        user.setPassword(a);
        password.setText(user.getPassword());

    }

    /**
     * Call API
     * @param user
     */

    public void saveUsers(User user){
        Call<AuthResponse> authResponseCall = ApiClient.getService().saveUsers(user);
        authResponseCall.enqueue(new Callback<AuthResponse>() {

            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful()){
                    AuthResponse sineUpResponse = response.body();
                        startActivity(new Intent(SignUpActivity.this, Verifyemail.class));
                        finish();
                    }
                else {
                    String message = "User already exists but not confirmed";
                    Toast.makeText(SignUpActivity.this, message, Toast.LENGTH_LONG).show();
                }

                }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
            String message = t.getLocalizedMessage();
            Toast.makeText(SignUpActivity.this,message, Toast.LENGTH_LONG).show();

            }
        });
    }




}