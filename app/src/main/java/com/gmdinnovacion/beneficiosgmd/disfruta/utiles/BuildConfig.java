package com.gmdinnovacion.beneficiosgmd.disfruta.utiles;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Slides;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by innovagmd on 25/01/17.
 * Configuracion de la app
 */

public final class BuildConfig {
    public static final String TAG = "Log_glarab";
    public static final boolean LOG = true ;
    public static final int IMG_GIF = R.drawable.splashgym;

    /**
     * CONFIGURAR SLIDE APP (ONBOARDING)
     * @return
     */
    public static List<Slides> GETSLIDE() {
        ArrayList<Slides> items = new ArrayList<>();
        /**
         * Slide(@titulo,@descripcion,@ImagenPagedrawable)
         */
        items.add(new Slides(R.string.title_activity_login,R.string.title_activity_login,R.mipmap.image_slide_1));
        items.add(new Slides(R.string.title_activity_login,R.string.title_activity_login,R.mipmap.image_slide_1));
        items.add(new Slides(R.string.title_activity_login,R.string.title_activity_login,R.mipmap.image_slide_1));

        return items;
    }
}
