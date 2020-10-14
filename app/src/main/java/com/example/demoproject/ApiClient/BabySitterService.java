package com.example.demoproject.ApiClient;

import com.example.demoproject.model.BabySitterResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BabySitterService {

    @GET("api/babysitters/{familyId}")
    Call<BabySitterResponse> getBabySitter(@Path("familyId") String familyId);

    @POST("api/babysitters/{familyId}")
    Call<BabySitterResponse> postBabySitter(@Path("familyId") String familyId);

   @PUT("api/babysitters/{familyId}")
   Call<BabySitterResponse> putBabySitter(@Path("familyId") String familyId);

    @DELETE("api/babysitters/{familyId}/{babysitterId}")
    Call<BabySitterResponse> deleteBabySitter(@Path("familyId") String familyId,@Path("babysitterId") String babysitterId);

    @PUT("api/babysitters/{familyId}/orderRanks")
    Call<BabySitterResponse> changeBabySitterRanks(@Path("familyId") String familyId);
}
