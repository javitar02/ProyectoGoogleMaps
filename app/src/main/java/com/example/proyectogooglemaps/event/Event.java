package com.example.proyectogooglemaps.event;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.proyectogooglemaps.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity(tableName = "event")
public class Event {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String nombre;

    @ColumnInfo(name = "date")
    private long fecha;

    @ColumnInfo(name = "description")
    private String descripcion;

    @ColumnInfo(name = "latity")
    private double latitud;

    @ColumnInfo(name = "location")
    private double localizacion;


    public Event(String nombre, Long fecha, double latitud,double localizacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.localizacion = localizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public double getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(int localizacion) {
        this.localizacion = localizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Event getEvent() {
        return this;
    }
}
