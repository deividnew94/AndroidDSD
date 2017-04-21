package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotifEmergenteFragment extends DialogFragment {
    @BindView(R.id.textCancelar)
    TextView textCancelar;

    @BindView(R.id.rbgNotificacionEmergente)
    RadioGroup rbgNotificacionEmergente;

    @BindView(R.id.rbNuncaMostrar)
    RadioButton rbNuncaMostrar;

    @BindView(R.id.rbPantallaEncendida)
    RadioButton rbPantallaEncendida;

    @BindView(R.id.rbPantallaApagada)
    RadioButton rbPantallaApagada;

    @BindView(R.id.rbMostrarVentanaEmergente)
    RadioButton rbMostrarVentanaEmergente;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public NotifEmergenteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotifEmergenteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotifEmergenteFragment newInstance(String param1, String param2) {
        NotifEmergenteFragment fragment = new NotifEmergenteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setStyle(STYLE_NO_TITLE, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notif_emergente, container, false);
        ButterKnife.bind(this,v);
        rbNuncaMostrar.setChecked(true);
        return  v;

    }


    @Override
    public void onResume() {
        super.onResume();

        textCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        rbgNotificacionEmergente.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (checkedId == R.id.rbNuncaMostrar){
                    rbNuncaMostrar.setTextColor(getResources().getColor(R.color.black));
                    rbPantallaEncendida.setTextColor(getResources().getColor(R.color.text_color));
                    rbPantallaApagada.setTextColor(getResources().getColor(R.color.text_color));
                    rbMostrarVentanaEmergente.setTextColor(getResources().getColor(R.color.text_color));
                    //getDialog().dismiss();
                }else if (checkedId == R.id.rbPantallaEncendida){
                    rbNuncaMostrar.setTextColor(getResources().getColor(R.color.text_color));
                    rbPantallaEncendida.setTextColor(getResources().getColor(R.color.black));
                    rbPantallaApagada.setTextColor(getResources().getColor(R.color.text_color));
                    rbMostrarVentanaEmergente.setTextColor(getResources().getColor(R.color.text_color));
                    //getDialog().dismiss();
                }else if (checkedId == R.id.rbPantallaApagada){
                    rbNuncaMostrar.setTextColor(getResources().getColor(R.color.text_color));
                    rbPantallaEncendida.setTextColor(getResources().getColor(R.color.text_color));
                    rbPantallaApagada.setTextColor(getResources().getColor(R.color.black));
                    rbMostrarVentanaEmergente.setTextColor(getResources().getColor(R.color.text_color));
                    //getDialog().dismiss();
                }else if(checkedId == R.id.rbMostrarVentanaEmergente){
                    rbNuncaMostrar.setTextColor(getResources().getColor(R.color.text_color));
                    rbPantallaEncendida.setTextColor(getResources().getColor(R.color.text_color));
                    rbPantallaApagada.setTextColor(getResources().getColor(R.color.text_color));
                    rbMostrarVentanaEmergente.setTextColor(getResources().getColor(R.color.black));
                    //getDialog().dismiss();
                }
            }
        });
    }

//        public void changeColor(View v)
//        {
//            //require to import the RadioButton class
////            RadioButton rb1 = (RadioButton) findViewById(R.id.Radio_Windows_Phone);
////            RadioButton rb2 = (RadioButton) findViewById(R.id.Radio_IOS);
////            RadioButton rb3 = (RadioButton) findViewById(R.id.Radio_Android);
//
//            //is the current radio button now checked?
//            boolean  checked = ((RadioButton) v).isChecked();
//
//            //now check which radio button is selected
//            //android switch statement
//            switch(v.getId()){
//
//                case R.id.rbNuncaMostrar:
//                    if(checked)
//                        rbNuncaMostrar.setBackgroundColor(Color.RED);
//                    break;
//
//                case R.id.rbPantallaEncendida:
//                    if(checked)
//                        rbNuncaMostrar.setBackgroundColor(Color.GRAY);
//                    break;
//
//                case R.id.rbPantallaApagada:
//                    if(checked)
//                        rbNuncaMostrar.setBackgroundColor(Color.GRAY);
//                    break;
//
//                case R.id.rbMostrarVentanaEmergente:
//                    if(checked)
//                        rbNuncaMostrar.setBackgroundColor(Color.GRAY);
//                    break;
//            }
//        }
}
