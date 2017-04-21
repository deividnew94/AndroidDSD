package com.gmdinnovacion.beneficiosgmd.disfruta.services.dao;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.koushikdutta.ion.builder.Builders;

/**
 * Created by avermes on 8/2/2017.
 */

public interface UserDAO {

    public long insert(User model);

    public User getCurrentUser();

    public void logout();

}
