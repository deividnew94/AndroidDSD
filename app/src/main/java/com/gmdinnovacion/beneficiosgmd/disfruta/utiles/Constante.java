package com.gmdinnovacion.beneficiosgmd.disfruta.utiles;

public class Constante {


    public static final int DEFAULT_SOCKET_TIMEOUT =1 ;
    public static final float ZOOM_MAPA_DEFAULT =20 ;
    public static final Object ONBOARDING_VISTO = 1;
    public static int SPLASH_DELAY = 4500;

    public static int APP_TIMEOUT = 5000;
    public static int PLAY_SERVICES_TIMEOUT = 5000;

    public static int ASYNC_REQUEST = 1;
    public static int SYNC_REQUEST = 0;

    public static int SUCCESS_REQUEST = 1;
    public static int ERROR_REQUEST = 0;



    public static class SERVICIO{

        //public static String URL_BASE_CERTIFICACION= "http://http://gisem.osinergmin.gob.pe/servgis/json/";
        //public static String URL_BASE_PRODUCCION= "http://http://gisem.osinergmin.gob.pe/servgis/json/";
        //public static String URL_BASE_USADA=URL_BASE_PRODUCCION;+

        //public static String GET_COORDENADAS_URL = URL_BASE_USADA + "buffer"; // parametros: coor X, coor Y, distancia
        public static final String BASE_URL ="http://10.244.4.20:8080/disfruta-back/api/" ;
        public static final String BASE_URL_DETALLE ="http://10.244.4.20:8080/disfruta-back/api/beneficio/" ;

        public static final int ConnectTimeout = 20;
        public static final int readTimeout = 20;

        public static final String GET_PARAMETRIC_URL = "parametric";
        public static final String UPDATE_TOKEN_URL = "token";
        public static final String EMPRESA_URL="empresa/";
        public static final String LOGIN_URL = "login/";

        public static final String BENEFICIOS_FAVORITOS_URL = "beneficio/favorito"; //beneficio/
        public static final String FILTROS_URL = "eje/";

        public static final String BENEFICIOS_URL = "beneficio";

    }

    public static class VALUES {
        public static float ZOOM_MAPA_DEFAULT = 14;
        public static double LATITUDE_POSITION_DEFAULT = -12.096701;
        public static double LONGITUDE_POSITION_DEFAULT = -77.058767;
    }


    // deben tener final ya que se ejecutará en runtime
    public static class PERMISSIONS{
        public static final int ACCESS_FINE_LOCATION = 1;
        public static final int MY_PERMISSIONS_CALL_PHONE =144 ;
    }

    public static class PREFERENCES{

    }


}
