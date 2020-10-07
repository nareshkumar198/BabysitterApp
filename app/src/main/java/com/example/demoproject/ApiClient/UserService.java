package com.example.demoproject.ApiClient;

import com.example.demoproject.model.LoginRequest;
import com.example.demoproject.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserService {

    @PUT("api/user/signIn")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
}
