package com.example.damian.reservations;

import java.util.Date;

/**
 * Created by android on 02/11/2017.
 */

public class Usuarios {
    private String id;
    private String usuario;
    private String contrasena;
    private Date fecha_creacion;
    private boolean estado;

    public Usuarios(String id, String usuario, String contrasena, Date fecha_creacion, boolean estado) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
