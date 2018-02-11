package com.example.diurno.ligaendesa;

/**
 * Created by zeeshan on 28/10/2017.
 */

public class Equipo {

    private int imagen;
    private String nombre;
    private String lugar;
    private String estadio;
    private String presidente;
    private String web;

    public Equipo(int imagen, String nombre, String lugar, String estadio, String presidente, String web) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.lugar = lugar;
        this.estadio = estadio;
        this.presidente = presidente;
        this.web = web;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
