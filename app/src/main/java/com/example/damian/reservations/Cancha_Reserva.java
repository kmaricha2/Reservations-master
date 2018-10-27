package com.example.damian.reservations;

import java.util.ArrayList;

/**
 * Created by DAMIAN on 13/11/2017.
 */

public class Cancha_Reserva {
    private String id_reserva;
    private String id_establecimiento;
    private String nombre_establecimiento;
    private String numero_cancha;
    private String fecha;
    private ArrayList<Integer> hora;
    private String celular;
    private String Direccion;
    private String foto;
    private boolean estado;
    private String hora_tras="";
    public Cancha_Reserva(String id_reserva, String nombre_establecimiento, String numero_cancha, String fecha, ArrayList<Integer> hora,String celular,String direccion,boolean estado,String id_establecmiento,String foto) {
        this.id_reserva = id_reserva;
        this.nombre_establecimiento = nombre_establecimiento;
        this.numero_cancha = numero_cancha;
        this.fecha = ConvertirFecha(fecha);
        this.hora = hora;
        this.hora_tras=ConvertirHora(hora.get(0));
        this.Direccion=direccion;
        this.celular=celular;
        this.estado=estado;
        this.id_establecimiento=id_establecmiento;
        this.foto=foto;
    }

    public Cancha_Reserva() {
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getId_establecimiento() {
        return id_establecimiento;
    }

    public void setId_establecimiento(String id_establecimiento) {
        this.id_establecimiento = id_establecimiento;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getHora_tras() {
        return hora_tras;
    }

    public void setHora_tras(String hora_tras) {
        this.hora_tras = hora_tras;
    }

    public String getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(String id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getNombre_establecimiento() {
        return nombre_establecimiento;
    }

    public void setNombre_establecimiento(String nombre_establecimiento) {
        this.nombre_establecimiento = nombre_establecimiento;
    }

    public String getNumero_cancha() {
        return numero_cancha;
    }

    public void setNumero_cancha(String numero_cancha) {
        this.numero_cancha = numero_cancha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Integer> getHora() {
        return hora;
    }

    public void setHora(ArrayList<Integer> hora) {
        this.hora = hora;
    }

    public String ConvertirFecha(String fecha){
        String [] date = fecha.split("/");
        if (date[1].equalsIgnoreCase("01") || date[1].equalsIgnoreCase("1")){
            return "Enero " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("02") || date[1].equalsIgnoreCase("2")){
            return "Febrero " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("03") || date[1].equalsIgnoreCase("3")){
            return "Marzo " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("04") || date[1].equalsIgnoreCase("4")){
            return "Abril " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("05") || date[1].equalsIgnoreCase("5")){
            return "Mayo " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("06") || date[1].equalsIgnoreCase("6")){
            return "Junio " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("07") || date[1].equalsIgnoreCase("7")){
            return "Julio " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("08") || date[1].equalsIgnoreCase("8")){
            return "Agosto " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("09") || date[1].equalsIgnoreCase("9")){
            return "Septiembre " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("10") ){
            return "Octubre " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("11") ){
            return "Noviembre " + date [0] +" de "+date[2];
        }else   if (date[1].equalsIgnoreCase("12") ){
            return "Diciembre " + date [0] +" de "+date[2];
        }
return fecha;
    }
    public String ConvertirHora(int x){
     if (x==12){
    return  "12 PM";
   }
      if (x==24){
    return  "12 AM";
 }
        if (x>12){
            return (x-12) + " PM";
        }
        return x+" AM";
    }
}
