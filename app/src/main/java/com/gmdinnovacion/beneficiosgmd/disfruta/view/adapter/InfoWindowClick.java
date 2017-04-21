package com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Point;

import java.util.List;


/**
 * Created by innovagmd on 12/09/16.
 */

public class InfoWindowClick {
  // public class InfoWindowClick implements GoogleMap.InfoWindowAdapter {
        LayoutInflater mInflater;
        Context contexto;
        public InfoWindowClick(LayoutInflater i, List<Point> a, Context context){
            mInflater = i;
            contexto=context;
        }

//        @Override
//        public View getInfoContents(Marker marker) {
//            // Getting view from the layout file
//            marker.getId();
//            View v = mInflater.inflate(R.layout.custom_info_window_map, null);
//            // Populate fields
//            ImageView image = (ImageView) v.findViewById(R.id.badge);
//
//            User user = usuarioRepositorio.getUsuario(contexto);
//            ////foto
//            TextView title = (TextView) v.findViewById(R.id.title);
//            if(user.getTipoUsuario().equalsIgnoreCase("U")){
//                Profile profileDefault = Profile.getCurrentProfile();
//                if(profileDefault!=null)
//                    Picasso.with(contexto).load(profileDefault.getProfilePictureUri(100, 100)).transform(new CircleTransform()).into(image);
//               // lyCambiarContrasena.setVisibility(View.GONE);
//                title.setText(user.getNombres());
//            }else{
//                title.setText(user.getNombres()+" "+user.getApellidoPaterno()+" "+user.getApellidoMaterno());
//            }
//
//
//
//
//
//            TextView description = (TextView) v.findViewById(R.id.snippet);
//            if(user.getNroPlaca()==null||user.getNroPlaca().trim().equalsIgnoreCase("")){
//                description.setText(user.getUsuario());
//            }else{
//                description.setText(user.getNroPlaca());
//            }
//
//
//        // Return info window contents
//        return v;
//        }
//        @Override
//        public View getInfoWindow(Marker marker) {
//            return null;
//        }
    }