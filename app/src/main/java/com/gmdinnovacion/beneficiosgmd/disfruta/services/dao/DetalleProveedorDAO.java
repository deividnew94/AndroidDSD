package com.gmdinnovacion.beneficiosgmd.disfruta.services.dao;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleProveedor;

/**
 * Created by avermes on 8/2/2017.
 */

public interface DetalleProveedorDAO {

    public long insert(DetalleProveedor model);

    public DetalleProveedor getCurrentDetalleProveedor();

}
