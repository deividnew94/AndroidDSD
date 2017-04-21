package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;


import io.realm.RealmObject;

/**
 * Created by jmauriciog on 02/06/2016.
 */
public class Parametric  extends RealmObject {

    private String key;
    private String value;

    public Parametric(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
