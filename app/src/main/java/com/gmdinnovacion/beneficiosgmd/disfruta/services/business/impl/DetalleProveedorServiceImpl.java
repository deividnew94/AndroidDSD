package com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl;

import android.content.Context;
import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleProveedor;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.DetalleProveedorResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.DetalleProveedorService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.DetalleProveedorDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.DetalleProveedorDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AndroidApplication;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.LogUtil;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by avermes on 8/2/2017.
 */

public class DetalleProveedorServiceImpl implements DetalleProveedorService {

    DetalleProveedorDAO detalleProveedorDao = new DetalleProveedorDAOImpl();

    @Override
    public void getDetalleProveedor(final Context context,int idBeneficio, int idLocal) {

        Call<DetalleProveedorResponse> call = AndroidApplication.getInstance().getService().getDetalle(String.valueOf(idBeneficio),"local",String.valueOf(idLocal));
        Log.d("URL",call.request().url().toString());
        call.enqueue(new Callback<DetalleProveedorResponse>() {
            @Override
            public void onResponse(Call<DetalleProveedorResponse> call, Response<DetalleProveedorResponse> response) {
                if (response.code() == 200) {
                    LogUtil.i("ok", response.toString());
                    DetalleProveedorResponse detalleProveedorResponse = response.body();
                    if (response.body().getSuccess()) {
                        EventBus.getDefault().post(detalleProveedorResponse.getResult());
                    } else {
                        EventBus.getDefault().post(detalleProveedorResponse.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<DetalleProveedorResponse> call, Throwable t) {
                LogUtil.e("error", t.toString());
                DetalleProveedorResponse detalleProveedorResponse=new DetalleProveedorResponse();
                EventBus.getDefault().post(detalleProveedorResponse.getMessage());
            }
        });

    }


    @Override
    public DetalleProveedor getCurrentDetalleProveedor() {

        return detalleProveedorDao.getCurrentDetalleProveedor();
    }
}
