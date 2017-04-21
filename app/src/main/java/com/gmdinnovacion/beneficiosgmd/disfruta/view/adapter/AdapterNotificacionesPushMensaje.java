package com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.BeneficioLista;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleDescuentoRepositorio;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.ValidarBeneficioFavoritoService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.ValidarBeneficioFavoritoImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.UserDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.DetalleProveedorActivity;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.NotificacionesPushMensajeFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by avermes on 16/12/2016.
 */

public class AdapterNotificacionesPushMensaje extends RecyclerView.Adapter<AdapterNotificacionesPushMensaje.listaNotificaciones> {

    List<BeneficioLista> beneficioLista;
//    Context context;
    NotificacionesPushMensajeFragment context;
    String tipo;

    public AdapterNotificacionesPushMensaje(List<BeneficioLista> beneficioLista, NotificacionesPushMensajeFragment context, String tipo){
        this.beneficioLista = beneficioLista;
        this.context = context;
        this.tipo = tipo;
    }

    @Override
    public AdapterNotificacionesPushMensaje.listaNotificaciones onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_lista_detalle_dscto,parent, false);
        AdapterNotificacionesPushMensaje.listaNotificaciones rcv = new AdapterNotificacionesPushMensaje.listaNotificaciones(view);
        return rcv;
    }

    @Override
    public void onBindViewHolder(AdapterNotificacionesPushMensaje.listaNotificaciones holder, int position) {
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
    }

    @Override
    public int getItemCount() {
        return this.beneficioLista.size();
    }

    public class listaNotificaciones extends RecyclerView.ViewHolder implements View.OnClickListener{
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

        public listaNotificaciones(View view) {
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

                        //nuevo

                        Integer idFav = beneficioLista.get(getAdapterPosition()).getIdFavorito();

                        if (beneficioLista.get(getAdapterPosition()).isInFavorito()==true){
                            inEstadoFav = 1;
                        }else
                            inEstadoFav =0;


                        ValidarBeneficioFavoritoService callActualizarFavorito = new ValidarBeneficioFavoritoImpl();
                        callActualizarFavorito.BeneficioFavoritoActualizar(context.getActivity(), idFav, inEstadoFav, idBeneficio, user );
                        notifyDataSetChanged();
                }
            });
        }

        @Override
        public void onClick(View v) {
            int a=Integer.parseInt(v.getTag().toString());
            int idProveedor = beneficioLista.get(a).getIdBeneficio();

            Intent moreIntent=new Intent(context.getActivity(),DetalleProveedorActivity.class);
            Bundle args = new Bundle();
            args.putInt("idProveedor",idProveedor);
            moreIntent.putExtras(args);
            v.getContext().startActivity(moreIntent);
        }


    }



}


