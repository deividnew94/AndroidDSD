package com.gmdinnovacion.beneficiosgmd.disfruta.remote;

import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.FcmToken;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.FcmTokenService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.FcmTokenServiceImpl;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;


/**
 * Created by jmauriciog on 15/12/2015.
 */
public class FcmIDListenerService extends FirebaseInstanceIdService {

    private FcmTokenService deviceService = new FcmTokenServiceImpl();
   // private UserService userService = new UserServiceImpl();
//
    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN GCM",refreshedToken);
        deviceService.setDevice(new FcmToken(refreshedToken,0));

        //User user = userService.getCurrentUser();
        //if(user != null){
        //   deviceService.sendRegistrationToServer(refreshedToken,user.getCodigoUsuario());
        //}

    }
}