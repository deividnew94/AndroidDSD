package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

import io.realm.RealmObject;

/**
 * Created by jsaenz on 19/1/2017.
 */

public class DetalleProveedor  extends RealmObject {
    public int idProveedor;
    public String photoRestaurante;
    public String nombreRestaurante;
    public String categoria;
    public String direccion;
    public String distrito;
    public Float  appCompatRatingBarDcto;
    public String ratingText;
    public String telefonos;
    public String abierto;
    public String urlWeb;
    public String longitud;
    public String latitud;
    public String descripcion;
    public String reservas;
    public String tarjetasCredito;
    public String wifi;
    public String estacionamiento;
    public String horaDscto;

    public DetalleProveedor(int idProveedor, String photoRestaurante, String nombreRestaurante, String categoria, String direccion, String distrito, Float appCompatRatingBarDcto, String ratingText, String telefonos, String abierto, String urlWeb, String longitud, String latitud, String descripcion, String reservas, String tarjetasCredito, String wifi, String estacionamiento, String horaDscto) {
        this.idProveedor = idProveedor;
        this.photoRestaurante = photoRestaurante;
        this.nombreRestaurante = nombreRestaurante;
        this.categoria = categoria;
        this.direccion = direccion;
        this.distrito = distrito;
        this.appCompatRatingBarDcto = appCompatRatingBarDcto;
        this.ratingText = ratingText;
        this.telefonos = telefonos;
        this.abierto = abierto;
        this.urlWeb = urlWeb;
        this.longitud = longitud;
        this.latitud = latitud;
        this.descripcion = descripcion;
        this.reservas = reservas;
        this.tarjetasCredito = tarjetasCredito;
        this.wifi = wifi;
        this.estacionamiento = estacionamiento;
        this.horaDscto = horaDscto;
    }

    public DetalleProveedor() {

    }


    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
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

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getAbierto() {
        return abierto;
    }

    public void setAbierto(String abierto) {
        this.abierto = abierto;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReservas() {
        return reservas;
    }

    public void setReservas(String reservas) {
        this.reservas = reservas;
    }

    public String getTarjetasCredito() {
        return tarjetasCredito;
    }

    public void setTarjetasCredito(String tarjetasCredito) {
        this.tarjetasCredito = tarjetasCredito;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(String estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    public String getHoraDscto() {
        return horaDscto;
    }

    public void setHoraDscto(String horaDscto) {
        this.horaDscto = horaDscto;
    }
}
