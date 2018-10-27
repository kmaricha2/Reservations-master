package com.example.damian.reservations;

import java.util.ArrayList;

/**
 * Created by android on 02/11/2017.
 */

public class Establecimientos {
    private String id;
    private  String nombre;
    private  String direccion;
    private String celular;
    private String foto;
    private ArrayList<Canchas> canchas;

    public Establecimientos(String id, String nombre, String direccion,String cel,ArrayList<Canchas>  canchas,String foto) {
        this.id = id;
        this.nombre = nombre;
        this.celular=cel;
        this.direccion = direccion;
        this.canchas=canchas;
        this.foto=foto;
    }

    public Establecimientos() {
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public ArrayList<Canchas> getCanchas() {
        return canchas;
    }

    public void setCanchas(ArrayList<Canchas> canchas) {
        this.canchas = canchas;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
