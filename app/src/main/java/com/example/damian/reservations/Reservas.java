package com.example.damian.reservations;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by android on 02/11/2017.
 */

public class Reservas {
    private String id;
    private String id_cancha;
    private String id_usuario;
    private String fecha;
    private ArrayList<Integer> horas;
    private boolean estado;
    private String id_establecimiento;

    public Reservas(String id, String id_cancha, String id_usuario, String fecha, ArrayList<Integer> horas, boolean estado, String id_establecimiento) {
        this.id = id;
        this.id_cancha = id_cancha;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.horas = horas;
        this.estado = estado;
        this.id_establecimiento = id_establecimiento;
    }

    public Reservas() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_cancha() {
        return id_cancha;
    }

    public void setId_cancha(String id_cancha) {
        this.id_cancha = id_cancha;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Integer> getHora() {
        return horas;
    }

    public void setHora(ArrayList<Integer> hora) {
        this.horas = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getId_establecimiento() {
        return id_establecimiento;
    }

    public void setId_establecimiento(String id_establecimiento) {
        this.id_establecimiento = id_establecimiento;
    }
}
