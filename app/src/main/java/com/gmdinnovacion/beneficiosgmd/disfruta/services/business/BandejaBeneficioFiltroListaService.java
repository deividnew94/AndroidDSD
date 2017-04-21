package com.gmdinnovacion.beneficiosgmd.disfruta.services.business;

import android.content.Context;

/**
 * Created by avermes on 13/2/2017.
 */

public interface BandejaBeneficioFiltroListaService {

    public void CargarBerneficiosLista(final Context context, Integer idBeneficiario, String numLatitud, String numLongitud, Integer idEje, Integer porcDescuento, Integer numDistancia, String puntBeneficio);

}
