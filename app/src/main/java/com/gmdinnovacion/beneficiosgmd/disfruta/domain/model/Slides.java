package com.gmdinnovacion.beneficiosgmd.disfruta.domain.model;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;

/**
 * Created by innovagmd on 30/11/16.
 */

//public enum Slides {
//    SLIDE1(R.string.app_name, R.layout.slide_1),
//    SLIDE2(R.string.app_name, R.layout.slide_1),
//    SLIDE3(R.string.app_name, R.layout.slide_1);
//
//    private int mTitleResId;
//    private int mLayoutResId;
//
//    Slides(int titleResId, int layoutResId) {
//        mTitleResId = titleResId;
//        mLayoutResId = layoutResId;
//    }
//
//    public int getTitleResId() {
//        return mTitleResId;
//    }
//
//    public int getLayoutResId() {
//        return mLayoutResId;
//    }
//
//}

public class Slides {
    private  int titulo;
    private int descripcion;
    private int imagen;

    public Slides(int titulo, int descripcion, int imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public int getTitulo() {
        return titulo;
    }

    public void setTitulo(int titulo) {
        this.titulo = titulo;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}