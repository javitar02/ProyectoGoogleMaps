package com.example.proyectogooglemaps.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.proyectogooglemaps.event.Event;

import java.util.List;

@Dao
public interface EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Event event);

    @Query("DELETE FROM event")
    void deleteAll();

    @Query("SELECT * from event ORDER BY date DESC")
    LiveData<List<Event>> getAllEvents();


}
