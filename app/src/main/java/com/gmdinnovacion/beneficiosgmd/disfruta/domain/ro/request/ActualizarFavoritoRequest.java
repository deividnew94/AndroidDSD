package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request;

/**
 * Created by avermes on 17/2/2017.
 */

public class ActualizarFavoritoRequest {

    Integer idBeneficio;
    Integer idBeneficiario;
    Integer idFavorito;
    Integer inEstado;

    public ActualizarFavoritoRequest(Integer idBeneficio, Integer idBeneficiario, Integer idFavorito, Integer inEstado) {
        this.idBeneficio = idBeneficio;
        this.idBeneficiario = idBeneficiario;
        this.idFavorito = idFavorito;
        this.inEstado = inEstado;
    }

    public Integer getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(Integer idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

    public Integer getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Integer idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public Integer getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(Integer idFavorito) {
        this.idFavorito = idFavorito;
    }

    public Integer getInEstado() {
        return inEstado;
    }

    public void setInEstado(Integer inEstado) {
        this.inEstado = inEstado;
    }
}
