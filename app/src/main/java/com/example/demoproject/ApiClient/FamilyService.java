package com.example.demoproject.ApiClient;

import com.example.demoproject.model.Family;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface FamilyService {

    @GET("api/families")
    Call<Family> getFamily(@Header("email") String email);

    @POST("api/families")
    Call<Family> addFamily(@Body Family family);

    @PUT("api/families")
    Call<Family> editFamily(@Body Family family);



}
