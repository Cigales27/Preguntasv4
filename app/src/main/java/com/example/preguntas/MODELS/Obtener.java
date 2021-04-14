package com.example.preguntas.MODELS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Obtener {
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    @SerializedName("estado")
    @Expose
    public boolean estado;
    @SerializedName("detalle")
    @Expose
    public Detalle detalle;
}