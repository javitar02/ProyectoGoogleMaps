package com.example.proyectogooglemaps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectogooglemaps.R;
import com.example.proyectogooglemaps.event.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{
    public List<Event> eventList;
    private final Context context;

    public EventAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        long fechaAInsertar;

        fechaAInsertar = Long.parseLong(String.valueOf(eventList.get(position).getFecha()));
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String fechaString = format.format(new Date(fechaAInsertar));

        if(eventList != null){
            holder.nombre.setText(eventList.get(position).getNombre());
            holder.latitud.setText(String.valueOf(eventList.get(position).getLatitud()));
            holder.localizacion.setText(String.valueOf(eventList.get(position).getLocalizacion()));
            holder.fecha.setText(fechaString);
        }

    }

    @Override
    public int getItemCount() {
        if (eventList != null)
            return eventList.size();
        else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nombre,fecha,latitud,localizacion;
        public long fechaAInsertar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.titulo);
            fecha = itemView.findViewById(R.id.fecha);
            latitud = itemView.findViewById(R.id.latitud);
            localizacion = itemView.findViewById(R.id.localizacion);
        }
    }

    public void setEvents(List<Event>events){
        eventList = events;
        notifyDataSetChanged();
    }
}
