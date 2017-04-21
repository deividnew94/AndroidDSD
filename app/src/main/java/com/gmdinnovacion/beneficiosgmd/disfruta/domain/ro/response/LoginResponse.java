package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.UserBean;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by avermes on 8/2/2017.
 */
public class LoginResponse extends BaseResponse {

    UserBean result;

    public UserBean getResult() {
        return result;
    }

    public void setResult(UserBean result) {
        this.result = result;
    }

}
