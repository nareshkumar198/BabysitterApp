package com.example.demoproject.ApiClient;

import com.example.demoproject.model.AddFamilyRequest;
import com.example.demoproject.model.AddFamilyResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface FamilyService {

    @GET("api/families")
    Call<AddFamilyResponse> getFamily();

    @POST("api/families")
    Call<AddFamilyResponse> addFamily(@Body AddFamilyRequest addFamilyRequest);

    @PUT("api/families")
    Call<AddFamilyResponse> editFamily(@Body AddFamilyRequest addFamilyRequest);


}
