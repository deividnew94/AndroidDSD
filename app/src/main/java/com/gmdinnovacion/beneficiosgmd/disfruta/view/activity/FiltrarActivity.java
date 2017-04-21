package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FiltrarActivity extends BaseActivity {


    @BindView(R.id.boton_close)
    ImageButton botonClose;
    @BindView(R.id.buscar_nombre)
    SearchView buscarNombre;
    @BindView(R.id.buscar_lugar)
    SearchView buscarLugar;
    @BindView(R.id.activity_filtrar)
    LinearLayout activityFiltrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtrar);
        ButterKnife.bind(this);

        int fragmentSelect = getIntent().getExtras().getInt("fragmentoSelect");

        if(fragmentSelect == 1){
            buscarLugar.setVisibility(View.GONE);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.red_toolbar));
            getWindow().setStatusBarColor(getResources().getColor(R.color.red_toolbar));
//            final Drawable upArrow = getResources().getDrawable(R.drawable.ic_search_filtrar_24dp);
//            upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
//            getSupportActionBar().setHomeAsUpIndicator(upArrow);

//            final Drawable delte = getResources().getDrawable(R.drawable.ic_close_white_24dp);
//            upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
//            getSupportActionBar().setHomeAsUpIndicator(delte);
        }

        botonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }



}