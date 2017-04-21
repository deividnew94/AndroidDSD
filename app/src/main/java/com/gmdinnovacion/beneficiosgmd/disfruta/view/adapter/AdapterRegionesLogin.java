package com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.RegionesLogin;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.RegionesLoginFragment;

import java.util.List;

/**
 * Created by avermes on 28/12/2016.
 */

public class AdapterRegionesLogin extends RecyclerView.Adapter<AdapterRegionesLogin.regionesLogin>{

    public static interface OnCompleteListenerRV {
        public abstract void onComplete(RegionesLogin regionesLogin);
    }

    List<RegionesLogin> listaRegionesLogin;
    RegionesLoginFragment context;
    OnCompleteListenerRV onCompleteListener;
    private int mSelectedItem = -1;

    public  AdapterRegionesLogin( RegionesLoginFragment context, List<RegionesLogin> listaRegionesLogin,OnCompleteListenerRV onCompleteListener) {
        this.listaRegionesLogin = listaRegionesLogin;
        this.context = context;
        this.onCompleteListener=onCompleteListener;
    }

    @Override
    public AdapterRegionesLogin.regionesLogin onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_regiones_login,parent, false);
        AdapterRegionesLogin.regionesLogin rcv = new AdapterRegionesLogin.regionesLogin(view);

        return rcv;
    }

    @Override
    public void onBindViewHolder(final AdapterRegionesLogin.regionesLogin holder, final int position) {

        holder.radioButtonRegiones.setText(listaRegionesLogin.get(position).getNombreEmpresa());
        holder.radioButtonRegiones.setOnCheckedChangeListener(null);
        //holder.radioButtonRegiones.setChecked(position == mSelectedItem);
            if(listaRegionesLogin.get(position).getEstado()){
                holder.radioButtonRegiones.setChecked(true);
                holder.radioButtonRegiones.setTextColor(Color.BLACK);

            }else{
                holder.radioButtonRegiones.setChecked(false);
                holder.radioButtonRegiones.setTextColor(Color.GRAY);
            }
        holder.radioButtonRegiones.setTag(String.valueOf(position));

      /*  holder.radioButtonRegiones.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (position == mSelectedItem) {
                    holder.radioButtonRegiones.setChecked(false);
                   // holder.radioButtonRegiones.setTextColor(Color.BLACK);
                    mSelectedItem = -1;
                } else {
                    mSelectedItem = position;
                   // holder.radioButtonRegiones.setTextColor(Color.GRAY);
                    notifyDataSetChanged();
                    //holder.radioButtonRegiones.setTextColor(Color.GRAY);
                }
            }
        });*/

//        holder.radioButtonRegiones.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (position == mSelectedItem) {
//                    holder.radioButtonRegiones.setChecked(false);
//                    mSelectedItem = -1;
//                } else {
//                    mSelectedItem = position;
//                    notifyDataSetChanged();
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return this.listaRegionesLogin.size();
    }

    public class regionesLogin extends RecyclerView.ViewHolder implements View.OnClickListener{

        public RadioButton radioButtonRegiones;
        public LinearLayout radioButtonContent;

        public regionesLogin(View view) {
            super(view);
            view.setOnClickListener(this);

            radioButtonRegiones = (RadioButton)view.findViewById(R.id.radioButtonRegiones);
            radioButtonContent = (LinearLayout)view.findViewById(R.id.radioButtonContent);
            radioButtonRegiones.setTextColor(Color.GRAY);
            radioButtonRegiones.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText(v.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
                   /*  if (radioButtonRegiones.isChecked()){
                        radioButtonRegiones.setTextColor(Color.GREEN);
                        //context.dismiss();

                    } else {
                        radioButtonRegiones.setTextColor(Color.GRAY);
                    }
*/
                    for (int i = 0; i <listaRegionesLogin.size() ; i++) {
                        listaRegionesLogin.get(i).setEstado(false);
                    }

                    int a=  Integer.parseInt(radioButtonRegiones.getTag().toString());

                    listaRegionesLogin.get(a).setEstado(!listaRegionesLogin.get(a).getEstado());
                    onCompleteListener.onComplete(listaRegionesLogin.get(getPosition()));
                    notifyDataSetChanged();
                    // listaRegionesLogin.remove(a);
                    // notifyItemRemoved(a);

                }
            });

        }

        @Override
        public void onClick(View v) {
           // Toast.makeText(v.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();

        }
    }
}

