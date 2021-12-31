package com.example.roomdatabaseexample.myDb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {

    private static MyRoomDatabase DATABASE_INSTANCE;

    public abstract UserDao userDao();

    public static MyRoomDatabase getDbInstance(Context context) {

        if (DATABASE_INSTANCE == null) {
            DATABASE_INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyRoomDatabase.class, "MY_DATABASE")
                    .allowMainThreadQueries()
                    .build();
        }
        return DATABASE_INSTANCE;

    }
}
