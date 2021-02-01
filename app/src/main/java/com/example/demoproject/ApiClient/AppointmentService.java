package com.example.demoproject.ApiClient;

import com.example.demoproject.model.Appointment;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AppointmentService {

    @POST("api/appointment")
    Call<Appointment> createAppointment(@Body Appointment appointment, @Header("Authorization") String token);

    @DELETE("api/appointment/{appointmentId}")
    Call<Appointment> deleteAppointment(@Path("appointmentId") String appointmentId, @Header("Authorization") String token);

    @GET("/api/appointments/org/{orgId}")
    Call<Appointment[]> getCurrentAppointments(@Path("orgId") String orgId, @Header("Authorization") String token);

    @GET("/api/appointments/org/pastAppointments/{orgId}")
    Call<Appointment[]> getPastAppointments(@Path("orgId") String orgId, @Header("Authorization") String token);
}
