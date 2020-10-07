package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoproject.ApiClient.ApiClient;
import com.example.demoproject.model.LoginRequest;
import com.example.demoproject.model.LoginResponse;
import com.example.demoproject.ApiClient.Md5;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView signUp;
    private EditText email , password;
    private Button login , Btgoogle , Btfacebook;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = findViewById(R.id.goSignUp);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.logIn);
        Btgoogle = findViewById(R.id.google);
        Btfacebook = findViewById(R.id.facebook);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIntent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(signIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText())){
                        String message =" All input Required..";
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                    else {
                        LoginRequest loginRequest = new LoginRequest();
                        loginRequest.setEmail( email.getText().toString());
                        loginRequest.setPassword(password.getText().toString());

                        Md5 md5 = new Md5(password.getText().toString());
                        String a =  md5.getMd5();
                        loginRequest.setPassword(a);
                        password.setText(loginRequest.getPassword());

                        logiUser(loginRequest);
                    }

            }
        });
        /*
        Login form velidtion
//         */
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SignIn signIn = new SignIn();
//                signIn.setEmail(email.getText().toString());
//                signIn.setPassword(password.getText().toString());
//                validateLogin(signIn);
//            }
//        });
//    }
//    private Boolean validateLogin(SignIn signIn){
//        if (signIn.getEmail() == null || signIn.getEmail().trim().length() == 0){
//            email.setError("User Name is Required");
//            email.requestFocus();
//
//        }
//        if (signIn.getPassword() == null || signIn.getPassword().length() == 0){
//            password.setError("Password Is Required");
//            password.requestFocus();
//        }
//        return true;
//
//    }
    }
    public void logiUser(LoginRequest loginRequest){
        Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    LoginResponse loginResponse = response.body();
                    startActivity(new Intent(MainActivity.this, AfterLoginActivity.class).putExtra("data", loginResponse));
                    finish();

                }
                else {
                    String message = "Please Try Again Letaer...";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_LONG).show();

            }
        });


    }

}