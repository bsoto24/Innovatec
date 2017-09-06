package com.codelab.innovatec.entities;

/**
 * Created by Desarrollo3 on 4/20/2017.
 */

public class PreguntaTO {

    private String pregunta;
    private String respuesta;

    public PreguntaTO(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
