package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Empresa;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.RegionesLogin;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterRegionesLogin;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegionesLoginFragment extends DialogFragment {

    @BindView(R.id.RvRegionesLogin)
    RecyclerView rvRegionesLogin;
    ArrayList<String>  lista;
    GridLayoutManager lLayout;
    Context contexr;
    OnCompleteListener onCompleteListener;

    public static interface OnCompleteListener {
        public abstract void onComplete(RegionesLogin time);
    }

    public RegionesLoginFragment() {
        // Required empty public constructor
    }
/*
    public RegionesLoginFragment(List<EmpresaImpl> empresa) {
        listEmpresas=empresa;

    }*/

    public void setClicck(OnCompleteListener onCompleteListener ){
        this.onCompleteListener=onCompleteListener;
    }

    public static RegionesLoginFragment newInstance(List<Empresa> empresas) {
        RegionesLoginFragment fragment = new RegionesLoginFragment();

        Bundle args = new Bundle();
        ArrayList<String> lista = new ArrayList<>();

        for (Empresa emp: empresas) {

            lista.add(emp.getNomEmpresa());
        }

        args.putStringArrayList("lista",lista);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contexr=this.getActivity();
        lista = getArguments().getStringArrayList("lista");

        //recuperar la lista de empresas

    }

    @Override
    public void onResume() {
        super.onResume();

        //Recuperar la lista de empresas



        List<RegionesLogin> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(contexr, 1);
        rvRegionesLogin.setLayoutManager(lLayout);
        AdapterRegionesLogin rcAdapter = new AdapterRegionesLogin(this, rowListItem, new AdapterRegionesLogin.OnCompleteListenerRV() {
            @Override
            public void onComplete(RegionesLogin regionesLogin) {
                onCompleteListener.onComplete(regionesLogin);
                dismiss();
            }
        });
        rvRegionesLogin.setAdapter(rcAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_regiones_login, container, false);
        ButterKnife.bind(this, view);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        contexr=getActivity();


        return view;
    }

    public List <RegionesLogin> getAllItemList() {

        List<RegionesLogin> allItems = new ArrayList<>();
        for (String empresa : lista){
            allItems.add(new RegionesLogin(empresa));
        }

        return allItems;
    }

}
