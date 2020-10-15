package com.example.demoproject.ApiClient;

import com.example.demoproject.model.Credentials;
import com.example.demoproject.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface UserService {
    @PUT("api/user/editProfile")
    Call<User> editProfile(@Body User user);


    @PUT("api/user/refreshIdToken")
    Call<User> refreshIdToken(@Body Credentials credentials);

    @PUT("api/user/forgotPassword")
    Call<User> forgotPassword(@Body Credentials credentials);

    @PUT("api/user/resetPassword")
    Call<User> resetPassword(@Query("idToken") String idToken, @Body Credentials credentials);


    @PUT("api/user/signIn")
    Call<User> loginUser(@Body Credentials credentials);


    @PUT("api/user/signIn/code")
    Call<User> signInCode(@Body Credentials credentials);


    @POST("api/user/signUp")
    Call<User> saveUsers(@Body User user);

    @PUT("api/user/signIn/socialAuth")
    Call<User> socialAuth(@Body User user);

    @PUT("api/user/signIn/socialAuthInfo")
    Call<User> socialAuthInfo(@Body User user);
}
