package com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl;

import android.content.Context;
import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleProveedor;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Empresa;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.LoginResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.EmpresaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.EmpresaDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.EmpresaDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AndroidApplication;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.LogUtil;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.EmpresaRequest;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.EmpresaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by innovagmd on 26/12/16.
 */

public class EmpresaImpl implements EmpresaService {

    EmpresaDAO empresaDao = new EmpresaDAOImpl();

    public void cargarEmpresas(final Context ctx) {

        Log.i("empresa",Constante.SERVICIO.BASE_URL+"/"+Constante.SERVICIO.EMPRESA_URL);
        Call<EmpresaResponse> call = AndroidApplication.getInstance().getService().getEmpresas();

        call.enqueue(new Callback<EmpresaResponse>() {
            @Override
            public void onResponse(Call<EmpresaResponse> call, Response<EmpresaResponse> response) {
                LogUtil.i(response.toString());
                if(response.code()==200){
                    if (response.body().getSuccess()){
                        List<Empresa> data = response.body().getResult();
                        // EmpresaResponse empresaOut = new EmpresaResponse();
                        // empresaOut.setData(data);
                        EmpresaDAO empresaDAOImpl=new EmpresaDAOImpl();
                        empresaDAOImpl.limpiarEmpresas();
                        for (Empresa mEmpresa : data) {
                            empresaDAOImpl.insert(mEmpresa);
                        }

                    }
//                    else {
//                        EventBus.getDefault().post(response.body().getMessage());
//                    }

                }

            }

            @Override
            public void onFailure(Call<EmpresaResponse> call, Throwable t) {
                LogUtil.e("Error de serv. Empresas");
             //   EmpresaResponse empresaResponse = new EmpresaResponse();
                EventBus.getDefault().post("Error de red.");
            }
        });

    }


    /*
    new Callback<EmpresaResponse() {
            @Override
            public void onResponse(Call<EmpresaResponse> call, Response<EmpresaResponse> response) {

                if(response.isSuccessful()) {
                    EmpresaDAOImpl empresaDAOImpl = new EmpresaDAOImpl();
                    empresaDAOImpl.limpiarEmpresas();
                    List<Empresa> data = response..body();
                   // EmpresaResponse empresaOut = new EmpresaResponse();
                   // empresaOut.setData(data);

                    for (Empresa mEmpresa : data) {

                        empresaDAOImpl.insert(mEmpresa);
                    }

                    List<Empresa> lista = empresaDAOImpl.getAllEmpresasName();
                    LogUtil.i("lista>>>>>>>>>" + lista.size());
                    // EventBus.getDefault().post(empresaOut);

                } else {

                }




            }
            @Override
            public void onFailure(Call<EmpresaResponse> call, Throwable t) {

            }
        }
     */
}