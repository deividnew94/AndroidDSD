package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response;


import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Parametric;

import java.util.ArrayList;

/**
 * Created by jmauriciog on 03/06/2016.
 */
public class ParametricResponse extends BaseResponse {

    ArrayList<Parametric> parametricList;

    public ArrayList<Parametric> getParametricList() {
        return parametricList;
    }

    public void setParametricList(ArrayList<Parametric> parametricList) {
        this.parametricList = parametricList;
    }


}
