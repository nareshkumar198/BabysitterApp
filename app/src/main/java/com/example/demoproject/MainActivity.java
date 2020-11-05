package com.example.demoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoproject.ApiClient.ApiClient;
import com.example.demoproject.ApiClient.Md5;
import com.example.demoproject.model.AuthResponse;
import com.example.demoproject.model.Credentials;
import com.example.demoproject.model.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;



import java.lang.reflect.Array;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView signUp, forgotPassword;
    private EditText email , password;
    private Button login , Btgoogle ;
    private GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 0;
<<<<<<< HEAD
=======
    private Button loginButton;


>>>>>>> 4c59a01e4c37c602e1dd25fb8f614be9b41baf79

    private Button loginButton;
    User user =  new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp = findViewById(R.id.goSignUp);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.logIn);
        Btgoogle = findViewById(R.id.google);
        forgotPassword = findViewById(R.id.forgotPassword);

        Btgoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
//
            }
        });

        /**
         * Forgot Password Click Listener
         */
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

        /**
         * SignUP Click Listener
         */

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIntent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(signIntent);
            }
        });

        /**
         * Login Button Click Listener
         */

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText())){
                        String message =" All input Required..";
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                    else {
                        Credentials credentials = new Credentials();
                        credentials.setEmail( email.getText().toString());
                        credentials.setPassword(password.getText().toString());

                        Md5 md5 = new Md5(password.getText().toString());
                        String a =  md5.getMd5();
                        credentials.setPassword(a);
                        password.setText(credentials.getPassword());

                        logiUser(credentials);
                    }
            }
        });
        /**
         * Google Login
         */
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        /**
         * Google Button click Listener
         */

    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);

        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
        Intent intent = new Intent(MainActivity.this, AfterLoginActivity.class);
        startActivity(intent);

        }
        catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());

        }
    }

    /**
     * Login Api Call
     * @param credentials
     */
    public void logiUser(Credentials credentials){
        Call<AuthResponse> loginResponseCall = ApiClient.getService().loginUser(credentials);
        loginResponseCall.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful()){
                    AuthResponse loginResponse = response.body();
//                    Log.d("user", response.body().toString());
                    startActivity(new Intent(MainActivity.this, AfterLoginActivity.class));
                    finish();
                }
                else if(response.code() == 403) {
                    String message = "Invalid Credentials";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                } else if(response.code() == 404) {
                    String message = "Email is not registered";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_LONG).show();
            }
        });
    }
}