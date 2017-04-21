package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.BaseResponse;

/**
 * Created by avermes on 10/2/2017.
 */

public class EmpresaBean {

    Integer idEmpresa;
    String nomEmpresa;
    String desEmpresa;
    String urlLogo;
    String numSoporte;
    String nomSkype;
    String inClave;


    //  private ArrayList<EmpresaImpl> listaEmpresas = new ArrayList<>();

 /*   public ArrayList<EmpresaImpl> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(ArrayList<EmpresaImpl> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }*/

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getDesEmpresa() {
        return desEmpresa;
    }

    public void setDesEmpresa(String desEmpresa) {
        this.desEmpresa = desEmpresa;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getNumSoporte() {
        return numSoporte;
    }

    public void setNumSoporte(String numSoporte) {
        this.numSoporte = numSoporte;
    }

    public String getNomSkype() {
        return nomSkype;
    }

    public void setNomSkype(String nomSkype) {
        this.nomSkype = nomSkype;
    }

    public String getInClave() {
        return inClave;
    }

    public void setInClave(String inClave) {
        this.inClave = inClave;
    }
}
