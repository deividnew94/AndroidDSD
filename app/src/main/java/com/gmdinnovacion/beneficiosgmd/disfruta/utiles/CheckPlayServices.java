package com.gmdinnovacion.beneficiosgmd.disfruta.utiles;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class CheckPlayServices {

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    /**Verificar google play RestClient*/
    public static boolean checkPlayServices(AppCompatActivity ctx) {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(ctx);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(ctx, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST).show();

            }else {
                Log.i("Error", "This device is not supported.");
                ctx.finish();
            }
            return false;
        }
        return true;
    }
}
