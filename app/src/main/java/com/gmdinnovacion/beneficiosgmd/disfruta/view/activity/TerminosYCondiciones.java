package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.DTO.CTermCondDTO;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TerminosYCondiciones extends AppCompatActivity {

    @BindView(R.id.email_aceptar_in_button)
    Button aceptar;
    @BindView(R.id.checkBox)
    AppCompatCheckBox checbox;
    @BindView(R.id.boton_toolbar_cerrar)
    ImageButton botonToolbarCerrar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_ycondiciones);

        ButterKnife.bind(this);
        getSupportActionBar().hide();
        context=this;

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            aceptar.setBackground(getResources().getDrawable(R.drawable.selector_boton_inferior_orange_sincurva));
        } else {
            aceptar.setBackgroundColor(getResources().getColor(R.color.orange_button_dark));
        }

        aceptar.setEnabled(false);
        aceptar.setBackgroundColor(Color.GRAY);

        checbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checbox.isChecked()){
                    aceptar.setEnabled(true);
                    if (Build.VERSION.SDK_INT >= 21) {
                        aceptar.setBackground(getResources().getDrawable(R.drawable.selector_boton_inferior_orange_sincurva));
                    } else {
                        aceptar.setBackgroundColor(getResources().getColor(R.color.orange_button_dark));
                    }
                } else {
                    aceptar.setEnabled(false);
                    aceptar.setBackgroundColor(Color.GRAY);
                }
            }
        });

        botonToolbarCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checbox.setChecked(false);
                llamar();

            }
        });
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamar();
            }
        });
    }

    private void llamar() {


        CTermCondDTO cTermCondDTO =new CTermCondDTO();
        if(checbox.isChecked()){
            cTermCondDTO.setChecked(true);
            EventBus.getDefault().postSticky(cTermCondDTO);
        }else{
            cTermCondDTO.setChecked(false);
            EventBus.getDefault().postSticky(cTermCondDTO);
        }
        finish();
    }

    @Override
    public void onBackPressed() {
        checbox.setChecked(false);
        llamar();
    }
}
