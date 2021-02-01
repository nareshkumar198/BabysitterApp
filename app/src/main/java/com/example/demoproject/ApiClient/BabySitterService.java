package com.example.demoproject.ApiClient;

import com.example.demoproject.model.Babysitter;
import com.example.demoproject.model.Family;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BabySitterService {

    @GET("api/contacts/{orgId}")
    Call<Babysitter[]> getBabySitter(@Path("orgId") String familyId, @Header("Authorization") String token);

    @POST("api/contacts/{orgId}")
    Call<Family> postBabySitter(@Path("orgId") String familyId, @Body Babysitter babysitter, @Header("Authorization") String token);

    @PUT("api/contacts/{orgId}")
    Call<Family> putBabySitter(@Path("orgId") String familyId, @Body Babysitter babysitter, @Header("Authorization") String token);

    @DELETE("api/contacts/{orgId}/{contactId}")
    Call<Family> deleteBabySitter(@Path("orgId") String familyId,@Path("contactId") String babysitterId, @Header("Authorization") String token);

    @PUT("api/babysitters/{orgId}/orderRanks")
    Call<Family> changeBabySitterRanks(@Path("orgId") String familyId, @Body Babysitter[] babysitter, @Header("Authorization") String token);
}
