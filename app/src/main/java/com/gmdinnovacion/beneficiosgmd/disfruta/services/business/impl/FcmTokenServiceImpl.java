package com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl;

import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.FcmToken;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.TokenRequest;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.TokenResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.FcmTokenService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.FcmTokenDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.FcmTokenDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AndroidApplication;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by jmauriciog on 02/06/2016.
 */
public class FcmTokenServiceImpl implements FcmTokenService {

    private FcmTokenDAO deviceDAO = new FcmTokenDAOImpl();
    //private UserService userService = new UserServiceImpl();

    @Override
    public long setDevice(FcmToken device) {
        return deviceDAO.insert(device);
    }

    @Override
    public FcmToken getDevice() {
        return deviceDAO.getDevice();
    }

    public void updateTokenToExpired(){
        deviceDAO.updateTokenToExpired();
    }

    @Override
    public void sendRegistrationToServer(final String token, String userId) {
        TokenRequest tokenRequest = new TokenRequest(userId,"Android",token);
        Call<TokenResponse> call = AndroidApplication.getInstance().getService().updateToken(tokenRequest);
        call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, retrofit2.Response<TokenResponse> response) {
                if(response.isSuccessful()){
                    setDevice(new FcmToken(token, 1));
                    Log.d("tokenResponse", "tokenResponse" + response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });
    }


}
