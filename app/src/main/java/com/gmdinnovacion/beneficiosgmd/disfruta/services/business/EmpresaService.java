package com.gmdinnovacion.beneficiosgmd.disfruta.services.business;

import android.content.Context;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Empresa;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.EmpresaRequest;

/**
 * Created by avermes on 1/2/2017.
 */

public interface EmpresaService {

    public void cargarEmpresas(final Context ctx);

}
