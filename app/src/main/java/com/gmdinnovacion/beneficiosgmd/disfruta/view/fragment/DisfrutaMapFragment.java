package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.BeneficioLista;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleDescuentoRepositorio;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Point;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.repository.ElementosPruebaRepositorio;
import com.gmdinnovacion.beneficiosgmd.disfruta.repository.pointTrRepositorio;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.BandejaBeneficioListaImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.UserDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AndroidApplication;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.DetalleProveedorActivity;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante.PERMISSIONS.ACCESS_FINE_LOCATION;


public class DisfrutaMapFragment extends Fragment  implements OnMapReadyCallback {


    Marker myMaker;
    GoogleMap map;
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.mapViewDisfruta)
    MapView mapa;

    @BindView(R.id.lineInfoProveedor)
    LinearLayout lineInfoProveedor;

    @BindView(R.id.lineNavegarCon)
    LinearLayout lineNavegarCon;

    @BindView(R.id.nombreRestaurante)
    TextView nombreRestaurante;

    @BindView(R.id.position)
    TextView position;

    @BindView(R.id.categoria)
    TextView categoria;

    @BindView(R.id.txtAbierto)
    TextView txtAbierto;

    @BindView(R.id.txtDistancia)
    TextView txtDistancia;

    @BindView(R.id.photoRestaurante)
    ImageView photoRestaurante;

    @BindView(R.id.lstTargetProveedor)
    LinearLayout lstTargetProveedor;

    @BindView(R.id.txtIdProv)
    TextView txtTagProveedor;

    @BindView(R.id.btnComoLlegar)
    Button btnComoLlegar;

    List<Point> listaPuntos;
    String tipo;
    Context context;

    double lat = 0.0;
    double lng = 0.0;

    UserDAO userDAO = new UserDAOImpl();
    User a = userDAO.getCurrentUser();

    private BottomSheetBehavior mBottomSheetBehavior1;
    public static DisfrutaMapFragment newInstance(String tipo) {
        DisfrutaMapFragment fragment = new DisfrutaMapFragment();
        Bundle args = new Bundle();
        //args.putString("tipo", tipo);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_disfruta_map, container, false);
        //return inflater.inflate(R.layout.fragment_disfruta_map, container, false);
        context = getActivity();
        ButterKnife.bind(this, v);

//        SegmentedGroup segmented3 = (SegmentedGroup) rootView.findViewById(R.id.segmentedMap);
//        segmented3.setTintColor(Color.parseColor("#FFD0FF3C"), Color.parseColor("#FF7B07B2"));

        mapa.onCreate(savedInstanceState);
        mapa.getMapAsync(this);

        lineInfoProveedor.setVisibility(View.GONE);
        lineNavegarCon.setVisibility(View.GONE);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        //p = point.get(point.size() - 1);
        mapa.onResume();

        lstTargetProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objInt = new Intent(getContext(), DetalleProveedorActivity.class);
                Bundle objBdl = new Bundle();
                objBdl.putInt("idProveedor", Integer.parseInt(txtTagProveedor.getText().toString()));
                objInt.putExtras(objBdl);
                startActivity(objInt);
            }
        });

        btnComoLlegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lineInfoProveedor.setVisibility(View.GONE);
                lineNavegarCon.setVisibility(View.VISIBLE);
            }
        });
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.mapDisfruta);
//        mapFragment.getMapAsync(this);
        //tipo = getArguments().getString("tipoUsuario");
    }

    private void hideSwipeRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //ButterKnife.unbind(this);
    }


    @Override
    public void onPause() {
        super.onPause();
        mapa.onPause();
        //   apiClient.stopAutoManage(getActivity());
        //  apiClient.disconnect();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mapa.onDestroy();
        //  apiClient.stopAutoManage(getActivity());
        //  apiClient.disconnect();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapa.onLowMemory();
    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {
        map = googleMap;
         tenerUbicacion();

        LatLng punto;
        try {
            punto = new LatLng(lat,lng);
        } catch (Exception e) {
            punto = new LatLng(-12.0523638, -77.0409382);
        }
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(punto)
                .zoom(Constante.ZOOM_MAPA_DEFAULT)
                .build();
//        map.animateCamera(CameraUpdateFactory.zoomIn());
//        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1000, null);
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

//        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,15000,0,locListener);
        //moverUbicacionActual();
        pintarPosicionGPS(0);

    }

    private void tenerUbicacion() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(false);
            LocationManager locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            BandejaBeneficioListaImpl bandejaLatLng = new BandejaBeneficioListaImpl();
//            bandejaLatLng.CargarBeneficioLista(context, location.getLatitude(), location.getLongitude());

            if(location!=null) {
                //bandejaLatLng.CargarBeneficioLista(context, a.getIdUsuario(), location.getLatitude(), location.getLongitude(),null,null,null,null,null,false);

                latitud(location);
                longitud(location);
            }
            else {
                //bandejaLatLng.CargarBeneficioLista(context, a.getIdUsuario(),0.0, 0.0,null,null,null,null,null,false);

                latitud(null);
                longitud(null);
                Toast.makeText(getActivity(), "Sin coordenadas Maps", Toast.LENGTH_SHORT).show();

            }

//            latitud(location);
//            longitud(location);

        } else {
            //Request Location Permission
        }
    }

    private Target mTarget = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            myMaker.setIcon(BitmapDescriptorFactory.fromBitmap(bitmap));
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };


    private void pintarPosicionGPS(int tag) {
        map.clear();
        LatLng punto;
        List<BeneficioLista> point = AndroidApplication.getInstance().getBeneficioLista();
        int i;

        try {

            for(i=0 ; i<= point.size() - 1;i++){
                punto = new LatLng(point.get(i).getNumLatitud(), point.get(i).getNumLongitud());
                int j;



                if(tag == point.get(i).getIdBeneficio()){


                    myMaker = map.addMarker(new MarkerOptions()
                            .position(punto));
                    Picasso.with(getContext()).load(point.get(i).getIconSEje()).resize(120, 120).into(mTarget);
                    myMaker.setTag(point.get(i).getIdBeneficio());
                    for(j=0; j < point.size();j++){
                        if(point.get(i).getIdBeneficio() == tag){

                            String idBeneficio = String.valueOf(tag);

                            Picasso.with(getContext()).load(point.get(i).getImgBeneficio()).into(photoRestaurante);
                            nombreRestaurante.setText(point.get(i).getNomBeneficio().toString());
                            categoria.setText(point.get(i).getNomEje().toString());
                            position.setText(point.get(i).getNomDistrito().toString());
                            txtAbierto.setText(getInAbierto(point.get(i).getInAbierto().toString()));
                            txtTagProveedor.setText(idBeneficio);
                            txtDistancia.setText("a " + point.get(i).getNumDistancia().toString()+ " km ");

                            //btnComoLlegar
                        }
                    }
                }else{
                    myMaker = map.addMarker(new MarkerOptions()
                            .position(punto));
                    Picasso.with(getContext()).load(point.get(i).getIconEje()).resize(120, 120).into(mTarget);
                    myMaker.setTag(point.get(i).getIdBeneficio());
                }

                /////////////////////////////////////////////////////////////////////////

            }
        } catch (Exception e) {
            punto = new LatLng(-12.0523638, -77.0409382);
        }

//        myMaker = map.addMarker(new MarkerOptions()
//                .position(punto));
        // .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this.getContext(),marker))));

        myMaker.showInfoWindow();
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String longi = String.valueOf(marker.getPosition().longitude);
                String lati = String.valueOf(marker.getPosition().latitude);
//                map.clear();
//                pintarPosicionGPS();
//                marker.setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante_red));
                //map.clear();
                pintarPosicionGPS((Integer) marker.getTag());
                lineInfoProveedor.setVisibility(View.VISIBLE);
                //Snackbar.make(getView(), marker.getTag().toString() ,Snackbar.LENGTH_LONG).show();
                return false;
            }
        });
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                lineInfoProveedor.setVisibility(View.GONE);
                lineNavegarCon.setVisibility(View.GONE);
                map.clear();
                pintarPosicionGPS(0);
            }
        });

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //map.setInfoWindowAdapter(new InfoWindowClick(li, listaPuntos, this.getActivity()));

        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                marker.getId();
            }
        });
    }

    public Double latitud (Location location) {
        if (location != null) {
            lat = location.getLatitude();
        }
        return lat;
    }
    public Double longitud (Location location) {
        if (location != null) {
            lng = location.getLongitude();
        }
        return lng;
    }

    @OnClick(R.id.ubicacion)
    public void onClick() {
        tenerUbicacion();
        List<Point> point = pointTrRepositorio.getAllPoints(this.getContext());
        Point p;
        LatLng punto;

        try {
//            p = point.get(point.size() - 1);
//            punto = new LatLng(Double.parseDouble(p.getLatitud()), Double.parseDouble(p.getLongitud()));
            punto = new LatLng(lat,lng);
        } catch (Exception e) {
            punto = new LatLng(-12.0523638, -77.0409382);
        }
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(punto)
                .zoom(Constante.ZOOM_MAPA_DEFAULT)
                .build();
        map.animateCamera(CameraUpdateFactory.zoomIn());
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1000, null);

    }

    private class updateView extends AsyncTask<String, Integer, Boolean> {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override
        protected Boolean doInBackground(String... strings) {

            return true;
        }
    }

    public void animateMarker(final Marker marker, final LatLng toPosition,
                              final boolean hideMarker) {
        final Handler handler = new Handler();
        final long start = SystemClock.uptimeMillis();
        Projection proj = map.getProjection();
        android.graphics.Point startPoint = proj.toScreenLocation(marker.getPosition());
        final LatLng startLatLng = proj.fromScreenLocation(startPoint);
        final long duration = 500;

        final Interpolator interpolator = new LinearInterpolator();

        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                float t = interpolator.getInterpolation((float) elapsed
                        / duration);
                double lng = t * toPosition.longitude + (1 - t)
                        * startLatLng.longitude;
                double lat = t * toPosition.latitude + (1 - t)
                        * startLatLng.latitude;
                marker.setPosition(new LatLng(lat, lng));

                if (t < 1.0) {
                    // Post again 16ms later.
                    handler.postDelayed(this, 16);
                } else {
                    if (hideMarker) {
                        marker.setVisible(false);
                    } else {
                        marker.setVisible(true);
                    }
                }
            }
        });
    }

    public String getInAbierto(String inAbierto) {

        if(inAbierto.toString().equals("S")){
            return"ABIERTO";
        }
        else{
            return"CERRADO";
        }
    }

//    private void moverUbicacionActual() {
//        List<Point> point = pointTrRepositorio.getAllPoints(this.getContext());
//        Point p;
//        LatLng punto;
//
//        try {
//            p = point.get(point.size() - 1);
//            punto = new LatLng(Double.parseDouble(p.getLatitud()), Double.parseDouble(p.getLongitud()));
//        } catch (Exception e) {
//            punto = new LatLng(-12.0523638, -77.0409382);
//        }
//        CameraPosition cameraPosition = new CameraPosition.Builder()
//                .target(punto)
//                .zoom(Constante.ZOOM_MAPA_DEFAULT)
//                .build();
//        map.animateCamera(CameraUpdateFactory.zoomIn());
//        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 200, null);
//
//        pintarPosicionGPS(0);
//    }
}
