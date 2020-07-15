package com.example.mvvmarchitectureapp.data.roomdatabase.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CovidIndia19Table")
public class CovidIndia19Table {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "State")
    public String state;

    @ColumnInfo(name = "total_cases")
    public String total_cases;

    @ColumnInfo(name = "confirmed_cases")
    public String confirmed_cases;

    @ColumnInfo(name = "active_cases")
    public String active_cases;

    @ColumnInfo(name = "recovered_cases")
    public String recovered_cases;

    @ColumnInfo(name = "deceased_cases")
    public String deceased_cases;

    public CovidIndia19Table(int id, String state, String total_cases, String confirmed_cases, String active_cases, String recovered_cases, String deceased_cases) {
        this.id = id;
        this.state = state;
        this.total_cases = total_cases;
        this.confirmed_cases = confirmed_cases;
        this.active_cases = active_cases;
        this.recovered_cases = recovered_cases;
        this.deceased_cases = deceased_cases;
    }
}
