package com.example.demoproject.ApiClient;

import com.example.demoproject.model.Family;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface FamilyService {

    @GET("api/organization")
    Call<Family> getFamily(@Header("email") String email, @Header("Authorization") String token);

    @POST("api/organization")
    Call<Family> addFamily(@Body Family family, @Header("Authorization") String token);

    @PUT("api/organization")
    Call<Family> editFamily(@Body Family family, @Header("Authorization") String token);
}
