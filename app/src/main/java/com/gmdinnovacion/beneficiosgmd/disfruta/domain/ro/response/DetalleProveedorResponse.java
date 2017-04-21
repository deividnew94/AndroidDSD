package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleProveedorBean;

/**
 * Created by avermes on 8/2/2017.
 */
public class DetalleProveedorResponse extends BaseResponse {

    DetalleProveedorBean result;


    public DetalleProveedorBean getResult() {
        return result;
    }

    public void setResult(DetalleProveedorBean result) {
        this.result = result;
    }

}
