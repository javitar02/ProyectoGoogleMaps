package com.example.proyectogooglemaps.ui.dashboard;

import android.icu.util.ULocale;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectogooglemaps.BuildConfig;
import com.example.proyectogooglemaps.R;
import com.example.proyectogooglemaps.adapter.EventAdapter;
import com.example.proyectogooglemaps.databinding.FragmentDashboardBinding;
import com.example.proyectogooglemaps.event.Event;
import com.example.proyectogooglemaps.event.EventViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import kotlin.jvm.internal.PropertyReference0Impl;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    private EventViewModel mEventViewModel;
    private EventAdapter adapter;
    private CalendarView calDate;

    private EditText nombre, descripcion,latitud, localizacion;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button;
        button = root.findViewById(R.id.addEventButton);
        mEventViewModel = ViewModelProviders.of(this).get(EventViewModel.class);

        calDate = root.findViewById(R.id.calendarView);
        final long[] newDate = {0};
        calDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Calendar c = Calendar.getInstance();
                c.set(year, month, day);
                newDate[0] = c.getTimeInMillis();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = root.findViewById(R.id.titulo);
                descripcion = root.findViewById(R.id.descripcion);
                latitud = root.findViewById(R.id.latitud);
                localizacion = root.findViewById(R.id.localizacion);

                Event event = new Event(nombre.getText().toString(),newDate[0],Double.parseDouble(latitud.getText().toString()),Double.parseDouble(localizacion.getText().toString()));
                mEventViewModel.insert(event);

            }
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}