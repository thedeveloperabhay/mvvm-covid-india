package com.example.mvvmarchitectureapp.data.api;

import com.example.mvvmarchitectureapp.model.Covid19IndiaMain;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface RetrofitAPICalls {

    @GET("data.json")
    Single<Covid19IndiaMain> getCovid19IndiaData();
}
