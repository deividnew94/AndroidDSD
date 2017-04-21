package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

/**
 * Created by jsaenz on 19/1/2017.
 */

public class ServicioBean {
    public int idServicio;
    public String nomServicio;
    public String inActivo;

    public ServicioBean(int idServicio, String nomServicio, String inActivo) {
        this.idServicio = idServicio;
        this.nomServicio = nomServicio;
        this.inActivo = inActivo;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNomServicio() {
        return nomServicio;
    }

    public void setNomServicio(String nomServicio) {
        this.nomServicio = nomServicio;
    }

    public String getInActivo() {
        return inActivo;
    }

    public void setInActivo(String inActivo) {
        this.inActivo = inActivo;
    }
}
