package com.codelab.innovatec.entities;

import java.io.Serializable;

/**
 * Created by Bryam Soto on 02/09/2017.
 */

public class Torneo implements Serializable{

    private String titulo;
    private String deporte;
    private String fecha;
    private String hora;
    private String dirección;
    private int imagen;

    public Torneo(String titulo, String deporte, String fecha, String hora, String direccion, int imagen) {
        this.titulo = titulo;
        this.deporte = deporte;
        this.fecha = fecha;
        this.hora = hora;
        this.dirección = direccion;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }
}
