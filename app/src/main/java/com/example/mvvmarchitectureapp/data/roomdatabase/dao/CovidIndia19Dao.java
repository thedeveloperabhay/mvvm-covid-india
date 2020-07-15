package com.example.mvvmarchitectureapp.data.roomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvvmarchitectureapp.data.roomdatabase.entity.CovidIndia19Table;

import java.util.List;

@Dao
public interface CovidIndia19Dao {

    @Query("Select * from CovidIndia19Table")
    List<CovidIndia19Table> getAllCovidIndiaStateData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCovid19StateDetails(CovidIndia19Table covidIndia19Table);


}
