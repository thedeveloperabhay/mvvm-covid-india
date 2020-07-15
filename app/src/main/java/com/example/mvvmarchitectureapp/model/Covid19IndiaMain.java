package com.example.mvvmarchitectureapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Covid19IndiaMain {

    @SerializedName("cases_time_series")
    private List<CasesTimeSeries> casesTimeSeriesList;

    @SerializedName("statewise")
    private List<StateWise> stateWiseList;

    public List<StateWise> getStateWiseList() {
        return stateWiseList;
    }

    public void setStateWiseList(List<StateWise> stateWiseList) {
        this.stateWiseList = stateWiseList;
    }

    public List<CasesTimeSeries> getCasesTimeSeriesList() {
        return casesTimeSeriesList;
    }

    public void setCasesTimeSeriesList(List<CasesTimeSeries> casesTimeSeriesList) {
        this.casesTimeSeriesList = casesTimeSeriesList;
    }
}
