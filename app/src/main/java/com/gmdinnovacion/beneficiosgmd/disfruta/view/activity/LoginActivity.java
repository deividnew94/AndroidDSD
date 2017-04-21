package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.DTO.CTermCondDTO;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Empresa;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.RegionesLogin;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.UserBean;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.BaseResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.LoginResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.EmpresaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.UserService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.EmpresaImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.UserServiceImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.EmpresaDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.EmpresaDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.UserDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.RegionesLoginFragment;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.EmpresaRequest;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.EmpresaResponse;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.data;
import static android.R.attr.id;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {// implements LoaderCallbacks<Cursor>

    @BindView(R.id.login_progress)
    ProgressBar mProgressView;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
    @BindView(R.id.terminos_y_condiciones)
    AppCompatCheckBox terminosYCondiciones;
    @BindView(R.id.olvideMiContraseña)
    TextView olvideMiContraseña;
    @BindView(R.id.txt_ver_terminocondiciones)
    TextView txtVerTerminocondiciones;
    @BindView(R.id.combo_empresas)
    LinearLayout comboEmpresas;
    @BindView(R.id.txt_empresa)
    TextView txtEmpresa;
    @BindView(R.id.txt_usuario)
    EditText txtUsuario;
    @BindView(R.id.txt_password)
    EditText password;
    Context ctx;
    List<Empresa> empresas;
    private UserDAO userDAO = new UserDAOImpl();

    private static final int SECOND_ACTIVITY_RESULT_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ctx = this;
        EmpresaDAOImpl empresaDAO =new EmpresaDAOImpl();
        empresas = empresaDAO.getAllEmpresasName();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        location();
        setTheme(R.style.AppTheme);

        //Traer Nombre de Empresas

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.blue_toolbar));
            getWindow().setStatusBarColor(getResources().getColor(R.color.blue_toolbar));
            emailSignInButton.setBackground(getResources().getDrawable(R.drawable.selector_boton_inferior_orange));
        } else {
            emailSignInButton.setBackgroundColor(getResources().getColor(R.color.orange_button_dark));
        }

        olvideMiContraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToOlvidarContrasena();
            }
        });

        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    emailSignInButton.performClick();
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick({R.id.combo_empresas, R.id.olvideMiContraseña, R.id.terminos_y_condiciones, R.id.txt_ver_terminocondiciones, R.id.txt_password, R.id.email_sign_in_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.combo_empresas:

                comboEmpresas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        showInputDialog(empresas);
                    }
                });
                break;
            case R.id.olvideMiContraseña:
                break;
            case R.id.terminos_y_condiciones:


                break;
            case R.id.txt_ver_terminocondiciones:
                callActivity(TerminosYCondiciones.class.getName());
                break;
            case R.id.txt_password:
                //event textRecuperar clave
                break;
            case R.id.email_sign_in_button:

                if(validar()){
                    UserService loginService = new UserServiceImpl();
                    String usuario           = txtUsuario.getText().toString();
                    String contrasenna       = password.getText().toString();

                    int id_empresa_actual    = 0 ;
                    String name_empresa      = txtEmpresa.getText().toString();

                    EmpresaDAO empresaDAO = new EmpresaDAOImpl();

                    ArrayList<Empresa> listEmpresas = (ArrayList<Empresa>) empresaDAO.getAllEmpresasName();

                    for (int i=0;i<listEmpresas.size();i++){
                        String emp = listEmpresas.get(i).getNomEmpresa().toString();
                        if (emp.equalsIgnoreCase(name_empresa)){
                            id_empresa_actual = listEmpresas.get(i).getIdEmpresa();
                            break;
                        }
                    }


                    loginService.login(ctx ,id_empresa_actual, usuario,contrasenna);
                }
//                String nusuario = String.valueOf(usuario.getText());
//                String contrasenna = "";
//                contrasenna = String.valueOf(password.getText());
//
//                submitForm(nusuario, contrasenna);
//                callActivity(PrincipalMapaActivity.class.getName());

                break;
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void LoginCorrecto(UserBean response) {

        //Guradar a la BD

       // if (response.getApeUsuario() != null){

            User usuario = new User();

            usuario.setIdUsuario(response.getIdUsuario());
//            usuario.setEmpresa(response.getEmpresa());
            usuario.setLogiUsuario(response.getLogiUsuario());
            usuario.setApeUsuario(response.getApeUsuario());
            usuario.setNomUsuario(response.getNomUsuario());
            usuario.setNumDni(response.getNumDni());
            usuario.setNumCelular(response.getNumCelular());
            usuario.setImgUsuario(response.getImgUsuario());

            userDAO.insert(usuario);
            User mUser= userDAO.getCurrentUser();
            Log.i("datos ", mUser.getNomUsuario());

           // callActivity(PrincipalMapaActivity.class.getName());

        callActivity(SlideActivity.class.getName());
        finish();
       // }else{


       // }

    }


    /*Validar Login*/

    private boolean validar() {

        if (!validateName()) {
            return false;
        }
        if (!validatePassword()) {
            return false;
        }
        if(!(validateTerminosyCondiciones())){
            return false;
        }
        return  true;
    }

    private boolean validateName() {

        if(txtUsuario.getText().length()<=0){
            toastShow(R.string.usuario_requerido);
            txtUsuario.requestFocus();
            return false;
        }
       return true;
    }

    private boolean validatePassword() {
        if(password.getText().length()<=0){
            toastShow(R.string.contraseña_requerida);
            password.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validateTerminosyCondiciones() {

        if(!(terminosYCondiciones.isChecked())){
            toastShow(R.string.tYc_requerida);
            return false;
        }
        return true;
    }

    private void goToOlvidarContrasena(){
        callActivity(LlamarMesaAyuda.class.getName());
    }

    protected void showInputDialog(List<Empresa> empresa) {

        RegionesLoginFragment fragment = RegionesLoginFragment.newInstance(empresa);
        fragment.setClicck(new RegionesLoginFragment.OnCompleteListener() {
            @Override
            public void onComplete(RegionesLogin time) {
                txtEmpresa.setText(time.getNombreEmpresa());
            }
        });
        fragment.show(getSupportFragmentManager(),"");
    }

    /*LOCATIO MAP DISFRUTA*/

    public void location() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            location();
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.BACKGROUND)
    public void ChecKTerminosCondiciones(CTermCondDTO response) {
        //  callActivity(MainActivity.class.getName());
        terminosYCondiciones.setChecked(response.getChecked());
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(String response) {
        toastShow(response);
    }

    /*SALID DE DISFRUTA*/


    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            salir();
        } else {
            Toast.makeText(getBaseContext(), "Por favor, haga clic en ATRÁS para salir.", Toast.LENGTH_SHORT).show();
        }

        mBackPressed = System.currentTimeMillis();
    }

    public void salir() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        } else {
            ActivityCompat.finishAffinity(this);
        }
    }

    public int getFlagOnboarding() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getInt("flag_onboarding", 0);
    }
    private void goToOnboarding() {
        callActivity(SlideActivity.class.getName());
//        Intent intent;
//        intent = new Intent(this, SlideActivity.class);
//        startActivity(intent);
        finish();
    }
}

