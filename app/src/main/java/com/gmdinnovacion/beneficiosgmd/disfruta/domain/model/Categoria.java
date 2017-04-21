package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

/**
 * Created by innovagmd on 05/12/16.
 */

public class Categoria {

    public String name;
    public String photo;
    public int ideje;

    public Categoria(String name, String photo, int ideje) {
        this.name = name;
        this.photo = photo;
        this.ideje = ideje;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getIdeje() {
        return ideje;
    }

    public void setIdeje(int ideje) {
        this.ideje = ideje;
    }
}
