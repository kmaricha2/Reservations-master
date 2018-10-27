package com.example.damian.reservations;

/**
 * Created by android on 02/11/2017.
 */

public class Favoritos {
    private String id;
    private String id_usuario;
    private String id_reserva;
    private float calificacion;

    public Favoritos(String id, String id_usuario, String id_reserva, float calificacion) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_reserva = id_reserva;
        this.calificacion = calificacion;
    }

    public Favoritos() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_establecimiento) {
        this.id_reserva = id_establecimiento;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
}
