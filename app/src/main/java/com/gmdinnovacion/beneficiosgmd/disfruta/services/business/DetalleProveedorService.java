package com.gmdinnovacion.beneficiosgmd.disfruta.services.business;

import android.content.Context;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleProveedor;

/**
 * Created by avermes on 8/2/2017.
 */
public interface DetalleProveedorService {

    public void getDetalleProveedor(final Context context, int idBeneficio, int idLocal);

    public DetalleProveedor getCurrentDetalleProveedor();

}
