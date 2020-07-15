package com.example.mvvmarchitectureapp.data.roomdatabase.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mvvmarchitectureapp.data.roomdatabase.entity.CovidIndia19Table;

@Database(entities = {CovidIndia19Table.class}, version = 1, exportSchema = false)
public abstract class CovidIndiaRoomDatabase extends RoomDatabase {

    private static final String DB_NAME = "CovidIndia19.db";

    private static CovidIndiaRoomDatabase INSTANCE;

    public static CovidIndiaRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (CovidIndiaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CovidIndiaRoomDatabase.class, DB_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
