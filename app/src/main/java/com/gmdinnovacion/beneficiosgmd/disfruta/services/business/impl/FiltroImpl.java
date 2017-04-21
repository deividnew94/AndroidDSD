package com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl;

import android.content.Context;
import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.FiltroResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.FiltroService;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AndroidApplication;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.LogUtil;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by avermes on 13/2/2017.
 */

public class FiltroImpl implements FiltroService {

    @Override
    public void getFiltros(Context context) {
        Log.i("BandejaFiltros", Constante.SERVICIO.BASE_URL+"/"+Constante.SERVICIO.FILTROS_URL);
        Call<FiltroResponse> call;
        try {
            call = AndroidApplication.getInstance().getService().getFiltro();

            call.enqueue(new Callback<FiltroResponse>() {
                @Override

                public void onResponse(Call<FiltroResponse> call, Response<FiltroResponse> response) {
                    if(response.code()==200) {
                        LogUtil.i("ok", response.toString());
                        FiltroResponse filtroResponse = response.body();
                        if (response.body().getSuccess()) {
                            EventBus.getDefault().post(filtroResponse.getResult());
                        } else {
                            EventBus.getDefault().post(filtroResponse.getMessage());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FiltroResponse> call, Throwable t) {
                    LogUtil.e("error", t.toString());
                    FiltroResponse filtroResponse=new FiltroResponse();

                    EventBus.getDefault().post(filtroResponse.getMessage());
                }
            });
        }catch (Exception e){
            Log.i("FiltroBeneficio", e.getMessage());
        }
    }
}
