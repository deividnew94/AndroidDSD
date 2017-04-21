package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

/**
 * Created by avermes on 16/12/2016.
 */

public class DetalleDescuento {
    public String photoRestaurante;
    public String nombreRestaurante;
    public Float  appCompatRatingBarDcto;
    public String ratingText;
    public String abierto;
    public String Position;
    public String horaDscto;
    public String ticket;

    public DetalleDescuento(String photoRestaurante, String nombreRestaurante, Float appCompatRatingBarDcto, String ratingText, String abierto, String position, String horaDscto, String ticket) {

    }

    public DetalleDescuento(String s, String s1, float v) {
    }

    public String getPhotoRestaurante() {
        return photoRestaurante;
    }

    public void setPhotoRestaurante(String photoRestaurante) {
        this.photoRestaurante = photoRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public Float getAppCompatRatingBarDcto() {
        return appCompatRatingBarDcto;
    }

    public void setAppCompatRatingBarDcto(Float appCompatRatingBarDcto) {
        this.appCompatRatingBarDcto = appCompatRatingBarDcto;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    public String getAbierto() {
        return abierto;
    }

    public void setAbierto(String abierto) {
        this.abierto = abierto;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getHoraDscto() {
        return horaDscto;
    }

    public void setHoraDscto(String horaDscto) {
        this.horaDscto = horaDscto;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
