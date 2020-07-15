package com.example.mvvmarchitectureapp.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.mvvmarchitectureapp.data.repository.CovidIndia19Repository;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class BaseViewModel extends AndroidViewModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected CovidIndia19Repository covidIndia19Repository = CovidIndia19Repository.getInstance();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
        compositeDisposable.dispose();
    }
}
