package com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Filtro;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.FiltroActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by innovagmd on 05/12/16.
 */

public class AdapterFiltro extends RecyclerView.Adapter<AdapterFiltro.ViewHolder>{

    List<Filtro> itemList;
    FiltroActivity context;

    public AdapterFiltro(FiltroActivity context, List<Filtro> itemList) {
        this.itemList  = itemList ;
        this.context = context;
    }



    @Override
    public AdapterFiltro.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoria_filtro, parent, false);
        ViewHolder viewHolder = new ViewHolder(view,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterFiltro.ViewHolder holder, int position) {
        holder.itemView.setTag(String.valueOf(position));

        holder.textCategoriaMenu.setText(itemList.get(position).getNomEje());
        if(itemList.get(position).getSelectImage()){

            String img = itemList.get(position).getImgSEje();
            Picasso.with(holder.itemView.getContext()).load(img).into(holder.imageCategoriaMenu);

        }else{

            String img = itemList.get(position).getImgEje();
            Picasso.with(holder.itemView.getContext()).load(img).into(holder.imageCategoriaMenu);
        }

    }


    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public interface OnItemClickListener {
        void onItemIdFiltro(int idFiltro);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textCategoriaMenu;
        public ImageView imageCategoriaMenu;
        public OnItemClickListener listener;

        public ViewHolder(View view,OnItemClickListener listener) {
            super(view);
            this.listener = listener;
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
            textCategoriaMenu = (TextView)view.findViewById(R.id.textCategoria);
            imageCategoriaMenu = (ImageView)view.findViewById(R.id.imageCategoria);
        }


        @Override
        public void onClick(View v) {
            ///setear a todos los objetos de la lista..selected = false
            int b=Integer.parseInt(v.getTag().toString());
            int idImage = itemList.get(b).getIdEje();
            listener.onItemIdFiltro(idImage);
            /*seleccionar solo uno*/
            for(int a = 0; a < itemList.size(); a++) {
                int v_id = itemList.get(a).getIdEje();
                if(v_id == idImage){

                    itemList.get(a).setSelectImage(true);

                }else{

                    itemList.get(a).setSelectImage(false);
                }
            }
            notifyDataSetChanged();
        }
    }
}
