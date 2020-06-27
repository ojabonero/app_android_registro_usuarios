package com.example.registrousuarios;

import android.os.Parcel;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String contraseña;
    private String email;

    public Usuario(int id, String nombre, String apellido, String nombreUsuario, String contraseña, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.email = email;
    }

    public Usuario(){

    }

    protected Usuario(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        apellido = in.readString();
        nombreUsuario = in.readString();
        contraseña = in.readString();
        email = in.readString();
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
