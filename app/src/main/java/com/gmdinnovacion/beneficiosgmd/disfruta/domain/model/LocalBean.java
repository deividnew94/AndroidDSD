package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

import java.util.List;

/**
 * Created by jsaenz on 19/1/2017.
 */

public class LocalBean {
    public int idLocal;
    public String nomLocal;
    public String numLatitud;
    public String numLongitud;
    public String dirLocal;
    public String nomDistrito;
    public String numTelefono;
    public String inAbierto;
    public List<ServicioBean> servicios;

    public LocalBean(int idLocal, String nomLocal, String numLatitud, String numLongitud,
                     String dirLocal, String nomDistrito, String numTelefono, String inAbierto,
                     List<ServicioBean> servicios) {
        this.idLocal = idLocal;
        this.nomLocal = nomLocal;
        this.numLatitud = numLatitud;
        this.numLongitud = numLongitud;
        this.dirLocal = dirLocal;
        this.nomDistrito = nomDistrito;
        this.numTelefono = numTelefono;
        this.inAbierto = inAbierto;
        this.servicios = servicios;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getNomLocal() {
        return nomLocal;
    }

    public void setNomLocal(String nomLocal) {
        this.nomLocal = nomLocal;
    }

    public String getNumLatitud() {
        return numLatitud;
    }

    public void setNumLatitud(String numLatitud) {
        this.numLatitud = numLatitud;
    }

    public String getNumLongitud() {
        return numLongitud;
    }

    public void setNumLongitud(String numLongitud) {
        this.numLongitud = numLongitud;
    }

    public String getDirLocal() {
        return dirLocal;
    }

    public void setDirLocal(String dirLocal) {
        this.dirLocal = dirLocal;
    }

    public String getNomDistrito() {
        return nomDistrito;
    }

    public void setNomDistrito(String nomDistrito) {
        this.nomDistrito = nomDistrito;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getInAbierto() {
        return inAbierto;
    }

    public void setInAbierto(String inAbierto) {
        this.inAbierto = inAbierto;
    }

    public List<ServicioBean> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioBean> servicios) {
        this.servicios = servicios;
    }
}
