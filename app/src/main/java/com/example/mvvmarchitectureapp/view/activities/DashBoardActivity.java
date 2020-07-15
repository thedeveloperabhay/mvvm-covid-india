package com.example.mvvmarchitectureapp.view.activities;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmarchitectureapp.R;
import com.example.mvvmarchitectureapp.base.BaseActivity;
import com.example.mvvmarchitectureapp.databinding.ActivityDashboardBinding;
import com.example.mvvmarchitectureapp.model.Covid19IndiaMain;
import com.example.mvvmarchitectureapp.viewmodel.DashboardViewModel;

public class DashBoardActivity extends BaseActivity<ActivityDashboardBinding> {

    private ActivityDashboardBinding dashboardBinding;
    private DashboardViewModel dashboardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dashboardBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_dashboard, getContainer(), true);
        setCollapsibleToolbarTitle("CoronaVirus19 India");
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        setDashboardObservers();


    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgressBar(this);
        dashboardViewModel.getCovidIndiaData();
    }

    private void setDashboardObservers() {
        dashboardViewModel.covid19IndiaMainMutableLiveData.observe(this, new Observer<Covid19IndiaMain>() {
            @Override
            public void onChanged(Covid19IndiaMain covid19IndiaMain) {
                populateData(covid19IndiaMain);
            }
        });
    }

    private void populateData(Covid19IndiaMain covid19IndiaMain) {
        dismissProgressBar();
        if(covid19IndiaMain!=null && covid19IndiaMain.getStateWiseList()!=null && !covid19IndiaMain.getStateWiseList().isEmpty()){
            dashboardBinding.totalCaseTextValue.setText(covid19IndiaMain.getStateWiseList().get(0).getConfirmed());
            dashboardBinding.actvCaseTextValue.setText(covid19IndiaMain.getStateWiseList().get(0).getActive());
            dashboardBinding.recoveredCaseTextValue.setText(covid19IndiaMain.getStateWiseList().get(0).getRecovered());
            dashboardBinding.deceasedCaseTextValue.setText(covid19IndiaMain.getStateWiseList().get(0).getDeaths());
        }else{
            dashboardViewModel.clearAllDisposables();
        }
    }

}
