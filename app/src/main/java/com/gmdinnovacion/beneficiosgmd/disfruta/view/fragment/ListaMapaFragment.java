package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.library.SegmentedGroup;
import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.BandejaBeneficioListaImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.FiltrarActivity;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.FiltroActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListaMapaFragment extends Fragment {


    String tipo;
    String data;
    int filtrarNombre;
    @BindView(R.id.listadisfruta)
    TextView listadisfruta;
    @BindView(R.id.mapadisfruta)
    TextView mapadisfruta;
    @BindView(R.id.boton_tuner)
    ImageView tuner;
    @BindView(R.id.boton_search)
    ImageView search;
    @BindView(R.id.spaceTop)
    LinearLayout spaceTop;
    @BindView(R.id.fragment_base)
    FrameLayout fragment_base;
    @BindView(R.id.fragment_maps)
    FrameLayout fragmentMaps;
    /* @BindView(R.id.viewPagerFiltro)
     ViewPager viewPagerFiltro;*/
    @BindView(R.id.segmentedGroup)
    SegmentedGroup segmentedGroup;
    @BindView(R.id.toolbarMapDisfruta)
    Toolbar toolbarMapDisfruta;
//    private FragmentManager supportFragmentManager;
//    final FragmentManager fragmentManager =  getActivity().getSupportFragmentManager();

    Fragment mFragment02;
    Fragment mFragment01;

    int contador = 0;
    int contadorL = 0;

    int indice = 0;
    Context context;

    public ListaMapaFragment() {
        // Required empty public constructor
    }

    public static ListaMapaFragment newInstance(String tipo, String data) {
        ListaMapaFragment fragment = new ListaMapaFragment();

        Bundle args = new Bundle();
        args.putString("tipo", tipo);
        args.putString("data", data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();

    }

    @Override
    public void onResume() {
        super.onResume();

        tipo = getArguments().getString("tipo");
        data = getArguments().getString("data");

        if (data == null) data = "0";
        if (data.equalsIgnoreCase("data")) {
            spaceTop.setVisibility(View.GONE);
            toolbarMapDisfruta.setBackgroundColor(getResources().getColor(R.color.transparente));
            segmentedGroup.check(R.id.mapadisfruta);
            mostrarMapas();
            data = null;
        } else {
            spaceTop.setVisibility(View.VISIBLE);
            toolbarMapDisfruta.setBackgroundColor(getResources().getColor(R.color.red_tab_selected_icon));
            segmentedGroup.check(R.id.listadisfruta);
            getListas();

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_mapa, container, false);
        ButterKnife.bind(this, v);

        segmentedGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //2131689787 =mapaif
                if (indice == 0) {

                    getListas();

                } else if (indice == 1) {

                    mostrarMapas();
                }


                Log.i("checked", "" + segmentedGroup.getCheckedRadioButtonId());

            }

        });
        cargarMapaLista();
        listadisfruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= 21) {
                    toolbarMapDisfruta.setBackgroundColor(getResources().getColor(R.color.red_tab_selected_icon));
                    spaceTop.setVisibility(View.VISIBLE);
                } else {
                    toolbarMapDisfruta.setBackgroundColor(getResources().getColor(R.color.red_tab_selected_icon));
                    spaceTop.setVisibility(View.VISIBLE);
                }
            }
        });

        mapadisfruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= 21) {
                    toolbarMapDisfruta.setBackgroundColor(getResources().getColor(R.color.transparente));
                    spaceTop.setVisibility(View.GONE);
                } else {

                    toolbarMapDisfruta.setBackgroundColor(getResources().getColor(R.color.transparente));

                }
            }
        });

        return v;
    }

    int fragSelect;

    public void mostrarMapas() {
        fragSelect = 0;

        getActivity().getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .show(mFragment02)
                .hide(mFragment01)
                .commit();

        fragmentMaps.setVisibility(View.VISIBLE);
        fragment_base.setVisibility(View.GONE);
        indice = 0;
    }

    private void getListas() {
        fragSelect = 1;

        getActivity().getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .hide(mFragment02)
                .show(mFragment01)
                .commit();
        fragmentMaps.setVisibility(View.GONE);
        fragment_base.setVisibility(View.VISIBLE);
        indice = 1;
    }


//    public void mostrarMapa() {
//        Log.i("frag", "mostrarMapa" + contador++);
//        fragSelect = 0;
//        Fragment mFragment02 = DisfrutaMapFragment.newInstance("mensaje");
//        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
//
////        fragmentTransaction.show(mFragment02);
//
//        fragmentTransaction.replace(R.id.fragment_base, mFragment02);
//        fragmentTransaction.commit();
//        indice = 0;
//    }
//
//    private void getLista() {
//        Log.i("frag", "Lista" + contadorL++);
//        fragSelect = 1;
//        Fragment mFragment01 = ListaDetalleDscto.newInstance("tipo");
//        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fragmentTransaction.replace(R.id.fragment_base, mFragment01);
//        fragmentTransaction.commit();
//        indice = 1;
//    }

    private void cargarMapaLista() {
        mFragment02 = DisfrutaMapFragment.newInstance("mensaje");
        mFragment01 = ListaDetalleDscto.newInstance("tipo");

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_base, mFragment01, "list");
        ft.replace(R.id.fragment_maps, mFragment02, "maps");
        ft.commit();

    }

    @OnClick({R.id.listadisfruta, R.id.mapadisfruta, R.id.boton_tuner, R.id.boton_search})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.boton_tuner:
                Intent intent = new Intent(getActivity(), FiltroActivity.class);
                startActivity(intent);
                break;
            case R.id.boton_search:
                Bundle objFrag = new Bundle();
                objFrag.putInt("fragmentoSelect", fragSelect);

                Intent intentSearch = new Intent(getActivity(), FiltrarActivity.class);
                intentSearch.putExtras(objFrag);
                startActivity(intentSearch);
                break;

        }
    }



}
