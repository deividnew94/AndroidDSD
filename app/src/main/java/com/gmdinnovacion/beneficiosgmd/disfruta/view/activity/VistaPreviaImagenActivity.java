package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class VistaPreviaImagenActivity extends BaseActivity {


    @BindView(R.id.imagen_previa)
    ImageView imagen_previa;

    @BindView(R.id.close)
    ImageButton close;

    String url="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_previa_imagen);
        ButterKnife.bind(this);

        url =getIntent().getExtras().getString("url_imagen");

        Picasso.with(getApplicationContext()).load(url).into(imagen_previa);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

}
