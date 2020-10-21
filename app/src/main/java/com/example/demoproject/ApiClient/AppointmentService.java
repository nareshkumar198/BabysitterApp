package com.example.demoproject.ApiClient;

import com.example.demoproject.model.Appointment;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AppointmentService {

    @POST("api/appointments")
    Call<Appointment> createAppointment(@Body Appointment appointment);

    @DELETE("api/appointments/{appointmentId}")
    Call<Appointment> deleteAppointment(@Path("appointmentId") String appointmentId);


}
