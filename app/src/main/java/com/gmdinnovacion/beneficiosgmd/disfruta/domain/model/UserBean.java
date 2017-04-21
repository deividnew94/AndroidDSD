package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

/**
 * Created by avermes on 10/2/2017.
 */

public class UserBean {

    private Integer idUsuario;
    private String logiUsuario;
    private String nomUsuario;
    private String apeUsuario;
    private String numDni;
    private String numCelular;
    private String imgUsuario;
    private EmpresaBean empresa;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogiUsuario() {
        return logiUsuario;
    }

    public void setLogiUsuario(String logiUsuario) {
        this.logiUsuario = logiUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getApeUsuario() {
        return apeUsuario;
    }

    public void setApeUsuario(String apeUsuario) {
        this.apeUsuario = apeUsuario;
    }

    public String getNumDni() {
        return numDni;
    }

    public void setNumDni(String numDni) {
        this.numDni = numDni;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getImgUsuario() {
        return imgUsuario;
    }

    public void setImgUsuario(String imgUsuario) {
        this.imgUsuario = imgUsuario;
    }

    public EmpresaBean getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaBean empresa) {
        this.empresa = empresa;
    }
}
