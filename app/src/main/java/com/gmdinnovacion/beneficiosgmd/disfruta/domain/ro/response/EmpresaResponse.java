package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Empresa;

import java.util.List;

/**
 * Created by avermes on 23/01/2017.
 */

public class EmpresaResponse extends BaseResponse {

    public List<Empresa> result;

    public List<Empresa> getResult() {
        return result;
    }

    public void setResult(List<Empresa> result) {
        this.result = result;
    }

}
