package com.example.proyectogooglemaps.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectogooglemaps.R;
import com.example.proyectogooglemaps.adapter.EventAdapter;
import com.example.proyectogooglemaps.event.Event;
import com.example.proyectogooglemaps.databinding.FragmentNotificationsBinding;
import com.example.proyectogooglemaps.event.EventViewModel;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {
    private FragmentNotificationsBinding binding;
    private RecyclerView recyclerEvents;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        RecyclerView recyclerView = root.findViewById(R.id.recycler);
        final EventAdapter adapter = new EventAdapter(requireContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        EventViewModel mEventsViewModel = ViewModelProviders.of(this).get(EventViewModel.class);
        mEventsViewModel.getAllEvents().observe((LifecycleOwner) requireContext(), eventos -> adapter.setEvents(eventos));

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}