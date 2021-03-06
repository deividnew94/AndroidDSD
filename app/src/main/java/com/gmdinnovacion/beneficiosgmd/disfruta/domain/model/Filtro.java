package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

/**
 * Created by jsaenz on 19/1/2017.
 */

public class Filtro {
    public int idEje;
    public String nomEje;
    public String imgEje;
    public String imgSEje;
    public String iconEje;
    public Boolean selectImage;

    public Filtro(int idEje, String nomEje, String imgEje, String imgSEje, String iconEje, Boolean selectImage) {
        this.idEje = idEje;
        this.nomEje = nomEje;
        this.imgEje = imgEje;
        this.imgSEje = imgSEje;
        this.iconEje = iconEje;
        this.selectImage = selectImage;
    }

    public int getIdEje() {
        return idEje;
    }

    public void setIdEje(int idEje) {
        this.idEje = idEje;
    }

    public String getNomEje() {
        return nomEje;
    }

    public void setNomEje(String nomEje) {
        this.nomEje = nomEje;
    }

    public String getImgEje() {
        return imgEje;
    }

    public void setImgEje(String imgEje) {
        this.imgEje = imgEje;
    }

    public String getImgSEje() {
        return imgSEje;
    }

    public void setImgSEje(String imgSEje) {
        this.imgSEje = imgSEje;
    }

    public String getIconEje() {
        return iconEje;
    }

    public void setIconEje(String iconEje) {
        this.iconEje = iconEje;
    }

    public Boolean getSelectImage() {
        return selectImage;
    }

    public void setSelectImage(Boolean selectImage) {
        this.selectImage = selectImage;
    }
}
