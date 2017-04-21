package com.gmdinnovacion.beneficiosgmd.disfruta.utiles;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

/**
 * Created by atataje on 13/06/2016.
 */
public class PermisionChecker {

    public static boolean isGpsEnable(Activity activity){
        boolean result = true;
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            result = false;
        }
        return result;
    }

    public static boolean isCameraEnable(Context ctx){
        boolean result = true;

        if (ContextCompat.checkSelfPermission(ctx,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            result = false;
        }
        return result;
    }

    public static boolean isCallPhoneAvaliable(Context ctx){
        boolean result = true;

        if (ContextCompat.checkSelfPermission(ctx,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
            result = false;
        }
        return  result;
    }

    public static boolean isRaedStorageExternalEnable(Context ctx){
        boolean result = true;
        if (ContextCompat.checkSelfPermission(ctx,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            result = false;
        }
        return result;
    }

    public  static boolean isWriteStorageExternalEnable(Context ctx){
        boolean result = true;
        if(ContextCompat.checkSelfPermission(ctx,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                !=PackageManager.PERMISSION_GRANTED){
            result =false;
        }
        return  result;
    }

    public  static boolean isFineLocationAvaliable(Context ctx){
        boolean result = true;
        if(ContextCompat.checkSelfPermission(ctx,
                Manifest.permission.ACCESS_FINE_LOCATION)
                !=PackageManager.PERMISSION_GRANTED){
            result=false;
        }
        return  result;
    }
}
