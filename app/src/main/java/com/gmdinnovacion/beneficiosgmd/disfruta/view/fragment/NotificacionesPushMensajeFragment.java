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
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleDescuentoRepositorio;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.BeneficioListaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.repository.ElementosPruebaRepositorio;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.BandejaBeneficioListaImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.UserDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.EndlessRecyclerOnScrollListener;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterDetalleDescuento;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterNotificacionesPushMensaje;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NotificacionesPushMensajeFragment extends Fragment {

    @BindView(R.id.lista_notificaciones)
    RecyclerView recyclerView;

    GridLayoutManager lLayout;
    Context contexr;
    private static String tipo;

    UserDAO userDAO = new UserDAOImpl();
    User a = userDAO.getCurrentUser();

    BandejaBeneficioListaService bandejaServiceF = new BandejaBeneficioListaImpl();

    public NotificacionesPushMensajeFragment() {
        // Required empty public constructor
    }

    public static NotificacionesPushMensajeFragment newInstance(String tipo) {
        Bundle args = new Bundle();
        args.putString("tipo", tipo);
        NotificacionesPushMensajeFragment fragment = new NotificacionesPushMensajeFragment();
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

        EventBus.getDefault().register(this);

        LocationManager locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

        Location location=null;


        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


            if(location!=null)
                bandejaServiceF.CargarBeneficioLista(contexr, a.getIdUsuario(), location.getLatitude(), location.getLongitude(),null,null,null,null,null,false);
            else {
                bandejaServiceF.CargarBeneficioLista(contexr, a.getIdUsuario(), 0.0, 0.0,null,null,null,null,null,false);
                Toast.makeText(contexr, "Sin coordenadas Listar Detalle", Toast.LENGTH_SHORT).show();
            }
        }

    }


    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void beneficioLista(BeneficioListaResponse beneficioListaResponse){

        List<BeneficioLista> rowListItem = beneficioListaResponse.getResult();

        lLayout = new GridLayoutManager(contexr, 1);
        recyclerView.setLayoutManager(lLayout);
//


        /*ScrollListener*/

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(contexr);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                // do something...
            }
        });

        AdapterNotificacionesPushMensaje rcAdapter = new AdapterNotificacionesPushMensaje(rowListItem, this, tipo);

        recyclerView.setAdapter(rcAdapter);

    }
}
