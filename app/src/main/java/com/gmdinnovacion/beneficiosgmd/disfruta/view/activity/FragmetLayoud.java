package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.ListaDetalleDscto;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmetLayoud extends AppCompatActivity {

    @BindView(R.id.fragmentCategoria)
    FrameLayout fragmentCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmet_layoud);
        ButterKnife.bind(this);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        //Fragment fragment = FragmentMapaDetalle.newInstance(new LatLng(latiud, longitud), ocurrencia.getResult().getIdOcurrencia());
        Fragment fragment = ListaDetalleDscto.newInstance("1");
        android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragmentCategoria, fragment);
        ft.commit();

//        //Fragment fragment = FragmentMapaDetalle.newInstance(new LatLng(latiud, longitud), ocurrencia.getResult().getIdOcurrencia());
//        Fragment fragmentUser = UsuarioFragment.newInstance("2");
//        android.support.v4.app.FragmentTransaction ftUser = fragmentManager.beginTransaction();
//        ftUser.replace(R.id.fragmentCategoria, fragmentUser);
//        ftUser.commit();
    }

}
