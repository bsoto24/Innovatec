package com.codelab.innovatec.entities;

/**
 * Created by Bryam Soto on 02/09/2017.
 */

public class Deporte {


    private String deporte;
    private int imagen;
    private boolean selected = false;

    public Deporte(String deporte, int imagen) {
        this.deporte = deporte;
        this.imagen = imagen;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
