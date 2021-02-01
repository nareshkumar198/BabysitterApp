package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demoproject.ApiClient.ConfigApiClient;
import com.example.demoproject.model.AuthResponse;
import com.example.demoproject.model.Credentials;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText emailEnter;
    private Button submitEmail;
    Credentials credentials = new Credentials();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_activiti);
        emailEnter = findViewById(R.id.emailEnter);
        submitEmail = findViewById(R.id.submit_email);

        submitEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(emailEnter.getText().toString())){
                    String message = "Email is required";
                    Toast.makeText(ResetPasswordActivity.this, message, Toast.LENGTH_SHORT).show();
                }
                else {
                    credentials.setEmail( emailEnter.getText().toString());
                    forgotPassword(credentials);
                }

            }
        });
    }

    public void forgotPassword(Credentials credentials){
        Call<AuthResponse> authResponseCall = ConfigApiClient.getService().forgotPassword(credentials);
        authResponseCall.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(ResetPasswordActivity.this, "Link send your Email", Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(ResetPasswordActivity.this,message, Toast.LENGTH_LONG).show();

            }
        });

    }
}


