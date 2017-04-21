package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleProveedor;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleProveedorBean;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.ImagenBean;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.ServicioBean;
import com.gmdinnovacion.beneficiosgmd.disfruta.repository.ElementosPruebaRepositorio;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.DetalleProveedorService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.DetalleProveedorServiceImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.DetalleProveedorDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.DetalleProveedorDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.LogUtil;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterGalery;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.PermisionChecker;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterServicio;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetalleProveedorActivity extends BaseActivity implements OnMapReadyCallback {

    @BindView(R.id.lista_galeria)
    RecyclerView listaGaleria;

    @BindView(R.id.lista_servicio)
    RecyclerView listaServicio;

    @BindView(R.id.close)
    ImageButton close;

    @BindView(R.id.txtDireccion)
    TextView txtDireccion;

    @BindView(R.id.llamarproveedor)
    ImageView llamarproveedor;

    @BindView(R.id.txtGaleria)
    TextView txtGaleria;

    @BindView(R.id.appCompatRating)
    android.support.v7.widget.AppCompatRatingBar appCompatRatingBar;

    @BindView(R.id.txtRatingText)
    TextView txtRatingText;

    @BindView(R.id.txtTelProveedor)
    TextView txtTelProveedor;

    @BindView(R.id.txtApertura)
    TextView txtApertura;

    @BindView(R.id.txtWeb)
    TextView txtWeb;

    @BindView(R.id.txtDescripcion)
    TextView txtDescripcion;

    @BindView(R.id.imageViewEmpresa)
    ImageView imageViewEmpresa;

    @BindView(R.id.webSide)
    LinearLayout webside;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    AdapterGalery galleryAdapter;
    AdapterServicio servicioAdapter;
    RecyclerView.LayoutManager manager;
    GridLayoutManager lLayout;
    Activity activity;
    Context ctx;
    int categoria = 0;
    int idProveedorSelect;
    double longitud= 0.0;
    double latitud = 0.0;
    String iconMap = "";


    String codigoId;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_proveedor);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.blue_toolbar));
            getWindow().setStatusBarColor(getResources().getColor(R.color.blue_toolbar));
        }

        idProveedorSelect = getIntent().getExtras().getInt("idProveedor");
        Toast.makeText(getApplicationContext(),""+idProveedorSelect,Toast.LENGTH_LONG).show();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ctx = this;
        activity = this;

        //Traer datos para Adapter
        Log.e("xds", "sdsds");
        codigoId = getIntent().getExtras().getString("CodigoIdCodigdoId");
        // Log.e("codigoDetalleContrato",codigoId);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        txtGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callActivity(GaleriaActivity.class.getName());
