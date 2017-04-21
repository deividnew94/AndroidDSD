package com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl;

import android.content.Context;
import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.BeneficioLista;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.BeneficioListaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.UserService;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AndroidApplication;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.LogUtil;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.DisfrutaMapFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by avermes on 13/2/2017.
 */

public class BandejaBeneficioListaImpl implements BandejaBeneficioListaService {

    @Override
    public void CargarBeneficioLista(Context context, Integer idBeneficiario, Double latitud, Double longitud, Integer idEje, Integer porcDescuento, Integer numDistancia, String puntBeneficio, Integer numPagina, final boolean llamadaDesde) {

        UserService userService=new UserServiceImpl();
        User usuario = userService.getCurrentUser();

        Call<BeneficioListaResponse> call;
        Log.i("BandejaBeneficio", Constante.SERVICIO.BASE_URL+"/"+Constante.SERVICIO.BENEFICIOS_URL);

        if(latitud != 0.0 && longitud!= 0.0) {
            call = AndroidApplication.getInstance().getService().getBeneficiosLista(usuario.getIdUsuario(), latitud, longitud, idEje, porcDescuento, numDistancia, puntBeneficio, numPagina);
            //call = AndroidApplication.getInstance().getService().getBeneficiosLista(1, latitud, longitud, idEje, porcDescuento, numDistancia, puntBeneficio);
        }else {
            call = AndroidApplication.getInstance().getService().getBeneficiosLista(usuario.getIdUsuario(), -12.222220, -77.252525, idEje, porcDescuento, numDistancia, puntBeneficio, numPagina);
            //call = AndroidApplication.getInstance().getService().getBeneficiosLista(1, -12.222220, -77.252525, idEje, 0, numDistancia, puntBeneficio);
        }
        Log.i("CargarBeneficioLista",call.request().url().toString());

        Log.i("lat long",String.valueOf(latitud + "    lng: " + longitud));
        call.enqueue(new Callback<BeneficioListaResponse>() {
            @Override
            public void onResponse(Call<BeneficioListaResponse> call, Response<BeneficioListaResponse> response) {

                LogUtil.i(response.toString());
                if (response.code() == 200){
                    if (response.body().getSuccess()){
                        List<BeneficioLista> beneficioListas= response.body().getResult();

                        AndroidApplication.getInstance().setBeneficioLista(beneficioListas);
                        if(llamadaDesde)
                        EventBus.getDefault().post(response.body());
                    }
                }

            }

            @Override
            public void onFailure(Call<BeneficioListaResponse> call, Throwable t) {
                LogUtil.e("error", t.toString());
                BeneficioListaResponse beneficioListaResponse = new BeneficioListaResponse();
                EventBus.getDefault().post(beneficioListaResponse.getMessage());
            }
        });
    }
}
