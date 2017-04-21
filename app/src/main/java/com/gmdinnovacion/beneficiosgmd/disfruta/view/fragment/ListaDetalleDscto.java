package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.BeneficioLista;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.BeneficioListaResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioFavoritoListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioFiltroListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.BandejaBeneficioListaImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.BandejaBeneficiosFavoritoListadoImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.BandejaBeneficiosFiltroListadoImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.UserDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.EndlessRecyclerOnScrollListener;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.PaginationScrollListener;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterDetalleDescuento;
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

public class ListaDetalleDscto extends Fragment {

    private static String tipoC;

    @BindView(R.id.lista_categoria)
    RecyclerView recyclerView;
    @BindView(R.id.filtroCategoria)
    ImageView filtroCategoria;
    @BindView(R.id.totalCantidades)
    TextView totalCantidades;
    @BindView(R.id.refreshBeneficioLista)
    SwipeRefreshLayout refreshBeneficioLista;
    private RefreshCall mRefreshCall;
    GridLayoutManager lLayout;
    Context contexr;

    @BindView(R.id.main_progress)
    ProgressBar progressBar;

    public interface RefreshCall {

        boolean onMethodRefreshCall();
    }

    BandejaBeneficioListaService bandejaServiceF = new BandejaBeneficioListaImpl();


    UserDAO userDAO = new UserDAOImpl();
    User a = userDAO.getCurrentUser();


    private static final int PAGE_START = 0;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int TOTAL_PAGES = 2;
    private int currentPage = PAGE_START;
    private static final String TAG = "ListaDetalleDscto";
    Location location=null;
    AdapterDetalleDescuento rcAdapter;

    public static ListaDetalleDscto newInstance(String tipo) {
        Bundle args = new Bundle();

        args.putString("tipo", tipo);
        ListaDetalleDscto fragment = new ListaDetalleDscto();
        fragment.setArguments(args);

        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contexr=getActivity();

    }

    public ListaDetalleDscto() {
        // Required empty public constructor
    }


