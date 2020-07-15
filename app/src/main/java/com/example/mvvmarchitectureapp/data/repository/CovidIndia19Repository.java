package com.example.mvvmarchitectureapp.data.repository;

import com.example.mvvmarchitectureapp.data.api.RetrofitAPICalls;
import com.example.mvvmarchitectureapp.data.network.RetrofitModule;
import com.example.mvvmarchitectureapp.model.Covid19IndiaMain;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CovidIndia19Repository {

    private static CovidIndia19Repository repositoryInstance;

    private RetrofitAPICalls retrofitAPICalls = RetrofitModule.getRetrofitInstance().create(RetrofitAPICalls.class);


    public static CovidIndia19Repository getInstance(){
        if(repositoryInstance==null){
            repositoryInstance = new CovidIndia19Repository();
        }
        return repositoryInstance;
    }

    public Single<Covid19IndiaMain> getAllCovidIndiaData(){
        return Single.just(true)
                .flatMap(call->retrofitAPICalls.getCovid19IndiaData())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io());
    }
}
