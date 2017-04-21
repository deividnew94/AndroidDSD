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

import static com.gmdinnovacion.beneficiosgmd.disfruta.R.id.rbgPantallaInicio;

public class CambVistaPrincipalFragment extends DialogFragment {
    //private RadioGroup rbgPantallaInicio;
    @BindView(rbgPantallaInicio)
    RadioGroup rgbPantallaInicio;

    @BindView(R.id.rbVerListas)
    RadioButton rbVerListas;

    @BindView(R.id.rbVerMapa)
    RadioButton rbVerMapa;

    @BindView(R.id.textCancelar)
    TextView textCancelar;


    public CambVistaPrincipalFragment() {
        // Required empty public constructor
        //
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_camb_vista_principal, container, false);
        ButterKnife.bind(this,v);
        rbVerListas.setChecked(true);

        return  v;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);

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

        rgbPantallaInicio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup group, int checkedId) {
                 if(checkedId == R.id.rbVerListas){
                     rbVerListas.setTextColor(getResources().getColor(R.color.black));
                     rbVerMapa.setTextColor(getResources().getColor(R.color.text_color));
                     //getDialog().dismiss();

                 }else{
                     rbVerListas.setTextColor(getResources().getColor(R.color.text_color));
                     rbVerMapa.setTextColor(getResources().getColor(R.color.black));
                     //getDialog().dismiss();
                 }
             }
            }
        );


    }
}
