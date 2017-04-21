package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.FiltroBean;

import java.util.List;

/**
 * Created by avermes on 13/2/2017.
 */

public class FiltroResponse extends BaseResponse {

    public List<FiltroBean> result;

    public List<FiltroBean> getResult() {
        return result;
    }

    public void setResult(List<FiltroBean> result) {
        this.result = result;
    }
}
