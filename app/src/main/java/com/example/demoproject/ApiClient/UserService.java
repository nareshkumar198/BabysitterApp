package com.example.demoproject.ApiClient;

import com.example.demoproject.model.AuthResponse;
import com.example.demoproject.model.Credentials;
import com.example.demoproject.model.User;
import com.example.demoproject.model.UserDetails;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface UserService {

    @PUT("api/user/editProfile")
    Call<AuthResponse> editProfile(@Body UserDetails user);

    @PUT("api/user/refreshIdToken")
    Call<AuthResponse> refreshIdToken(@Body Credentials credentials);

    @PUT("api/user/forgotPassword")
    Call<AuthResponse> forgotPassword(@Body Credentials credentials);

    @PUT("api/user/resetPassword")
    Call<AuthResponse> resetPassword(@Query("idToken") String idToken, @Body Credentials credentials);

    @PUT("api/user/signIn")
    Call<AuthResponse> loginUser(@Body Credentials credentials);

    @PUT("api/user/signIn/code")
    Call<AuthResponse> signInCode(@Body Credentials credentials);

    @POST("api/user/signUp")
    Call<AuthResponse> saveUsers(@Body UserDetails user);

    @PUT("api/user/socialAuth")
    Call<AuthResponse> socialAuth(@Body UserDetails user);

    @PUT("api/user/socialAuthInfo")
    Call<AuthResponse> socialAuthInfo(@Body UserDetails user);
}
