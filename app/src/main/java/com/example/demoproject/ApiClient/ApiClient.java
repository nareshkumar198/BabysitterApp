package com.example.demoproject.ApiClient;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://fms-config-dev.azurewebsites.net/").client(okHttpClient).build();

        return retrofit;
    }

    public static UserService getService(){
        UserService userService = getRetrofit().create(UserService.class);
        return userService;
    }
    public static FamilyService getFamilyService(){
        FamilyService familyService = getRetrofit().create(FamilyService.class);
        return familyService;
    }
    public static BabySitterService getBabySitterService(){
        BabySitterService babySitterService = getRetrofit().create(BabySitterService.class);
        return babySitterService;
    }

}
