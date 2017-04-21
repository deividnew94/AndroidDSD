package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.crystal.crystalrangeseekbar.interfaces.OnSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalSeekbar;
import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Filtro;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.FiltroBean;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaFiltrosListadoService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.FiltroService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.BandejaFiltrosListadoImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.FiltroImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.UserDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterFiltro;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FiltroActivity extends AppCompatActivity implements View.OnClickListener, AdapterFiltro.OnItemClickListener {

    @BindView(R.id.rv_categorias)
    RecyclerView rvCategorias;

    @BindView(R.id.close)
    ImageButton close;

    @BindView(R.id.boton_toolbar)
    Button borrar_filtro;

    @BindView(R.id.btnFiltrar)
    Button btnFiltrar;

    @BindView(R.id.rangeSeekbar1)
    CrystalSeekbar rangeDescuento;

    @BindView(R.id.textMin1)
    TextView tvMinDescuento;

    @BindView(R.id.rangeSeekbar2)
    CrystalSeekbar rangeDistancia;

    @BindView(R.id.textMin2)
    TextView tvMinDistancia;

    @BindView(R.id.appCompatRatingBar2)
    AppCompatRatingBar valoracion;

    AdapterFiltro adapterFiltro;
    Context ctx;
    List<Filtro> allItems;

    int idCategoria = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);
        ButterKnife.bind(this);

  /*
        *INICIO Servicio
        */
        FiltroService filtroService = new FiltroImpl();

        filtroService.getFiltros(ctx);

        /*
        *FIN Servicio
        */

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.red_toolbar));
        }

        rangeDescuento.setOnSeekbarChangeListener(new OnSeekbarChangeListener() {
            @Override
            public void valueChanged(Number value) {
                tvMinDescuento.setText(String.valueOf(value));
            }
        });

        rangeDistancia.setOnSeekbarChangeListener(new OnSeekbarChangeListener() {
            @Override
            public void valueChanged(Number value) {
                tvMinDistancia.setText(String.valueOf(value));
            }
        });

        ctx = this;

        close.setOnClickListener(this);

        borrar_filtro.setOnClickListener(this);

        btnFiltrar.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();


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
    public void FiltrosCorrecto(List<FiltroBean> response) {

        LinearLayoutManager lm = new LinearLayoutManager(ctx);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvCategorias.setLayoutManager(lm);

        allItems = new ArrayList<Filtro>();

        for (FiltroBean filtro : response) {
            allItems.add(new Filtro(filtro.getIdEje(), filtro.getNomEje(), filtro.getImgEje(), filtro.getImgSEje(), filtro.getIconEje(), false));
        }
        adapterFiltro = new AdapterFiltro(this, allItems);
        rvCategorias.setAdapter(adapterFiltro);

    }

    @Override
    public void onItemIdFiltro(int id) {
        idCategoria = id;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFiltrar:
                int descuento = Integer.valueOf(tvMinDescuento.getText().toString());
                int distancia = Integer.valueOf(tvMinDistancia.getText().toString());
                double puntuacion = Double.valueOf(String.valueOf(valoracion.getRating()));

                if( (descuento>0) && (distancia>0) ){
                    SharedPreferences.Editor editor = ctx.getSharedPreferences("Filtro", ctx.MODE_PRIVATE).edit();
                    editor.putInt("idEje", idCategoria);
                    editor.putInt("descuento", descuento);
                    editor.putInt("distancia",distancia);
                    editor.putString("puntuacion", String.valueOf(puntuacion));
                    editor.apply();
                }
                onBackPressed();

                break;
            case R.id.boton_toolbar:
                //Categorias
                ArrayList<Filtro> Items = new ArrayList<Filtro>();

                for (Filtro filtro: allItems) {
                    Items.add(new Filtro(filtro.getIdEje(),filtro.getNomEje(),filtro.getImgEje(),filtro.getImgSEje(),filtro.getIconEje(),false));
                }
                adapterFiltro=new AdapterFiltro(this, Items);
                rvCategorias.setAdapter(adapterFiltro);
                //Rango Descuento
                rangeDescuento.setMinValue(5).setMinStartValue(5).apply();
                tvMinDescuento.setText(String.valueOf(5));
                //Rango Descuento
                rangeDistancia.setMinValue(5).setMinStartValue(5).apply();
                tvMinDistancia.setText(String.valueOf(5));
                //Valoracion
                valoracion.setRating(0);
                valoracion.setNumStars(0);
                break;
            case R.id.close:
                onBackPressed();
                break;
        }
    }
}

