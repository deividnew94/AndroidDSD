package com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.ActualizarFavoritoRequest;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.LoginRequest;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.ParametricRequest;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.TokenRequest;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.BeneficioListaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.DetalleProveedorResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.EmpresaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.FiltroListaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.FiltroResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.LoginResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.ParametricResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.TokenResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.ValidarBeneficioFavoritoResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by avermes on 23/01/2017.
 */

public interface RetrofitService {
    @GET(Constante.SERVICIO.EMPRESA_URL)
    Call<EmpresaResponse> getEmpresas();

    @POST(Constante.SERVICIO.LOGIN_URL)
    Call<LoginResponse> login(@Body LoginRequest request);

    //BASE_URL ="http://10.244.4.20:8080/disfruta-back/api/" ;

    @GET(Constante.SERVICIO.BASE_URL_DETALLE+"{param1}/{local}/{param2}")
    Call<DetalleProveedorResponse> getDetalle(@Path("param1") String param1,
                                              @Path("local") String local, @Path("param2") String param2);

    @POST(Constante.SERVICIO.GET_PARAMETRIC_URL)
    Call<ParametricResponse> parametric(@Body ParametricRequest request);

    @POST(Constante.SERVICIO.UPDATE_TOKEN_URL)
    Call<TokenResponse> updateToken(@Body TokenRequest request);

    @GET(Constante.SERVICIO.BENEFICIOS_FAVORITOS_URL)
    Call<BeneficioListaResponse> getBeneficiosFavoritosLista(@Query("idBeneficiario") Integer idBeneficiario,@Query("idEje") Integer idEje,@Query("numPagina") Integer numPagina);

    @GET(Constante.SERVICIO.FILTROS_URL)
    Call<FiltroListaResponse> getFiltrosLista();

    @GET(Constante.SERVICIO.BENEFICIOS_URL+"?")
    Call<BeneficioListaResponse> getBeneficiosLista(@Query("idBeneficiario") Integer idUsuario, @Query("numLatitud") Double numLatitud , @Query("numLongitud") Double numLongitud,@Query("idEje") Integer idEje,@Query("porcDescuento") Integer porcDescuento,@Query("numDistancia") Integer numDistancia,@Query("puntBeneficio") String puntBeneficio,@Query("numPagina") Integer numPagina);

    @PUT(Constante.SERVICIO.BENEFICIOS_FAVORITOS_URL)
    Call<ValidarBeneficioFavoritoResponse> actualizarFavoritos(@Body ActualizarFavoritoRequest request);

    @GET(Constante.SERVICIO.FILTROS_URL)
    Call<FiltroResponse> getFiltro();

    @GET(Constante.SERVICIO.BASE_URL_DETALLE)
    Call<BeneficioListaResponse> getBeneficiosFiltroLista(@Query("idBeneficiario") Integer idBeneficiario,@Query("numLatitud") String numLatitud,@Query("numLongitud") String numLongitud,@Query("idEje") Integer idEje,@Query("porcDescuento") Integer porcDescuento,@Query("numDistancia") Integer numDistancia,@Query("puntBeneficio") String puntBeneficio);

}
