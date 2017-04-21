package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

/**
 * Created by jsaenz on 19/1/2017.
 */

public class DetalleDescuentoRepositorio {

    public  int idProveedor;
    public String fotoRestaurante;
    public String nombreRestaurante;
    public String categoria;
    public boolean favorito;
    public Float  ratingDescuento;
    public String ratingTexto;
    public String abiertoC;
    public String posicion;
    public String horaDesct;
    public String ticket;
    public  int idEje;


    public DetalleDescuentoRepositorio(int idProveedor, String fotoRestaurante, String nombreRestaurante, String categoria, boolean favorito, Float ratingDescuento, String ratingTexto, String abiertoC, String posicion, String horaDesct, String ticket, int idEje) {
        this.idProveedor = idProveedor;
        this.fotoRestaurante = fotoRestaurante;
        this.nombreRestaurante = nombreRestaurante;
        this.categoria = categoria;
        this.favorito = favorito;
        this.ratingDescuento = ratingDescuento;
        this.ratingTexto = ratingTexto;
        this.abiertoC = abiertoC;
        this.posicion = posicion;
        this.horaDesct = horaDesct;
        this.ticket = ticket;
        this.idEje = idEje;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getFotoRestaurante() {
        return fotoRestaurante;
    }

    public void setFotoRestaurante(String fotoRestaurante) {
        this.fotoRestaurante = fotoRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public Float getRatingDescuento() {
        return ratingDescuento;
    }

    public void setRatingDescuento(Float ratingDescuento) {
        this.ratingDescuento = ratingDescuento;
    }

    public String getRatingTexto() {
        return ratingTexto;
    }

    public void setRatingTexto(String ratingTexto) {
        this.ratingTexto = ratingTexto;
    }

    public String getAbiertoC() {
        return abiertoC;
    }

    public void setAbiertoC(String abiertoC) {
        this.abiertoC = abiertoC;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getHoraDesct() {
        return horaDesct;
    }

    public void setHoraDesct(String horaDesct) {
        this.horaDesct = horaDesct;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getIdEje() {
        return idEje;
    }

    public void setIdEje(int idEje) {
        this.idEje = idEje;
    }
}
