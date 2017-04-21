package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.CambVistaPrincipalFragment;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.ConfiguracionNavegacionFragment;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.NotifEmergenteFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificacionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        ButterKnife.bind(this);
    }
    @OnClick(R.id.idConfNotiEmerg)
    public void ConfNotificaEmerg()
    {

    }
    @OnClick(R.id.idCambiarVistaPrinc)
    public void CambiarVistaPrinc(){
        showInputDialogCambiarVistaPrincipal();
    }
    @OnClick(R.id.idConfNotiEmerg)
    public void ConfifNotifEmergen() {
        showInputDialogConfNotificacionEmergente();
    }

    @OnClick(R.id.idConfiguracionNavegacion)
    public void ConfNavegacion(){
        showInputDialogConfNavegacion();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
    }

    protected void showInputDialogCambiarVistaPrincipal() {

        CambVistaPrincipalFragment cambVistaPrincipalFragment = new CambVistaPrincipalFragment();
        cambVistaPrincipalFragment.show(getSupportFragmentManager(),"");
    }

    protected void showInputDialogConfNavegacion() {
        ConfiguracionNavegacionFragment confNavegacionFragment =  new ConfiguracionNavegacionFragment();
        confNavegacionFragment.show(getSupportFragmentManager(),"");
    }

    protected void showInputDialogConfNotificacionEmergente() {

        // get prompts.xml view
        NotifEmergenteFragment notifEmergenteFragment = new NotifEmergenteFragment();
        notifEmergenteFragment.show(getSupportFragmentManager(),"");
        //LayoutInflater layoutInflater = LayoutInflater.from(this);
        // View promptView = layoutInflater.inflate(R.layout.fragment_notif_emergente, null);
        // AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // alertDialogBuilder.setView(promptView);
        //
        // //  final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // // setup a dialog window
        // alertDialogBuilder.setCancelable(false)
        //         .setNegativeButton("CANCELAR",
        //                 new DialogInterface.OnClickListener() {
        //                     public void onClick(DialogInterface dialog, int id) {
        //                         dialog.cancel();
        //                     }
        //                 });
        //
        // // create an alert dialog
        // AlertDialog alert = alertDialogBuilder.create();
        // alert.show();
    }


}
