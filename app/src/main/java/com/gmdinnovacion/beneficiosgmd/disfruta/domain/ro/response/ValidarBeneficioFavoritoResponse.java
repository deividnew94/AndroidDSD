package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.ValidarBeneficioFavorito;

import java.util.List;

/**
 * Created by avermes on 16/2/2017.
 */

public class ValidarBeneficioFavoritoResponse extends BaseResponse {

    public List<ValidarBeneficioFavorito> result;

    public List<ValidarBeneficioFavorito> getResult() {
        return result;
    }

    public void setResult(List<ValidarBeneficioFavorito> result) {
        this.result = result;
    }
}
