package com.example.proyectogooglemaps.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyectogooglemaps.R;
import com.example.proyectogooglemaps.databinding.FragmentHomeBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inicializo la vista
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Inicializo el fragmento del mapa
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map);

        //Sincronizacion
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                //Al cargar el mapa
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull LatLng latLng) {
                        //Al hacer click se inicializan los marcadores del mapa
                        MarkerOptions markerOptions = new MarkerOptions();
                        //Se establece la posición del marcador
                        markerOptions.position(latLng);
                        //Se pone título al marcador
                        markerOptions.title(latLng.latitude+":"+latLng.longitude);
                        //Borrar los marcadores (todos)
                        googleMap.clear();
                        //Hacer zoom
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                        //Añadir marcador al mapa
                        googleMap.addMarker(markerOptions);
                    }
                });

            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}