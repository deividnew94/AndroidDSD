package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.BeneficioLista;

import java.util.List;

/**
 * Created by avermes on 13/2/2017.
 */

public class BeneficioListaResponse extends BaseResponse {

    public List<BeneficioLista> result;

    public List<BeneficioLista> getResult() {
        return result;
    }

    public void setResult(List<BeneficioLista> result) {
        this.result = result;
    }
}
