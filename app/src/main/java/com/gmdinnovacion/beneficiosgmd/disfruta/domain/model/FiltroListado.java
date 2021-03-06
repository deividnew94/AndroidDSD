package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

/**
 * Created by avermes on 24/01/2017.
 */

public class FiltroListado {

    public int  idEje;
    public String     nomEje;
    public String     imgEje;
    public String     iconEje;

    public FiltroListado(int idEje, String nomEje, String imgEje, String iconEje) {
        this.idEje = idEje;
        this.nomEje = nomEje;
        this.imgEje = imgEje;
        this.iconEje = iconEje;
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

    public String getIconEje() {
        return iconEje;
    }

    public void setIconEje(String iconEje) {
        this.iconEje = iconEje;
    }
}
