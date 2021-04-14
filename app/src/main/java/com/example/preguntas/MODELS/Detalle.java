package com.example.preguntas.MODELS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Detalle {

    public List<Preguntas> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Preguntas> preguntas) {
        this.preguntas = preguntas;
    }

    public String getDuracionExamen() {
        return duracionExamen;
    }

    public void setDuracionExamen(String duracionExamen) {
        this.duracionExamen = duracionExamen;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }
    @SerializedName("preguntas")
    @Expose
    public List<Preguntas> preguntas;
    @SerializedName("duracionExamen")
    @Expose
    public String duracionExamen;
    @SerializedName("nivel")
    @Expose
    public String nivel;
    @SerializedName("idExamen")
    @Expose
    public int idExamen;
    @SerializedName("tipoExamen")
    @Expose
    public String tipoExamen;
}
