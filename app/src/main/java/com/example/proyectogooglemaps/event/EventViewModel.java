package com.example.proyectogooglemaps.event;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.proyectogooglemaps.db.EventRepository;

import java.util.List;

public class EventViewModel extends AndroidViewModel {

    private EventRepository mRepository;

    private LiveData<List<Event>> mAllEvents;

    public EventViewModel (Application application) {
        super(application);
        mRepository = new EventRepository(application);
        mAllEvents = mRepository.getAllEvents();
    }

    public LiveData<List<Event>> getAllEvents() { return mAllEvents; }

    public void insert(Event event) { mRepository.insert(event); }
}
