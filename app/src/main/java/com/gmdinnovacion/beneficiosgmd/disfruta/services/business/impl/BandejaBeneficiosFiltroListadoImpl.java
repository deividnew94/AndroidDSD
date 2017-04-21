package com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl;

import android.content.Context;
import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.BeneficioListaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioFiltroListaService;
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

public class BandejaBeneficiosFiltroListadoImpl implements BandejaBeneficioFiltroListaService {

    @Override
    public void CargarBerneficiosLista(Context context, Integer idBeneficiario, String numLatitud, String numLongitud, Integer idEje, Integer porcDescuento, Integer numDistancia, String puntBeneficio) {
        Call<BeneficioListaResponse> call;
        try {
            call = AndroidApplication.getInstance().getService().getBeneficiosFiltroLista(idBeneficiario,numLatitud,numLongitud,idEje,porcDescuento,numDistancia,puntBeneficio);

            Log.d("URL",call.request().url().toString());
            call.enqueue(new Callback<BeneficioListaResponse>() {
                @Override

                public void onResponse(Call<BeneficioListaResponse> call, Response<BeneficioListaResponse> response) {
                    if (response.code() == 200){
                        BeneficioListaResponse beneficioListaResponse = response.body();
                        if (response.body().getSuccess()){
                            EventBus.getDefault().post(beneficioListaResponse);
                        }else {
                            EventBus.getDefault().post(beneficioListaResponse);
                        }
                    }
                }

                @Override
                public void onFailure(Call<BeneficioListaResponse> call, Throwable t) {
                    LogUtil.e("error", t.toString());
                    BeneficioListaResponse beneficiosResponse=new BeneficioListaResponse();

                    EventBus.getDefault().post(beneficiosResponse.getMessage());
                }
            });
        }catch (Exception e){
            Log.i("BandejaBeneficio", e.getMessage());
        }
    }
}
