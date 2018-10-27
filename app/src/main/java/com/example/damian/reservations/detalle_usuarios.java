package com.example.damian.reservations;

/**
 * Created by android on 02/11/2017.
 */

public class detalle_usuarios {
    private  String id;
    private String id_usuarios;
    private int tipo;
    private String nombres;
    private String apellidos;
    private String celular;
    private String correo;
    private String fecha_nacimiento;
    private int sexo;

    public detalle_usuarios() {

    }

    public detalle_usuarios(String nombres, String apellidos, String celular, String correo, String fecha_nacimiento, int sexo, String id, int tipo) {
        this.id = id;
        this.id_usuarios = "";
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.tipo=0;
    }

    public String getId() {
        return id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(String id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public void Guardar(){
        Model_usuarios.GuardarDetalleUsuario(this);
    }
}