//                Intent objInt = new Intent(getApplicationContext(),GaleriaActivity.class);
//                startActivity(objInt);
            }
        });


        webside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                    myWebLink.setData(Uri.parse(txtWeb.getText().toString()));
                    startActivity(myWebLink);
                }catch (ActivityNotFoundException e){
                    e.getMessage();
                }catch (Exception e){
                    e.getMessage();
                }
            }
        });

        llamarproveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PermisionChecker.isCallPhoneAvaliable(getApplicationContext())) {
                    Uri numero = Uri.parse("tel:" + txtTelProveedor.getText().toString().trim());
                    Intent intent = new Intent(Intent.ACTION_CALL, numero);
                    try {
                        startActivity(intent);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    ActivityCompat.requestPermissions(activity,
                            new String[]{Manifest.permission.CALL_PHONE},
                            Constante.PERMISSIONS.MY_PERMISSIONS_CALL_PHONE);
                }

            }
        });

        /*
        *INICIO Servicio
        */
        DetalleProveedorService detalleProveedorService = new DetalleProveedorServiceImpl();
        int beneficio       = 0 ;
        int local           = 0 ;

        beneficio           = idProveedorSelect;
        local               = 1;

        detalleProveedorService.getDetalleProveedor(ctx ,beneficio, local);

        /*
        *FIN Servicio
        */

    }



    @Override
    protected void onResume() {
        super.onResume();

        /*
            listResultado.get(0).getIdProveedor();
            setTitle(listResultado.get(0).getNombreRestaurante());
            txtDireccion.setText(listResultado.get(0).getDireccion());
            appCompatRatingBar.setRating(listResultado.get(0).getAppCompatRatingBarDcto());
            txtRatingText.setText(String.valueOf(listResultado.get(0).getRatingText()));
            txtTelProveedor.setText(listResultado.get(0).getTelefonos());
            txtWeb.setText(listResultado.get(0).getUrlWeb());
            txtDescripcion.setText(listResultado.get(0).getDescripcion());
            txtReservaLug.setText(listResultado.get(0).getReservas());
            txtDireccion.setText(listResultado.get(0).getDireccion());
            txtTarjetaCredito.setText(listResultado.get(0).getTarjetasCredito());
            txtWifi.setText(listResultado.get(0).getWifi());
            txtEstacinamiento.setText(listResultado.get(0).getEstacionamiento());

            Picasso.with(getApplicationContext()).load(listResultado.get(0).getPhotoRestaurante()).into(imageViewEmpresa);
            longitud= Double.parseDouble(listResultado.get(0).getLongitud());
            latitud = Double.parseDouble(listResultado.get(0).getLatitud());


        listaGaleria.setHasFixedSize(true);
        manager = new GridLayoutManager(this, 3);

        String categoriaProv="0";
        listaGaleria.setLayoutManager(manager);
        //Llamar a mis elementos d la lista
        ElementosPruebaRepositorio objElemPru = new ElementosPruebaRepositorio();
        List<String> lista = objElemPru.listaGaleria(categoriaProv);

        galleryAdapter = new AdapterGalery(lista, this);
        listaGaleria.setAdapter(galleryAdapter);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        */



        /* categoria*/
/*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle data=new Bundle();
                data.putString("data","data");
                callActivity(PrincipalMapaActivity.class.getName(), data);

//                Intent intent = new Intent(v.getContext(), PrincipalMapaActivity.class);
//                intent.putExtra("data", "data");
//                startActivity(intent);

            }
        });

*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void DetalleCorrecto(DetalleProveedorBean response) {
        LogUtil.i(response.toString());
        //Mostrar datos

        this.setTitle(response.getNomBeneficio());
        appCompatRatingBar.setRating(Float.valueOf(String.valueOf(response.getPuntBeneficio())));
        txtDescripcion.setText(response.getDesBeneficio());
        txtRatingText.setText(String.valueOf(response.getPuntBeneficio()).toString());
        txtTelProveedor.setText(response.getLocal().getNumTelefono().toString());
        txtWeb.setText(response.getUrlProveedor().toString());
        txtDireccion.setText(response.getLocal().getDirLocal().toString());
        txtApertura.setText(getInAbierto(response.getLocal().getInAbierto().toString()));
        Picasso.with(getApplicationContext()).load(response.getFonBeneficio()).into(imageViewEmpresa);
        latitud = Double.parseDouble(response.getLocal().getNumLatitud().toString());
        longitud= Double.parseDouble(response.getLocal().getNumLongitud().toString());
        iconMap = response.getEje().getIconEje().toString();
        categoria = response.getEje().getIdEje();

        //listaGaleria.setHasFixedSize(true);
        manager = new GridLayoutManager(this, 3);
        listaGaleria.setLayoutManager(manager);

        lLayout = new GridLayoutManager(this, 1);
        listaServicio.setLayoutManager(lLayout);


        //Llamar a mis elementos d la lista Galery
        List<ImagenBean> listImagenes = new ArrayList<>();

        int i=0;
        for(ImagenBean lstResultado : response.getImagenes()){
            int id = response.getImagenes().get(i).getIdImagen();
            String url = response.getImagenes().get(i).getUrlImagen();
            String urlPreview = response.getImagenes().get(i).getUrlImagenPrevia();
            if(id!=0 && !url.isEmpty() && !urlPreview.isEmpty()){
                listImagenes.add(new ImagenBean(id,url.toString(),urlPreview.toString())  );
            }
            i++;
        }

        //Llamar a mis elementos d la lista Servicio
        List<ServicioBean> listServicios = new ArrayList<>();

        i=0;
        for(ServicioBean lstResultado : response.getLocal().getServicios()){
            int id = response.getLocal().getServicios().get(i).getIdServicio();
            String nombre = response.getLocal().getServicios().get(i).getNomServicio();
            String activo = response.getLocal().getServicios().get(i).getInActivo();
            if(id!=0 && !nombre.isEmpty() && !activo.isEmpty()){
                listServicios.add(new ServicioBean(id,nombre.toString(),activo.toString())  );
            }
            i++;
        }

        galleryAdapter = new AdapterGalery(listImagenes, ctx);
        listaGaleria.setAdapter(galleryAdapter);
        servicioAdapter = new AdapterServicio(listServicios, ctx);
        listaServicio.setAdapter(servicioAdapter);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        /* categoria*/

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle data=new Bundle();
                data.putString("data","data");
                callActivity(PrincipalMapaActivity.class.getName(), data);

//                Intent intent = new Intent(v.getContext(), PrincipalMapaActivity.class);
//                intent.putExtra("data", "data");
//                startActivity(intent);

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


    /*//////////////////////////////////////////////////////////////////*/


    @OnClick({R.id.agrupar_grilla, R.id.agrupar_lista})
    public void onClick(View view) {
        int columns = 1;
        switch (view.getId()) {
            case R.id.agrupar_grilla:
                columns = 3;
                break;
            case R.id.agrupar_lista:
                columns = 1;
                break;
        }

        manager = new GridLayoutManager(this, columns);
        listaGaleria.setLayoutManager(manager);
        listaGaleria.setAdapter(galleryAdapter);
        listaGaleria.setItemAnimator(new DefaultItemAnimator());
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        } else {
        }

        Marker myMaker;
        LatLng punto = null;
        try {
            if(latitud != 0.0 && longitud != 0.0) {
                punto = new LatLng(latitud, longitud);
            }else {
                latitud = -12.0523638;
                longitud = -77.0409382;
                punto = new LatLng(latitud, longitud);

            }
        } catch (Exception e) {

        }
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(punto)
                .zoom(Constante.ZOOM_MAPA_DEFAULT)
                .build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        myMaker = null;

        try {
            Bitmap bmImg = Ion.with(this)
                    .load(iconMap).asBitmap().get();

            myMaker = googleMap.addMarker(new MarkerOptions()
                    .position(punto).icon(BitmapDescriptorFactory.fromBitmap(bmImg)));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        myMaker.showInfoWindow();

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {
                Bundle bdlCoordenadas = new Bundle();
                Intent i = new Intent(DetalleProveedorActivity.this, MapaInicioActivity.class);
                bdlCoordenadas.putString("longitud", String.valueOf(longitud));
                bdlCoordenadas.putString("latitud", String.valueOf(latitud));
                bdlCoordenadas.putString("iconMap", iconMap);
                i.putExtras(bdlCoordenadas);
                startActivity(i);
            }
        });
    }



    public void llamar(View view) {

        String llamarMesaAyuda = txtTelProveedor.getText().toString().trim();
        Log.v("oe", llamarMesaAyuda);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE}, 144);
        }else{
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + llamarMesaAyuda)));
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==144){
            llamar(llamarproveedor);
        }
    }
}
