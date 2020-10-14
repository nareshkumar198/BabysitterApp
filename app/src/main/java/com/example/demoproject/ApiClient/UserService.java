package com.example.demoproject.ApiClient;

import com.example.demoproject.model.LoginRequest;
import com.example.demoproject.model.LoginResponse;
import com.example.demoproject.model.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserService {

    @PUT("api/user/editProfile")
    Call<LoginResponse> editProfile(@Body LoginRequest loginRequest);


    @PUT("api/user/refreshIdToken")
    Call<LoginResponse> refreshIdToken(@Body LoginRequest loginRequest);

    @PUT("api/user/forgotPassword")
    Call<LoginResponse> forgotPassword(@Body LoginRequest loginRequest);

    @PUT("api/user/resetPassword")
    Call<LoginResponse> resetPassword(@Body LoginRequest loginRequest);


    @PUT("api/user/signIn")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);


    @PUT("api/user/signIn/code")
    Call<LoginResponse> signInCode(@Body LoginRequest loginRequest);


    @POST("api/user/signUp")
    Call<LoginResponse> saveUsers(@Body RegisterRequest registerRequest);

    @PUT("api/user/signIn/socialAuth")
    Call<LoginResponse> socialAuth(@Body LoginRequest loginRequest);

    @PUT("api/user/signIn/socialAuthInfo")
    Call<LoginResponse> socialAuthInfo(@Body LoginRequest loginRequest);

}
