package com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl;

import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Empresa;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.EmpresaDAO;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by avermes on 3/2/2017.
 */

public class EmpresaDAOImpl implements EmpresaDAO {


    @Override
    public long insert(Empresa model) {
        long id = 0;
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();

            Empresa empresa = realm.createObject(Empresa.class);
            empresa.setIdEmpresa(model.getIdEmpresa());
            empresa.setNomEmpresa(model.getNomEmpresa());
            empresa.setDesEmpresa(model.getDesEmpresa());
            empresa.setUrlLogo(model.getUrlLogo());
            empresa.setNumSoporte(model.getNumSoporte());
            empresa.setNomSkype(model.getNomSkype());
            empresa.setInClave(model.getInClave());
            id = 1;

            realm.commitTransaction();

        } catch (Exception e){
            e.printStackTrace();
            realm.commitTransaction();
        }
        return  id;
    }

    @Override
    public Empresa getCurrentEmpresa() {

        Empresa empresa = null;
        Realm realm = Realm.getDefaultInstance();

        try {
            empresa = realm.where(Empresa.class).findFirst();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return empresa;
    }

    @Override
    public void limpiarEmpresas() {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.beginTransaction();
            realm.delete(Empresa.class);
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            realm.commitTransaction();
        }
    }


    @Override
    public List<Empresa> getAllEmpresasName(){
       // ArrayList<Empresa> empresas =new ArrayList<Empresa>();
        // que te devuelva los nombres

        Realm realm = Realm.getDefaultInstance();
        ArrayList<Empresa> list = new ArrayList(realm.where(Empresa.class).findAll());

        for(Empresa c: list) {
            Log.d("results1", c.getNomEmpresa());
        }
        return  list;
    }
}
