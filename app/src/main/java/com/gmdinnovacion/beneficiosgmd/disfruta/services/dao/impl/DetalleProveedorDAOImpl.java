package com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl;

import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleProveedor;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.DetalleProveedorDAO;

import io.realm.Realm;

/**
 * Created by avermes on 8/2/2017.
 */

public class DetalleProveedorDAOImpl implements DetalleProveedorDAO {
    @Override
    public long insert(DetalleProveedor model) {
        long id = 0 ;
        Realm realm = Realm.getDefaultInstance();
        try{
            realm.beginTransaction();

            realm.delete(DetalleProveedor.class);
            DetalleProveedor detProv = realm.createObject(DetalleProveedor.class);
            detProv.setIdProveedor(model.getIdProveedor());
            detProv.setPhotoRestaurante(model.getPhotoRestaurante());
            detProv.setNombreRestaurante(model.getNombreRestaurante());
            detProv.setCategoria(model.getCategoria());
            detProv.setDireccion(model.getDireccion());
            detProv.setDistrito(model.getDistrito());
            detProv.setAppCompatRatingBarDcto(model.getAppCompatRatingBarDcto());
            detProv.setRatingText(model.getRatingText());
            detProv.setTelefonos(model.getTelefonos());
            detProv.setAbierto(model.getAbierto());
            detProv.setUrlWeb(model.getUrlWeb());
            detProv.setLongitud(model.getLongitud());
            detProv.setLatitud(model.getLatitud());
            detProv.setDescripcion(model.getDescripcion());
            detProv.setReservas(model.getReservas());
            detProv.setTarjetasCredito(model.getTarjetasCredito());
            detProv.setWifi(model.getWifi());
            detProv.setEstacionamiento(model.getEstacionamiento());
            detProv.setHoraDscto(model.getHoraDscto());

          /*  EmpresaBean mEmp = model.getEmpresa();
            user.setEmpresa(mEmp);*/
            id = 1;
            realm.commitTransaction();
            DetalleProveedor mDetProv =  getCurrentDetalleProveedor();
            Log.i("IdProveedor ", String.valueOf(mDetProv.getIdProveedor()) );

        }catch (Exception e){
            e.printStackTrace();
            realm.cancelTransaction();
        }

        return id;
    }

    @Override
    public DetalleProveedor getCurrentDetalleProveedor() {
        DetalleProveedor detalleProveedor = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            detalleProveedor = realm.where(DetalleProveedor.class).findFirst();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  detalleProveedor;
    }
}
