package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.FiltroListado;

import java.util.List;

/**
 * Created by avermes on 13/2/2017.
 */

public class FiltroListaResponse extends BaseResponse {

    public List<FiltroListado> result;

    public List<FiltroListado> getResult() {
        return result;
    }

    public void setResult(List<FiltroListado> result) {
        this.result = result;
    }
}
