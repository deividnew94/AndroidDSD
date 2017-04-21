package com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.ImagenBean;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.ServicioBean;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.VistaPreviaImagenActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by innovagmd on 01/12/16.
 */

public class AdapterServicio extends RecyclerView.Adapter<AdapterServicio.ViewHolder> {
    List<ServicioBean> itemList;
    Context context;

    public AdapterServicio(List<ServicioBean> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_servicio, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder V, int position) {
        V.detaTextView.setText(itemList.get(position).getNomServicio().toString());
        String v_activo;
        if(itemList.get(position).getInActivo().toString().equals("S")){
            v_activo = "Si";
        }else{
            v_activo = "No";
        }
        V.txtServicioActivo.setText(v_activo);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.detalle_servicio)
        TextView detaTextView;

        @BindView(R.id.txtServicioActivo)
        TextView txtServicioActivo;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
