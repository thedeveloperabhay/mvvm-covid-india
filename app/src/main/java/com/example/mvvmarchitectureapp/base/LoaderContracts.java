package com.example.mvvmarchitectureapp.base;

import android.content.Context;

public interface LoaderContracts {

    void showProgressBar(Context context);

    void dismissProgressBar();

    void setCollapsibleToolbarTitle(String title);
}
