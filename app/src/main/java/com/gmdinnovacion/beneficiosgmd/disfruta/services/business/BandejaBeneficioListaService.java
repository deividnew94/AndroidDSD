package com.gmdinnovacion.beneficiosgmd.disfruta.services.business;

import android.content.Context;

/**
 * Created by avermes on 13/2/2017.
 */

public interface BandejaBeneficioListaService {

    public void CargarBeneficioLista(final Context context , Integer idBeneficiario, Double latitud , Double longitud, Integer idEje, Integer porcDescuento, Integer numDistancia, String puntBeneficio, Integer numPagina, boolean llamadaDesde);

}
