package com.gmdinnovacion.beneficiosgmd.disfruta.services.dao;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Parametric;

import java.util.ArrayList;



/**
 * Created by jmauriciog on 02/06/2016.
 */
public interface ParametricDAO {

    public boolean isEmpty();

    public ArrayList<Parametric> getElements();

    public long insertAll(ArrayList<Parametric> models);

}
