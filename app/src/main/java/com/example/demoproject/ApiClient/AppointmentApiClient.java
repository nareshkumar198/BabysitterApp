package com.example.demoproject.ApiClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppointmentApiClient {

    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://fms-appointment-dev.azurewebsites.net/").client(okHttpClient).build();

        return retrofit;
    }

    public static AppointmentService getAppointmentService(){
        AppointmentService appointmentService = getRetrofit().create(AppointmentService.class);
        return appointmentService;
    }
    public static FamilyAppointment getFamilyAppointment(){
        FamilyAppointment familyAppointment = getRetrofit().create(FamilyAppointment.class);
        return familyAppointment;
    }
}
