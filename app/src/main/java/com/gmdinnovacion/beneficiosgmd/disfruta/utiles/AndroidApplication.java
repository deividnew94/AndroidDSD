package com.gmdinnovacion.beneficiosgmd.disfruta.utiles;

import android.Manifest;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.SyncStateContract;
import android.support.multidex.MultiDex;
import android.support.v4.app.ActivityCompat;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.BeneficioLista;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.RetrofitService;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.LoginResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jmauriciog on 01/06/16.
 * Clase principal de la app
 */
public class AndroidApplication extends Application {

    private static AndroidApplication sApplication;
    private Retrofit retrofit;

    private int notificationsCount = 0;
    private ArrayList<String> notificationList = new ArrayList<>();
    private NotificationManager notificationManager;

    private static List<LoginResponse> loginResponses = new ArrayList<>();
    private static List<BeneficioLista> beneficioLista = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        sApplication = this;
        //ViewTarget.setTagId(R.id.glide_tag);
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

    }


    public static AndroidApplication getInstance() {
        return sApplication;
    }

    /** Retrofit Global methods **/
    public RetrofitService getService(){
        if(retrofit == null){
            Gson gson = new GsonBuilder()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constante.SERVICIO.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(getRequestHeader())
                    .build();
        }

        return retrofit.create(RetrofitService.class);

    }


    public  List<BeneficioLista> getBeneficioLista(){
        return beneficioLista;
    }

    public void setBeneficioLista(List<BeneficioLista> beneficioLista) {
        this.beneficioLista = beneficioLista;
    }

    public void clearBeneficioLista(){
        beneficioLista.clear();
    }


    private OkHttpClient getRequestHeader() {
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.newBuilder().readTimeout(Constante.APP_TIMEOUT, TimeUnit.SECONDS);
        httpClient.newBuilder().connectTimeout(Constante.APP_TIMEOUT, TimeUnit.SECONDS);
        return httpClient;
    }
    /** Retrofit Global methods **/


    /** GCM Global Methods **/
    public int incrementAndGetNotificationCount(){
        notificationsCount++;
        return notificationsCount;
    }

    public ArrayList<String> getNotificationList() {
        return notificationList;
    }

    public void clearNotifications(){
        notificationsCount = 0;
        getNotificationManager().cancelAll();
        notificationList.clear();
    }

    public NotificationManager getNotificationManager() {
        if(notificationManager == null)
            notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        return notificationManager;
    }



    /** GCM Global Methods **/

}
