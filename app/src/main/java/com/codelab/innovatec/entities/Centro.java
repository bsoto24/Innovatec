package com.codelab.innovatec.entities;

/**
 * Created by ALEXIS on 2/09/2017.
 */

public class Centro {

    public String nombre;
    public int imagen;

    public Centro(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}