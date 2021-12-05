package com.bmunoz.firebasebrayan.modelo;

import java.util.Date;

public class Usuario {

    private String userId;
    private String nomSensor;
    private String Tipo;
    private Date fechaIngreso;
    private String Valor;
    private String Ubicacion;
    private String Obs;

    public Usuario() {
    }

    public Usuario(String userId, String nomSensor, String Tipo, Date fechaIngreso, String Valor, String Ubicacion, String Obs) {
        this.nomSensor = nomSensor;
        this.Tipo = Tipo;
        this.fechaIngreso = fechaIngreso;
        this.Valor = Valor;
        this.userId = userId;
        this.Ubicacion=Ubicacion;
        this.Obs=Obs;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String obs) {
        Obs = obs;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getNomSensor() {
        return nomSensor;
    }

    public void setNomSensor(String nomSensor) {
        this.nomSensor = nomSensor;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        this.Valor = valor;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
