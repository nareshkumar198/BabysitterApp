package com.example.demoproject.ApiClient;

import com.example.demoproject.model.Appointment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FamilyAppointment {

    @GET("api/appointments/families/{familyId}")
    Call<Appointment[]> getAppointment(@Path("familyId") String familyId);

    @GET("api/appointments/pastAppointments/families/{familyId}")
    Call<Appointment[]> getPastAppointments(@Path("familyId") String familyId);
}
