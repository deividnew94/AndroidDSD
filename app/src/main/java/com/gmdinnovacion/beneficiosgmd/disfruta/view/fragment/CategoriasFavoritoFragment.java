package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Categoria;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.FiltroListado;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaFiltrosListadoService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.BandejaFiltrosListadoImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterCategoria;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterFavoritoCategoria;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by avermes on 09/12/2016.
 */

public class CategoriasFavoritoFragment extends DialogFragment implements AdapterFavoritoCategoria.OnItemClickListener {

    @BindView(R.id.lista_categoria)
    RecyclerView listaCategoria;

    GridLayoutManager lLayout;
    Context contexr;

    BandejaFiltrosListadoService
            filtroService = new BandejaFiltrosListadoImpl();


    Handler handler;

    public CategoriasFavoritoFragment(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void onItemClicked(View v) {
        int[] messageString1 = new int[1];
        Message message = handler.obtainMessage();
        messageString1[0]=(int)v.getTag();
        message.obj = messageString1;
        handler.sendMessage(message);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contexr=getActivity();
        EventBus.getDefault().register(this);
        filtroService.CargarFiltrosLista(contexr);
        //((AppCompatActivity) getActivity()).getSupportActionBar().hide();

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void FiltrosCorrecto(List<FiltroListado> response) {

        List<Categoria> allItems = new ArrayList<Categoria>();

        for (FiltroListado filtro: response) {
            allItems.add(new Categoria(filtro.getNomEje(),filtro.getImgEje(),filtro.getIdEje()));
        }

        //List <Categoria> rowListItem = allItems;
//        listaCategoria.setHasFixedSize(true);
//        manager = new GridLayoutManager(contexr, 3);
        lLayout = new GridLayoutManager(contexr, 3);
        listaCategoria.setLayoutManager(lLayout);
        AdapterFavoritoCategoria rcAdapter = new AdapterFavoritoCategoria(this, allItems);
        listaCategoria.setAdapter(rcAdapter);


    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_categoria, container, false);
        ButterKnife.bind(this, view);

            return view;

    }
    public List <Categoria> getAllItemList() {
        List<Categoria> allItems = new ArrayList<Categoria>();
        /*allItems.add(new Categoria("Restaurante", R.drawable.ic_combined_shape_24dp));
        allItems.add(new Categoria("Servicios y Productos", R.drawable.ic_pan));
        allItems.add(new Categoria("Cafetería", R.drawable.ic_bebida));
        allItems.add(new Categoria("Juguería", R.drawable.ic_zanahoria));
        allItems.add(new Categoria("Salud y Belleza", R.drawable.ic_salud));
        allItems.add(new Categoria("Arte y Cultura", R.drawable.ic_arte));*/


        return allItems;
    }

}
