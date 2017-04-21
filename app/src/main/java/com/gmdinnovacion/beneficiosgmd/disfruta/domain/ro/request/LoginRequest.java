package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request;

/**
 * Created by avermes on 8/2/2017.
 */
public class LoginRequest {
    /*{"idEmpresa":"1", "nomUsuario":"avermes", "passUsuario":"Miercoles1416#"}*/

    private int idEmpresa;
    private String nomUsuario;
    private String passUsuario;

    public LoginRequest(int empresa, String codigoUsuarioSesion, String password){
        idEmpresa = empresa;
        nomUsuario = codigoUsuarioSesion;
        passUsuario = password;

    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }
/*
    private String idUsuario;
    private String idEmpresa;
    private String logiUsuario;
    private String apeUsuario;
    private String nomEmpresa;
    private String imgUsuario;


            "idUsuario": 2,
            "idEmpresa": 1,
            "logiUsuario": "avermes",
            "nomUsuario": "Ana",
            "apeUsuario": "Verme Solano",
            "nomEmpresa": "GMD",
            "imgUsuario": null

     */

//    public LoginRequest(String idUsuario, String idEmpresa, String logiUsuario, String apeUsuario, String nomEmpresa, String imgUsuario){
//
//

//    }

}
