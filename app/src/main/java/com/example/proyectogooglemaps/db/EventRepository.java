package com.example.proyectogooglemaps.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.proyectogooglemaps.dao.EventDao;
import com.example.proyectogooglemaps.event.Event;

import java.util.List;

public class EventRepository {

    private final EventDao mEventDao;
    private final LiveData<List<Event>> mAllEvents;

    public EventRepository(Application application) {
        EventRoomDatabase db = EventRoomDatabase.getDatabase(application);
        mEventDao = db.eventDao();
        mAllEvents = mEventDao.getAllEvents();
    }

    public LiveData<List<Event>> getAllEvents() {
        return mAllEvents;
    }

    public void insert (Event event) {
        new insertAsyncTask(mEventDao).execute(event);
    }

    private static class insertAsyncTask extends AsyncTask<Event, Void, Void> {

        private EventDao mAsyncTaskDao;

        insertAsyncTask(EventDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Event... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
