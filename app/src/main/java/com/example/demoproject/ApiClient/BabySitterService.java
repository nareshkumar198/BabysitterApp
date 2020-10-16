package com.example.demoproject.ApiClient;

import com.example.demoproject.model.Babysitter;
import com.example.demoproject.model.Family;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BabySitterService {

    @GET("api/babysitters/{familyId}")
    Call<Babysitter[]> getBabySitter(@Path("familyId") String familyId);

    @POST("api/babysitters/{familyId}")
    Call<Family> postBabySitter(@Path("familyId") String familyId, @Body Babysitter babysitter);

    @PUT("api/babysitters/{familyId}")
    Call<Family> putBabySitter(@Path("familyId") String familyId, @Body Babysitter babysitter);

    @DELETE("api/babysitters/{familyId}/{babysitterId}")
    Call<Family> deleteBabySitter(@Path("familyId") String familyId,@Path("babysitterId") String babysitterId);

    @PUT("api/babysitters/{familyId}/orderRanks")
    Call<Family> changeBabySitterRanks(@Path("familyId") String familyId, @Body Babysitter[] babysitter);
}
