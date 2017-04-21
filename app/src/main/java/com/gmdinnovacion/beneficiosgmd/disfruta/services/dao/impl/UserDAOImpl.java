package com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl;

import android.util.Log;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Empresa;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.EmpresaBean;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;

import io.realm.Realm;

/**
 * Created by avermes on 8/2/2017.
 */

public class UserDAOImpl implements UserDAO {
    @Override
    public long insert(User model) {
        long id = 0 ;
        Realm realm = Realm.getDefaultInstance();
        try{
            realm.beginTransaction();

            realm.delete(User.class);
            User user = realm.createObject(User.class);
            user.setIdUsuario(model.getIdUsuario());
            user.setLogiUsuario(model.getLogiUsuario());
            user.setNomUsuario(model.getNomUsuario());
            user.setApeUsuario(model.getApeUsuario());
            user.setNumDni(model.getNumDni());
            user.setNumCelular(model.getNumCelular());
            user.setImgUsuario(model.getImgUsuario());

          /*  EmpresaBean mEmp = model.getEmpresa();
            user.setEmpresa(mEmp);*/
            id = 1;
            realm.commitTransaction();
            User mUser =  getCurrentUser();
            Log.i("usuario ", mUser.getNomUsuario());

        }catch (Exception e){
            e.printStackTrace();
            realm.cancelTransaction();
        }

        return id;
    }

    @Override
    public User getCurrentUser() {
        User user = null;
        Realm realm = Realm.getDefaultInstance();
        try {
            user = realm.where(User.class).findFirst();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  user;
    }

    @Override
    public void logout() {

        Realm realm = Realm.getDefaultInstance();

        try {
            realm.beginTransaction();
            realm.delete(User.class);
            realm.commitTransaction();
        } catch (Exception e){
            e.printStackTrace();
            realm.cancelTransaction();
        }

    }
}
