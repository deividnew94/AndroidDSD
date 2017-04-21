package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

/**
 * Created by avermes on 28/12/2016.
 */

public class RegionesLogin {

    String nombreEmpresa;
    Boolean estado=false;

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public RegionesLogin(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
