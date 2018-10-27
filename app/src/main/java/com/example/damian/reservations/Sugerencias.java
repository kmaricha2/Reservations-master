package com.example.damian.reservations;

/**
 * Created by android on 21/11/2017.
 */

public class Sugerencias {
    private String id;
    private String id_usuario;
    private String tema;
    private String descripcion;
    private String fecha;
    private boolean estado;

    public Sugerencias(String id, String id_usuario, String tema, String descripcion, String fecha, boolean estado) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.tema = tema;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
