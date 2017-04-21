package com.gmdinnovacion.beneficiosgmd.disfruta.services.dao;


import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.FcmToken;

/**
 * Created by jmauriciog on 02/06/2016.
 */
public interface FcmTokenDAO {

    public FcmToken getDevice();

    public void updateTokenToExpired();

    public long insert(FcmToken model);


}
