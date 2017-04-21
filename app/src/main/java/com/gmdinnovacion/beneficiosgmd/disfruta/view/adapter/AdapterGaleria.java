package com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.DetalleGaleria;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.GaleriaActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jsaenz on 17/1/2017.
 */

public class AdapterGaleria extends RecyclerView.Adapter<AdapterGaleria.listaGaleriaBusqueda> {
    List<DetalleGaleria> listaGaleriaBusqueda;
    GaleriaActivity context;

    public AdapterGaleria(List<DetalleGaleria> listaGaleriaBusqueda, GaleriaActivity context){
        this.listaGaleriaBusqueda = listaGaleriaBusqueda;
        this.context = context;
    }

    @Override
    public AdapterGaleria.listaGaleriaBusqueda onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_galeria,parent,false);
        AdapterGaleria.listaGaleriaBusqueda lisSol = new AdapterGaleria.listaGaleriaBusqueda(view);
        return lisSol;
    }

    @Override
    public void onBindViewHolder(AdapterGaleria.listaGaleriaBusqueda holder, int position) {
        holder.itemView.setTag(String.valueOf(position));

        Picasso.with(context).load(listaGaleriaBusqueda.get(position).getPhotoRestaurante()).into(holder.imgImagGaleria);
        //holder.imgImagGaleria.setImageResource(listaGaleriaBusqueda.get(position).getPhotoRestaurante());
        holder.txtDescrImagGaleria.setText(listaGaleriaBusqueda.get(position).getDescrRestaurante());
    }

    @Override
    public int getItemCount() {
        return this.listaGaleriaBusqueda.size();
    }

    public class listaGaleriaBusqueda extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imgImagGaleria;
        public TextView txtDescrImagGaleria;

        public listaGaleriaBusqueda(View View) {
            super(View);
            itemView.setOnClickListener(this);
            imgImagGaleria = (ImageView)View.findViewById(R.id.imgImagGaleria);
            txtDescrImagGaleria = (TextView)View.findViewById(R.id.txtDescrImagGaleria);
        }

        @Override
        public void onClick(View v) {
            int a=Integer.parseInt(v.getTag().toString());
            //Toast.makeText(v.getContext(),""+listaSolicitudesBusqueda.get(a).getTipoSolicitud(),Toast.LENGTH_LONG).show();
//            switch (listaSolicitudesBusqueda.get(a).getTipoSolicitud()){
//                case "2":
//                    Intent intListReqVac = new Intent(v.getContext(), DetailVacationActivity.class);
//                    Bundle args = new Bundle();
//                    args.putString("sndTxtTipoSolicitud",listaSolicitudesBusqueda.get(a).getTipoSolicitud());
//                    args.putString("sndTxtCodigoSolicitud",listaSolicitudesBusqueda.get(a).getCodigoSolicitud());
//                    intListReqVac.putExtras(args);
//                    v.getContext().startActivity(intListReqVac);
//                    break;
//                case "1":
//                    Intent intListReqContr = new Intent(v.getContext(), DetailContractActivity.class);
//                    Bundle argsContr = new Bundle();
//                    argsContr.putString("sndTxtTipoSolicitud",listaSolicitudesBusqueda.get(a).getTipoSolicitud());
//                    argsContr.putString("sndTxtCodigoSolicitud",listaSolicitudesBusqueda.get(a).getCodigoSolicitud());
//                    intListReqContr.putExtras(argsContr);
//                    v.getContext().startActivity(intListReqContr);
//                    break;
//                case "3":
//                    Intent intListReqCentCost = new Intent(v.getContext(), DetailCostCenterActivity.class);
//                    Bundle argsCentCost = new Bundle();
//                    argsCentCost.putString("sndTxtTipoSolicitud",listaSolicitudesBusqueda.get(a).getTipoSolicitud());
//                    argsCentCost.putString("sndTxtCodigoSolicitud",listaSolicitudesBusqueda.get(a).getCodigoSolicitud());
//                    intListReqCentCost.putExtras(argsCentCost);
//                    v.getContext().startActivity(intListReqCentCost);
//                    break;
//            }
        }
    }
}
