package com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl;

import android.content.Context;
import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.LoginRequest;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.LoginResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.UserService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.UserDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AndroidApplication;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.LogUtil;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by avermes on 8/2/2017.
 */

public class UserServiceImpl implements UserService {

    UserDAO userDao = new UserDAOImpl();

    @Override
    public void login(final Context context,int empresa_id, String username, String password) {

        final LoginRequest loginRequest = new LoginRequest(empresa_id ,username, password);
        Log.d("UserLogin", Constante.SERVICIO.LOGIN_URL);
        LogUtil.i(loginRequest.toString());
        Call<LoginResponse> call = AndroidApplication.getInstance().getService().login(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.code()==200) {
                    LogUtil.i("ok", response.toString());
                    LoginResponse loginResponse = response.body();
                    if (response.body().getSuccess()) {
                        EventBus.getDefault().post(loginResponse.getResult());
                    } else {
                        EventBus.getDefault().post(loginResponse.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                LogUtil.e("error", t.toString());
              //  LoginResponse loginResponse=new LoginResponse();
                EventBus.getDefault().post("");
            }
        });

    }


    @Override
    public User getCurrentUser() {
        try {
            return userDao.getCurrentUser();
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public void logout() {

        userDao.logout();

    }
}
