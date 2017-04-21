package com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Categoria;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.CategoriasFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by innovagmd on 05/12/16.
 */



public class AdapterCategoria extends RecyclerView.Adapter<AdapterCategoria.CategoriasFragmen>
{
//    public ImageView imageView;
//    public TextView textViewName;
//    List<String> imagenesCategorias;

    List <Categoria> itemList;
    CategoriasFragment context;

    public AdapterCategoria(CategoriasFragment context, List<Categoria> itemList) {
        this.itemList  = itemList ;
        this.context = context;
    }

    @Override
    public CategoriasFragmen onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categoria_layout,parent, false);
        CategoriasFragmen rcv = new CategoriasFragmen(view,context);
        return rcv;
    }

    @Override
    public void onBindViewHolder(CategoriasFragmen holder, int position) {
        holder.itemView.setTag(itemList.get(position).getIdeje());
        holder.textCategoriaMenu.setText(itemList.get(position).getName());
        //holder.imageCategoriaMenu.setImageResource(itemList.get(position).getPhoto());
        Picasso.with(holder.itemView.getContext()).load(itemList.get(position).getPhoto()).into(holder.imageCategoriaMenu);
    }

    @Override
    public int getItemCount() {

        return this.itemList.size();
    }
    public interface OnItemClickListener {
        void onItemClicked(View v);
    }


    public class CategoriasFragmen extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView textCategoriaMenu;
        public ImageView imageCategoriaMenu;
        public OnItemClickListener listener;

        public CategoriasFragmen(View view,OnItemClickListener listener) {
            super(view);
            this.listener = listener;
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
            textCategoriaMenu = (TextView)view.findViewById(R.id.textCategoriaMenu);
            imageCategoriaMenu = (ImageView)view.findViewById(R.id.imageCategoriaMenu);
        }

        @Override
        public void onClick(View v) {


            listener.onItemClicked(v);
          Toast.makeText(v.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
            context.dismiss();

        }
    }
}

