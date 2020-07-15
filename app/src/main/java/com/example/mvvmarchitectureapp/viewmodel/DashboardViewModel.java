package com.example.mvvmarchitectureapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmarchitectureapp.base.BaseViewModel;
import com.example.mvvmarchitectureapp.model.Covid19IndiaMain;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DashboardViewModel extends BaseViewModel  {

    public MutableLiveData<Covid19IndiaMain> covid19IndiaMainMutableLiveData = new MutableLiveData<>();

    public DashboardViewModel(@NonNull Application application) {
        super(application);
    }

    public void getCovidIndiaData() {
        compositeDisposable.add(covidIndia19Repository.getAllCovidIndiaData()
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribeWith(new DisposableSingleObserver<Covid19IndiaMain>(){

                                @Override
                                public void onSuccess(@NonNull Covid19IndiaMain covid19IndiaMain) {
                                    covid19IndiaMainMutableLiveData.postValue(covid19IndiaMain);
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {
                                    covid19IndiaMainMutableLiveData.postValue(null);
                                    clearAllDisposables();
                                }
                            }));
    }

    public void clearAllDisposables(){
        onCleared();
    }

}
