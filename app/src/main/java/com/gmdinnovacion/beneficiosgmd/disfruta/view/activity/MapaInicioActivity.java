package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageButton;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
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

import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapaInicioActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    @BindView(R.id.boton_close)
    ImageButton close;
    Double longitud =0.0;
    Double latitud = 0.0;
    String iconMap = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_inicio);
        ButterKnife.bind(this);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        latitud = Double.parseDouble(getIntent().getExtras().getString("latitud"));
        longitud = Double.parseDouble(getIntent().getExtras().getString("longitud"));
        iconMap = getIntent().getExtras().getString("iconMap");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        Marker myMaker;
        LatLng punto=null;
        try {
            if(longitud != 0.0 && latitud != 0.0) {
                punto = new LatLng(latitud, longitud);
            }else{
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

    }
}