    @Override
    public void onPause() {
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onPause();
    }


    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_detalle_dscto_rv, container, false);
        ButterKnife.bind(this, view);
        rowListItem = new ArrayList<>();

        tipoC = getArguments().getString("tipo");

        //bandejaService.CargarBeneficioLista(contexr,null);

        /*LocationManager locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


            if(location!=null) bandejaServiceF.CargarBeneficioLista(contexr,a.getIdUsuario(), location.getLatitude(), location.getLongitude(),null,null,null,null,0,true);
            else {
                bandejaServiceF.CargarBeneficioLista(contexr,a.getIdUsuario(), 0.0, 0.0,null,null,null,null,0,true);
                Toast.makeText(contexr, "Sin coordenadas Listar Detalle", Toast.LENGTH_SHORT).show();
            }
        }*/

        /*ScrollListener*/

        linearLayoutManager = new LinearLayoutManager(contexr);
        recyclerView.setLayoutManager(linearLayoutManager);
        /*recyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int current_page) {
                // do something...
            }
        });*/

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        rcAdapter = new AdapterDetalleDescuento(getActivity());

        recyclerView.setAdapter(rcAdapter);
        filtroCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoriasFragment fragment = new CategoriasFragment(new CategoriasFragmentDismmiss());
                fragment.show(getFragmentManager(),"");
            }
        });

        recyclerView.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //progressBar.setVisibility(View.VISIBLE);

                        /*if (currentPage != TOTAL_PAGES) rcAdapter.addLoadingFooter();
                        else {
                            isLastPage = true;
                            rcAdapter.removeLoadingFooter();
                            isLoading = false;
                        }*/
                        if(location!=null) bandejaServiceF.CargarBeneficioLista(contexr,a.getIdUsuario(), location.getLatitude(), location.getLongitude(),(idcategoria==0)?null:idcategoria,null,null,null, currentPage,true);
                        else {
                            bandejaServiceF.CargarBeneficioLista(contexr,a.getIdUsuario(), 0.0, 0.0,(idcategoria==0)?null:idcategoria,null,null,null, currentPage,true);
                            Toast.makeText(contexr, "Sin coordenadas Listar Detalle", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, 1000);

            }

            @Override
            public int getTotalPageCount() {
                return TOTAL_PAGES;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });


        refreshBeneficioLista = (SwipeRefreshLayout) view.findViewById(R.id.refreshBeneficioLista);
        refreshBeneficioLista.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent);
        refreshBeneficioLista.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                llamarServicioListaSolicitudes();
            }
        });

        return view;
    }

    void llamarServicioListaSolicitudes() {
        refreshBeneficioLista.setRefreshing(false);
        idcategoria=0;
        rowListItem = new ArrayList<>();
        currentPage = 0;
        isLastPage = false;
        isLoading = false;
        rcAdapter.clear();
        rcAdapter.notifyDataSetChanged();
        if(location!=null) bandejaServiceF.CargarBeneficioLista(contexr,a.getIdUsuario(), location.getLatitude(), location.getLongitude(),(idcategoria==0)?null:idcategoria,null,null,null, currentPage,true);
        else {
            bandejaServiceF.CargarBeneficioLista(contexr,a.getIdUsuario(), 0.0, 0.0,(idcategoria==0)?null:idcategoria,null,null,null, currentPage,true);
            Toast.makeText(contexr, "Sin coordenadas Listar Detalle", Toast.LENGTH_SHORT).show();
        }

    }



    LinearLayoutManager linearLayoutManager;
    List<BeneficioLista> rowListItem;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void beneficioLista(BeneficioListaResponse beneficioListaResponse){

        //rowListItem = beneficioListaResponse.getResult();

        for (BeneficioLista beneficio: beneficioListaResponse.getResult()) {
            //allItems.add(new DetalleDescuentoRepositorio(beneficio.getIdBeneficio(),beneficio.getImgBeneficio(),beneficio.getNomBeneficio(),beneficio.getNomEje(),(beneficio.getIdFavorito()==1)?true:false,Float.parseFloat(""+beneficio.getPuntBeneficio()),""+beneficio.getPuntBeneficio(),((beneficio.getInAbierto().equals("S"))?"ABIERTO":"")+((beneficio.getInAbierto().equals("N"))?"CERRADO":""),"a - "+beneficio.getNumDistancia()+"km "+beneficio.getNomDistrito(),"",""+beneficio.getPorcDescuento()+"%",beneficio.getIdEje()));
            rowListItem.add(beneficio);
        }

        totalCantidades.setText(String.valueOf(rowListItem.size()));
        /*lLayout = new GridLayoutManager(contexr, 1);
        recyclerView.setLayoutManager(lLayout);*/
//

        if(beneficioListaResponse.getResult().size()!=0) {
            rcAdapter.clear();
            rcAdapter.addAll(rowListItem);
            rcAdapter.notifyDataSetChanged();
            if (currentPage == 0) {
                rcAdapter.addLoadingFooter();
            }
        }else{

            isLastPage = true;
            rcAdapter.removeLoadingFooter();
            isLoading = false;
        }

    }

    int idcategoria;

    private class CategoriasFragmentDismmiss extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int[] data = (int[]) msg.obj; // If object is of String
            idcategoria=data[0];
            rowListItem = new ArrayList<>();
            currentPage = 0;
            isLastPage = false;
            isLoading = false;
            rcAdapter.clear();
            rcAdapter.notifyDataSetChanged();

            bandejaServiceF.CargarBeneficioLista(contexr,a.getIdUsuario(), 0.0, 0.0,data[0],null,null,null,0,true);

        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }


        filtroCategoria.setVisibility(View.GONE);
        int idEje, descuento, distancia;
        String puntuacion;

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Filtro", Context.MODE_PRIVATE);
        idEje = sharedPreferences.getInt("idEje", 0);
        descuento = sharedPreferences.getInt("descuento", 0);
        distancia = sharedPreferences.getInt("distancia", 0);
        puntuacion = sharedPreferences.getString("puntuacion", "");

        LocationManager locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

        Location location=null;

        if( descuento!=0 && distancia!=0 ){
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location!=null)
                    bandejaServiceF.CargarBeneficioLista(contexr,a.getIdUsuario(), Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), idEje, descuento, distancia, puntuacion,null,true);
                else {
                }
            }
            SharedPreferences settings = contexr.getSharedPreferences("Filtro", Context.MODE_PRIVATE);
            settings.edit().clear().commit();
        }else{
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


                if(location!=null) bandejaServiceF.CargarBeneficioLista(contexr, a.getIdUsuario(), location.getLatitude(), location.getLongitude(), null, null, null ,null,(idcategoria==0)?null:idcategoria,true);
                else {
                    bandejaServiceF.CargarBeneficioLista(contexr,a.getIdUsuario(), 0.0, 0.0, null, null, null ,null,(idcategoria==0)?null:idcategoria,true);
                    Toast.makeText(contexr, "Sin coordenadas Listar Detalle", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
