package com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.BeneficioLista;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.ValidarBeneficioFavoritoService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.ValidarBeneficioFavoritoImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.UserDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.DetalleProveedorActivity;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.ListaDetalleDscto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by avermes on 16/12/2016.
 */

public class AdapterDetalleDescuento extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<BeneficioLista> beneficioLista;
    Context context;
    String tipo;
    private static final int ITEM = 0;
    private static final int LOADING = 1;

    private boolean isLoadingAdded = false;

    public AdapterDetalleDescuento(Context context){
        this.beneficioLista = new ArrayList<BeneficioLista>();
        this.context = context;
        this.tipo = tipo;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_lista_detalle_dscto,parent, false);
        AdapterDetalleDescuento.listaDetalleDcto rcv = new AdapterDetalleDescuento.listaDetalleDcto(view);
        return rcv;*/
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case LOADING:
                View v2 = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new AdapterDetalleDescuento.LoadingVH(v2);
                break;
        }
        return viewHolder;
    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.design_lista_detalle_dscto, parent, false);
        viewHolder = new AdapterDetalleDescuento.listaDetalleDcto(v1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder2, int position) {
        switch (getItemViewType(position)) {
            case ITEM:
                listaDetalleDcto holder = (listaDetalleDcto) holder2;
                holder.itemView.setTag(String.valueOf(position));

                holder.idProveedor.setText(String.valueOf(beneficioLista.get(position).getIdBeneficio()));
                holder.nombreRestaurante.setText(beneficioLista.get(position).getNomBeneficio());
                Picasso.with(holder.itemView.getContext()).load(beneficioLista.get(position).getImgBeneficio()).into(holder.photoRestaurante);
                holder.appCompatRatingBarDcto.setRating( ( beneficioLista.get(position).getPuntBeneficio()).floatValue());
                holder.categoria.setText(beneficioLista.get(position).getNomEje());
                holder.ratingText.setText(beneficioLista.get(position).getPuntBeneficio().toString());
                holder.abierto.setText(beneficioLista.get(position).getInAbierto());
                holder.position.setText("a " +  beneficioLista.get(position).getNumDistancia() + " km  -  " + beneficioLista.get(position).getNomDistrito());
                //holder.horaDscto.setText(beneficiosListados.get(position).getHoraDesct());
                if(beneficioLista.get(position).isInFavorito() == true) {

                    holder.favorito.setImageResource(R.drawable.ic_favorito);
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        holder.favorito.setColorFilter(context.getResources().getColor(R.color.red_tab_selected_icon));
                    }
                } else {

                    holder.favorito.setImageResource(R.drawable.ic_favorito_plomo);

                }
                holder.ticket.setText(beneficioLista.get(position).getPorcDescuento().toString());
                break;
            case LOADING:
//                Do nothing
                break;
        }
    }

    @Override
    public int getItemCount() {
        return beneficioLista == null ? 0 : beneficioLista.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == beneficioLista.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }


    public void add(BeneficioLista mc) {
        beneficioLista.add(mc);
        notifyItemInserted(beneficioLista.size() - 1);
    }

    public void addAll(List<BeneficioLista> mcList) {
        for (BeneficioLista mc : mcList) {
            add(mc);
        }
    }

    public void remove(BeneficioLista city) {
        int position = beneficioLista.indexOf(city);
        if (position > -1) {
            beneficioLista.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }


    public boolean isEmpty() {
        return getItemCount() == 0;
    }


    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new BeneficioLista());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = beneficioLista.size() - 1;
        BeneficioLista item = getItem(position);

        if (item != null) {
            beneficioLista.remove(position);
            notifyItemRemoved(position);
        }
    }

    public BeneficioLista getItem(int position) {
        return beneficioLista.get(position);
    }


    public class listaDetalleDcto extends RecyclerView.ViewHolder implements View.OnClickListener{
        Integer inEstadoFav;
        public ImageView photoRestaurante;
        public TextView nombreRestaurante;
        public android.support.v7.widget.AppCompatRatingBar appCompatRatingBarDcto;
        public TextView ratingText;
        public TextView abierto;
        public TextView categoria;
        public TextView position;
        public TextView horaDscto;
        public TextView ticket;
        public TextView idProveedor;
        public ImageView favorito;

        public listaDetalleDcto(View view) {

            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
            photoRestaurante = (ImageView)view.findViewById(R.id.photoRestaurante);
            nombreRestaurante = (TextView)view.findViewById(R.id.nombreRestaurante);
            idProveedor = (TextView)view.findViewById(R.id.idProveedor);
            appCompatRatingBarDcto = (android.support.v7.widget.AppCompatRatingBar)view.findViewById(R.id.appCompatRatingBarDcto);
            categoria = (TextView)view.findViewById(R.id.txtCategoria);
            ratingText = (TextView)view.findViewById(R.id.ratingText);
            abierto = (TextView)view.findViewById(R.id.abierto);
            position = (TextView)view.findViewById(R.id.position);
            horaDscto = (TextView)view.findViewById(R.id.horaDscto);
            ticket = (TextView)view.findViewById(R.id.ticket);
            favorito = (ImageView)view.findViewById(R.id.favorito);

            //para ocultar precio
            if(tipo!=null)
            if(tipo.equals("categoria")){
                favorito.setVisibility(View.GONE);
                horaDscto.setVisibility(View.VISIBLE);
            }else{
                favorito.setVisibility(View.VISIBLE);
                horaDscto.setVisibility(View.GONE);
            }

            favorito.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    beneficioLista.get(getAdapterPosition()).setInFavorito(!beneficioLista.get(getAdapterPosition()).isInFavorito());

                    Integer idBeneficio = beneficioLista.get(getAdapterPosition()).getIdBeneficio();

                    //Actualiar usuario
                    UserDAO userDAO = new UserDAOImpl();
                    User a = userDAO.getCurrentUser();
                    Integer user  = a.getIdUsuario();

                        //callNuevoFavorito.BeneficioFavoritoNuevo(context, idBeneficio, user);


                    Integer idFav = beneficioLista.get(getAdapterPosition()).getIdFavorito();

                    if (beneficioLista.get(getAdapterPosition()).isInFavorito()==true){
                        inEstadoFav = 1;
                    }else
                        inEstadoFav =0;


                        /*ValidarBeneficioFavoritoService callActualizarFavorito = new ValidarBeneficioFavoritoImpl();
                        callActualizarFavorito.BeneficioFavoritoActualizar(context,idFav, inEstadoFav );
                    }*/
                    ValidarBeneficioFavoritoService callActualizarFavorito = new ValidarBeneficioFavoritoImpl();
                    callActualizarFavorito.BeneficioFavoritoActualizar(context, idFav, inEstadoFav, idBeneficio, user );

                    notifyDataSetChanged();
                }
            });

        }

        @Override
        public void onClick(View v) {
            //   int a=Integer.parseInt(v.getTag().toString());
            //Toast.makeText(v.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
//            CategoriasFragment fragment = new CategoriasFragment();
//            fragment.show(getSupportFragmentManager(),"");
            int a=Integer.parseInt(v.getTag().toString());
            int idProveedor = beneficioLista.get(a).getIdBeneficio();

            Intent moreIntent=new Intent(context,DetalleProveedorActivity.class);
            Bundle args = new Bundle();
            args.putInt("idProveedor",idProveedor);
            moreIntent.putExtras(args);
            v.getContext().startActivity(moreIntent);

        }

    }
    public String getInAbierto(String inAbierto) {

        if(inAbierto.toString().equals("S")){
            return"ABIERTO";
        }
        else{
            return"CERRADO";
        }
    }

    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }

}


