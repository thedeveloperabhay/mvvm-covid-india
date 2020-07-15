package com.example.mvvmarchitectureapp.data.network;

import com.example.mvvmarchitectureapp.AppConstant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModule {

    private static Retrofit retrofitModule;

    public static Retrofit getRetrofitInstance() {
        if (retrofitModule == null) {

            retrofitModule = new Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofitModule;
    }
}
