package com.gmdinnovacion.beneficiosgmd.disfruta.services.business;

import android.content.Context;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;

/**
 * Created by avermes on 8/2/2017.
 */
public interface UserService {

    public void login(final Context context,int empresa, String username, String password);

    public User getCurrentUser();

    public void logout();
}
