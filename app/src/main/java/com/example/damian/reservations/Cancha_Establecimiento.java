package com.example.damian.reservations;

import java.util.ArrayList;

/**
 * Created by android on 08/11/2017.
 */

public class Cancha_Establecimiento {
    private String id_cacha;
    private String nombre_establecimiento;
    private String direccion;
    private String celular;
    private String id_establecimiento;
    private String foto;
    private String tamano;
    private ArrayList<Integer> programacion;

    public Cancha_Establecimiento(String id_cacha, String nombre_establecimiento, String direccion, String celular, String tamano,ArrayList<Integer> programacion,String id_establecimiento,String foto) {
        this.id_cacha = id_cacha;
        this.nombre_establecimiento = nombre_establecimiento;
        this.direccion = direccion;
        this.celular = celular;
        this.tamano = tamano;
        this.programacion = programacion;
        this.id_establecimiento=id_establecimiento;
        this.foto=foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getId_establecimiento() {
        return id_establecimiento;
    }

    public void setId_establecimiento(String id_establecimiento) {
        this.id_establecimiento = id_establecimiento;
    }

    public ArrayList<Integer> getProgramacion() {
        return programacion;
    }

    public void setProgramacion(ArrayList<Integer> programacion) {
        this.programacion = programacion;
    }

    public String getId_cacha() {
        return id_cacha;
    }

    public void setId_cacha(String id_cacha) {
        this.id_cacha = id_cacha;
    }

    public String getNombre_establecimiento() {
        return nombre_establecimiento;
    }

    public void setNombre_establecimiento(String nombre_establecimiento) {
        this.nombre_establecimiento = nombre_establecimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
}
