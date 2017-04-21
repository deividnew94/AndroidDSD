package com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl;

import android.content.Context;
import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.ActualizarFavoritoRequest;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.ValidarBeneficioFavoritoResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.ValidarBeneficioFavoritoService;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AndroidApplication;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.LogUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okio.Buffer;
import okio.BufferedSink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by avermes on 17/2/2017.
 */

public class ValidarBeneficioFavoritoImpl implements ValidarBeneficioFavoritoService{


    @Override
    public void BeneficioFavoritoActualizar(Context context, Integer idBeneficio, Integer idBeneficiario , Integer idFavorito, Integer inEstado ) {

        final ActualizarFavoritoRequest actualizarFavorito = new ActualizarFavoritoRequest(idBeneficio, idBeneficiario, idFavorito, inEstado );

        Log.i("FavoritoActualizar", Constante.SERVICIO.BENEFICIOS_FAVORITOS_URL);
        Call<ValidarBeneficioFavoritoResponse> call = AndroidApplication.getInstance().getService().actualizarFavoritos(actualizarFavorito);
        Log.i("FavoritoActualizar",call.request().url().toString());
        call.enqueue(new Callback<ValidarBeneficioFavoritoResponse>() {
            @Override
            public void onResponse(Call<ValidarBeneficioFavoritoResponse> call, Response<ValidarBeneficioFavoritoResponse> response) {
                LogUtil.i(response.toString());
                if (response.code() == 200){
                    if (response.body().getSuccess()){

//
                    }
                }
            }

            @Override
            public void onFailure(Call<ValidarBeneficioFavoritoResponse> call, Throwable t) {

                LogUtil.e("error", t.toString());

                EventBus.getDefault().post("Error Servicio");
            }
        });

    }


}
