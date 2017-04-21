package com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl;

import android.content.Context;
import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.BeneficioListaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.LoginResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioFavoritoListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.UserService;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AndroidApplication;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.LogUtil;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.DisfrutaMapFragment;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by avermes on 13/2/2017.
 */

public class BandejaBeneficiosFavoritoListadoImpl implements BandejaBeneficioFavoritoListaService {
    @Override
    public void CargarBerneficiosLista(Context context,Integer idUsuario, Integer idEje, Integer numPagina) {
        Log.i("BandejaBeneficio", Constante.SERVICIO.BASE_URL+"/"+Constante.SERVICIO.BENEFICIOS_FAVORITOS_URL);
        Call<BeneficioListaResponse> call;
        try {
            call = AndroidApplication.getInstance().getService().getBeneficiosFavoritosLista(idUsuario,idEje,numPagina);
            Log.i("BandejaBeneficio",call.request().url().toString());
            call.enqueue(new Callback<BeneficioListaResponse>() {
                @Override

                public void onResponse(Call<BeneficioListaResponse> call, Response<BeneficioListaResponse> response) {
                    if(response.code()==200) {
                        LogUtil.i("ok", response.toString());
                        BeneficioListaResponse beneficiosResponse = response.body();
                        if (response.body().getSuccess()) {
                            EventBus.getDefault().post(beneficiosResponse.getResult());
                        } else {
                            EventBus.getDefault().post(beneficiosResponse.getMessage());
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
