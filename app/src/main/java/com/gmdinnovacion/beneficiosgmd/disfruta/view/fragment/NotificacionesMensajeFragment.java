package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.BeneficioLista;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.BeneficioListaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.BandejaBeneficioListaImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.EndlessRecyclerOnScrollListener;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterNotificacionesPushMensaje;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NotificacionesMensajeFragment extends Fragment {

    @BindView(R.id.lista_notificaciones)
    RecyclerView recyclerView;

    GridLayoutManager lLayout;
    Context contexr;
    private static String tipo;

    BandejaBeneficioListaService bandejaServiceF = new BandejaBeneficioListaImpl();

    public NotificacionesMensajeFragment() {
        // Required empty public constructor
    }

    public static NotificacionesMensajeFragment newInstance(String tipo) {
        Bundle args = new Bundle();
        args.putString("tipo", tipo);
        NotificacionesMensajeFragment fragment = new NotificacionesMensajeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_notificaciones_push_mensaje, container, false);
        ButterKnife.bind(this, view);

        tipo = getArguments().getString("tipo");

        contexr=getActivity();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onStop() {
        super.onStop();
    }
}
