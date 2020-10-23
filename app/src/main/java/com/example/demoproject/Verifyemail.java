package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoproject.ApiClient.ApiClient;
import com.example.demoproject.model.AuthResponse;
import com.example.demoproject.model.Credentials;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Verifyemail extends AppCompatActivity {

    private EditText code;
    private Button submit;
    private TextView emailShow;

    Credentials credentials = new Credentials();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyemail);

        code = findViewById(R.id.code);
        submit = findViewById(R.id.submit);
        emailShow = findViewById(R.id.emailShow);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeSign();
                signInCode(credentials);

            }
        });
    }

    public void codeSign(){
        credentials.setSecretCode(code.getText().toString());
        credentials.setEmail(emailShow.getText().toString());

        if (credentials.getSecretCode().isEmpty()){
            code.setError("Please Enter Your Code");
            code.requestFocus();
            return;
        }

    }

    public void signInCode( Credentials credentials){
        Call<AuthResponse> authResponseCall = ApiClient.getService().signInCode(credentials);
        authResponseCall.enqueue(new Callback<AuthResponse>() {
                                     @Override
                                     public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                                         if (response.isSuccessful()){
                                             AuthResponse signInCodeResponse = response.body();
                                             startActivity(new Intent(Verifyemail.this, AfterLoginActivity.class));
                                             finish();
                                         }

                                         else {
                                             String message = "Code Is Not Valid";
                                             Toast.makeText(Verifyemail.this, message, Toast.LENGTH_LONG).show();
                                         }
                                     }

                                     @Override
                                     public void onFailure(Call<AuthResponse> call, Throwable t) {
                                         String message = t.getLocalizedMessage();
                                         Toast.makeText(Verifyemail.this,message, Toast.LENGTH_LONG).show();

                                     }
                                 }
        );
    }
}