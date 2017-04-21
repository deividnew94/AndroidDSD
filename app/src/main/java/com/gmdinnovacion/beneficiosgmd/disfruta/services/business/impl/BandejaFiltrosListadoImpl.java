package com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl;

import android.content.Context;
import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.FiltroListaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaFiltrosListadoService;
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

public class BandejaFiltrosListadoImpl implements BandejaFiltrosListadoService {
    @Override
    public void CargarFiltrosLista(Context context) {
        Log.i("BandejaFiltros", Constante.SERVICIO.BASE_URL+"/"+Constante.SERVICIO.FILTROS_URL);
        Call<FiltroListaResponse> call;
        try {
            call = AndroidApplication.getInstance().getService().getFiltrosLista();

            call.enqueue(new Callback<FiltroListaResponse>() {
                @Override

                public void onResponse(Call<FiltroListaResponse> call, Response<FiltroListaResponse> response) {
                    if(response.code()==200) {
                        LogUtil.i("ok", response.toString());
                        FiltroListaResponse filtroResponse = response.body();
                        if (response.body().getSuccess()) {
                            EventBus.getDefault().post(filtroResponse.getResult());
                        } else {
                            EventBus.getDefault().post(filtroResponse.getMessage());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FiltroListaResponse> call, Throwable t) {
                    LogUtil.e("error", t.toString());
                    FiltroListaResponse filtroResponse=new FiltroListaResponse();

                    EventBus.getDefault().post(filtroResponse.getMessage());
                }
            });
        }catch (Exception e){
            Log.i("FiltroBeneficio", e.getMessage());
        }
    }
}
