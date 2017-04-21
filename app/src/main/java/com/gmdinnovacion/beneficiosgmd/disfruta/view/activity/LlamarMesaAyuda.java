package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.PermisionChecker;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LlamarMesaAyuda extends AppCompatActivity {

    @BindView(R.id.email_llamar_in_button)
    Button llamar;

    @BindView(R.id.telefono)
    TextView telefono;

    @BindView(R.id.arrow_close_btn)
    ImageView arrowClose;


    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar_mesa_ayuda);
        activity=this;
        ButterKnife.bind(this);
        getSupportActionBar().hide();


        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().setNavigationBarColor(getResources().getColor(R.color.blue_toolbar));
//            getWindow().setStatusBarColor(getResources().getColor(R.color.blue_toolbar));
            llamar.setBackground(getResources().getDrawable(R.drawable.selector_boton_inferior_orange_sincurva));
        } else {
            llamar.setBackgroundColor(getResources().getColor(R.color.orange_button_dark));
        }

        arrowClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PermisionChecker.isCallPhoneAvaliable(getApplicationContext())) {
                    Uri numero = Uri.parse("tel:" + llamar.getText().toString().trim());
                    Intent intent = new Intent(Intent.ACTION_CALL, numero);
                    try {
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {

                    ActivityCompat.requestPermissions(activity,
                            new String[]{Manifest.permission.CALL_PHONE},
                            Constante.PERMISSIONS.MY_PERMISSIONS_CALL_PHONE);
                }
            }
        });

    }
}



//    public void llamar(View view) {
//        String llamarMesaAyuda = telefono.getText().toString().trim();
//        Log.v("oe", llamarMesaAyuda);
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE}, 144);
//        }else{
//            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + llamarMesaAyuda)));
//        }
//
//
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(requestCode==144){
//            llamar(llamar);
//        }
//    }
//}
