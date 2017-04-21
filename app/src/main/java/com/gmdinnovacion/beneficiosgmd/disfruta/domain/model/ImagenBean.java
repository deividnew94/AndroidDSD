package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

/**
 * Created by jsaenz on 19/1/2017.
 */

public class ImagenBean {
    public int idImagen;
    public String urlImagen;
    public String urlImagenPrevia;

    public ImagenBean(int idImagen, String urlImagen, String urlImagenPrevia) {
        this.idImagen = idImagen;
        this.urlImagen = urlImagen;
        this.urlImagenPrevia = urlImagenPrevia;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUrlImagenPrevia() {
        return urlImagenPrevia;
    }

    public void setUrlImagenPrevia(String urlImagenPrevia) {
        this.urlImagenPrevia = urlImagenPrevia;
    }
}
