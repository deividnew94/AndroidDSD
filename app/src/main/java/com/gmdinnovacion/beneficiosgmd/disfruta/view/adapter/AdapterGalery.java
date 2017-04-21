package com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.ImagenBean;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.DetalleProveedorActivity;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.VistaPreviaImagenActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.gmdinnovacion.beneficiosgmd.disfruta.R.id.idProveedor;

/**
 * Created by innovagmd on 01/12/16.
 */

public class AdapterGalery extends RecyclerView.Adapter<AdapterGalery.ViewHolderDenuncias> {
    List<ImagenBean> imagenes;
    Context context;

    public AdapterGalery(List<ImagenBean> imagenes, Context context) {
        this.imagenes = imagenes;
        this.context = context;
    }

    @Override
    public ViewHolderDenuncias onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foto_miniatura, parent, false);
        ViewHolderDenuncias viewHolder = new ViewHolderDenuncias(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderDenuncias V, int position) {
        Picasso.with(context).load(imagenes.get(position).getUrlImagenPrevia()).into(V.imgvFoto);
     //   V.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return imagenes.size();
    }



    public class ViewHolderDenuncias extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.imgv_foto)
        ImageView imgvFoto;
        public ViewHolderDenuncias(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            String urlImagen = imagenes.get(getPosition()).getUrlImagen();
            Intent moreIntent=new Intent(context.getApplicationContext(),VistaPreviaImagenActivity.class);
            Bundle args = new Bundle();
            args.putString("url_imagen",urlImagen);
            moreIntent.putExtras(args);
            v.getContext().startActivity(moreIntent);

        }
    }



}
