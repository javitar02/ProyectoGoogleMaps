package com.example.proyectogooglemaps.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.proyectogooglemaps.dao.EventDao;
import com.example.proyectogooglemaps.event.Event;

@Database(entities = {Event.class}, version = 1, exportSchema = false)
public abstract class EventRoomDatabase extends RoomDatabase {

    public abstract EventDao eventDao();
    private static EventRoomDatabase INSTANCE;

    static EventRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EventRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EventRoomDatabase.class, "events_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

