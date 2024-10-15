package com.miempresa.celulares;

import java.io.Serializable;

public class Celular implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String marca;
    private String modelo;

    public Celular(int id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Celular{id=" + id + ", marca='" + marca + "', modelo='" + modelo + "'}";
    }
}
