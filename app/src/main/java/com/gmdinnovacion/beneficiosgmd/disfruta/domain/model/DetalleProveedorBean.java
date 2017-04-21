package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.LogUtil;

import java.util.List;

/**
 * Created by jsaenz on 19/1/2017.
 */

public class DetalleProveedorBean{

    public int idBeneficio;
    public String nomBeneficio;
    public String desBeneficio;
    public String urlProveedor;
    public Double puntBeneficio;
    public int idFavorito;
    public String imgBeneficio;
    public String fonBeneficio;
    public EjeBean eje;
    public LocalBean local;
    public List<ImagenBean> imagenes;

    public DetalleProveedorBean(int idBeneficio, String nomBeneficio, String desBeneficio,
                                String urlProveedor, Double puntBeneficio, int idFavorito,
                                String imgBeneficio, String fonBeneficio, EjeBean eje,
                                LocalBean local, List<ImagenBean> imagenes) {
        this.idBeneficio = idBeneficio;
        this.nomBeneficio = nomBeneficio;
        this.desBeneficio = desBeneficio;
        this.urlProveedor = urlProveedor;
        this.puntBeneficio = puntBeneficio;
        this.idFavorito = idFavorito;
        this.imgBeneficio = imgBeneficio;
        this.fonBeneficio = fonBeneficio;
        this.eje = eje;
        this.local = local;
        this.imagenes = imagenes;
    }

    public int getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(int idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

    public String getNomBeneficio() {
        return nomBeneficio;
    }

    public void setNomBeneficio(String nomBeneficio) {
        this.nomBeneficio = nomBeneficio;
    }

    public String getDesBeneficio() {
        return desBeneficio;
    }

    public void setDesBeneficio(String desBeneficio) {
        this.desBeneficio = desBeneficio;
    }

    public String getUrlProveedor() {
        return urlProveedor;
    }

    public void setUrlProveedor(String urlProveedor) {
        this.urlProveedor = urlProveedor;
    }

    public Double getPuntBeneficio() {
        return puntBeneficio;
    }

    public void setPuntBeneficio(Double puntBeneficio) {
        this.puntBeneficio = puntBeneficio;
    }

    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public String getImgBeneficio() {
        return imgBeneficio;
    }

    public void setImgBeneficio(String imgBeneficio) {
        this.imgBeneficio = imgBeneficio;
    }

    public String getFonBeneficio() {
        return fonBeneficio;
    }

    public void setFonBeneficio(String fonBeneficio) {
        this.fonBeneficio = fonBeneficio;
    }

    public EjeBean getEje() {
        return eje;
    }

    public void setEje(EjeBean eje) {
        this.eje = eje;
    }

    public LocalBean getLocal() {
        return local;
    }

    public void setLocal(LocalBean local) {
        this.local = local;
    }

    public List<ImagenBean> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenBean> imagenes) {
        this.imagenes = imagenes;
    }
}
