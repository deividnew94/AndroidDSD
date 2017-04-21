package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

/**
 * Created by jsaenz on 17/1/2017.
 */

public class DetalleGaleria {
        public String photoRestaurante;
        public String descrRestaurante;

    public DetalleGaleria(String photoRestaurante, String descrRestaurante) {
        this.photoRestaurante = photoRestaurante;
        this.descrRestaurante = descrRestaurante;
    }

    public String getPhotoRestaurante() {
        return photoRestaurante;
    }

    public void setPhotoRestaurante(String photoRestaurante) {
        this.photoRestaurante = photoRestaurante;
    }

    public String getDescrRestaurante() {
        return descrRestaurante;
    }

    public void setDescrRestaurante(String descrRestaurante) {
        this.descrRestaurante = descrRestaurante;
    }
}
