package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Empresa;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.LoginResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.BandejaBeneficioListaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.EmpresaService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.FcmTokenService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.ParametricService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.UserService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.BandejaBeneficioListaImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.EmpresaImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.FcmTokenServiceImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.ParametricServiceImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.UserServiceImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.UserDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.BuildConfig;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.Constante;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment.DisfrutaMapFragment;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.builder.AnimateGifMode;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {

    private TimerTask splash_task_parametric;
    private TimerTask splash_task;
    private Timer timer;
    private Context ctx;

//    private FcmTokenService deviceService = new FcmTokenServiceImpl();
    // private UserService userService = new UserServiceImpl();
    private ParametricService parametricService = new ParametricServiceImpl();

    private int screenWidth;
    private AnimatorSet windowsAnimatorSet;
    private TextView windowsTvOne;
    private TextView windowsTvThree;
    private TextView windowsTvTwo;
    private static final boolean AUTO_HIDE = true;

    Display display;
    int width;
    float widthFloat;
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();


    @BindView(R.id.imageView)
    ImageView logoApp;
    //    LocationManager manager;
    private View mControlsView;
    private boolean mVisible;

//    Integer.toString(display.getWidth());

    UserDAO userDAO = new UserDAOImpl();
    User userCurrent = userDAO.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        widthFloat = (float) width;
        ImageView imgView = (ImageView) findViewById(R.id.imageView);

        ctx=this;
        mVisible=true;
        timer = new Timer("SplashTimer",true);

        cargarEmpresas();

        mControlsView = findViewById(R.id.fullscreen_content_controls);
        windowsTvOne  = (TextView)findViewById(R.id.windowsTvOne);
        windowsTvTwo  = (TextView)findViewById(R.id.windowsTvTwo);
        windowsTvThree=(TextView)findViewById(R.id.windowsTvThree);

        windowsTvOne.setVisibility(View.GONE);
        windowsTvTwo.setVisibility(View.GONE);
        windowsTvThree.setVisibility(View.GONE);

        if (BuildConfig.IMG_GIF != R.drawable.ic_arrow_back_black_24dp) {
            Ion.with(imgView)
                    //.error(R.drawable.default_image)
                    .animateGif(AnimateGifMode.ANIMATE)
                    .load("android.resource://" + getPackageName() + "/" + BuildConfig.IMG_GIF)
                    .withBitmapInfo();
        } else {
            imgView.setVisibility(View.GONE);
        }

        /** En caso se configure data maestra y deba descargarse al inicio **/
        splash_task_parametric = new TimerTask() {
            @Override
            public void run() {
                if (parametricService.isEmpty()) { // first time
                    ((AppCompatActivity) ctx).runOnUiThread(new Runnable() {
                        public void run() {
                            showProgressDialog("Estamos configurando la aplicación");
                        }
                    });
                    getParametricData();
                } else {
                    updateParametricData();
                    checkGCM();
                    goToNextActivity();
                }
            }
        };

        /** En caso sólo sea necesario actualizar token de notificación **/
        splash_task = new TimerTask() {
            @Override
            public void run() {
                checkGCM();
                goToNextActivity();
            }
        };

        timer.schedule(splash_task, Constante.SPLASH_DELAY);

        windowsAnimation();

        if (!verificaConexion(this)) {
            Toast.makeText(getBaseContext(),
                    "Comprueba tu conexión a Internet. Saliendo ... ", Toast.LENGTH_SHORT)
                    .show();
            this.finish();
        }

    }

    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };

    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    seleccionarActivityAMostrar();
                }
            }
        };
        timerThread.start();

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }


    public void seleccionarActivityAMostrar() {
//        call("");

        if(userCurrent != null){
            goToMain();
        } else {
            goToLogin();
        }


    }

//    public void call(String response){
//
//        callActivity(LoginActivity.class.getName());
////        Intent i = new Intent(this, LoginActivity.class);
////        startActivity(i);
//        finish();
//
//
//    }


    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay

        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }



    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */

    private void getParametricData(){
        parametricService.getParametricFromWebService(ctx,"parametricCallback");
    }

    private void updateParametricData(){
        parametricService.updateParametricFromWebService(ctx);
    }

    private void checkGCM(){
//        FcmToken device = deviceService.getDevice();
        //User user = userService.getCurrentUser();
        //if(device != null && device.getState() == 0 && user != null) // token no enviado y usuario en sesión
            //deviceService.sendRegistrationToServer(device.getGcmId(),user.getCodigoUsuario());
    }

    /** Redirection Methods **/
    private void goToNextActivity(){
//        if(userService.getCurrentUser() != null)
//            goToMain();
//        else
//            goToLogin();
    }
    private void goToLogin(){

        callActivity(LoginActivity.class.getName());
        //  Intent i = new Intent(SplashActivity.this , LoginActivity.class);
        // startActivity(i);
        finish();
    }
    private void goToMain(){
        callActivity(PrincipalMapaActivity.class.getName());
    }

    public void cargarEmpresas() {
        EmpresaService empresaService = new EmpresaImpl();
        empresaService.cargarEmpresas(ctx);
    }


    /** Redirection Methods **/

       /*Animacion*/



    public void windowsAnimation() {



        final ValueAnimator valueTvOne_x = ObjectAnimator.ofFloat(windowsTvOne, "x", windowsTvOne.getX() - 50,// windowsTvOne.getX() - 50, //(screenWidth / 2) + 10f, (screenWidth / 2) + 25f,
                // (screenWidth / 2) +50f,
                (screenWidth / 2)+(-100f),(screenWidth / 2)+(widthFloat/2),(screenWidth/2 )+ widthFloat//,(screenWidth / 2) +30f, (screenWidth / 2)+35f,(screenWidth / 2)+40f,(screenWidth / 2)+45f ,(screenWidth / 2)+6.6f,(screenWidth / 2)+7.7f,(screenWidth / 2)+8.8f , (screenWidth / 2)+9,(screenWidth / 2)+10
                , screenWidth * .92f, screenWidth + (-100f));

        valueTvOne_x.setDuration(1000);
        valueTvOne_x.setRepeatCount(0);
        valueTvOne_x.setRepeatMode(ValueAnimator.REVERSE);

        valueTvOne_x.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                windowsTvOne.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

        final ValueAnimator valueTvTwo_x = ObjectAnimator.ofFloat(windowsTvTwo, "x", windowsTvTwo.getX() - 50,
                //(screenWidth / 2.1f) + 10f, (screenWidth / 2.1f) + 25f, (screenWidth / 2.1f) + 50f,
                (screenWidth / 2)+(-100f),(screenWidth / 2)+(widthFloat/2),(screenWidth/2 )+widthFloat//, (screenWidth / 2.1f) +80f, (screenWidth / 2.1f) +25f,(screenWidth / 2.1f) +30f
                , screenWidth * .94f, screenWidth +(-100f));

        valueTvTwo_x.setDuration(1500);
        valueTvTwo_x.setRepeatCount(0);
        valueTvTwo_x.setStartDelay(20);
        valueTvTwo_x.setRepeatMode(ValueAnimator.REVERSE);

        valueTvTwo_x.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                windowsTvTwo.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

        final ValueAnimator valueTvThree_x = ObjectAnimator.ofFloat(windowsTvThree, "x", windowsTvThree.getX() - 50, //(screenWidth / 2.2f) + 10f, (screenWidth / 2.2f) + 25f,
                (screenWidth / 2)+(-100f),(screenWidth / 2)+(widthFloat/2),(screenWidth/2 )+widthFloat//,(screenWidth / 2.2f) +55f,(screenWidth / 2.2f) +80f,(screenWidth / 2.2f) +25f,(screenWidth / 2.2f) +30f
                , screenWidth * .94f, screenWidth + (-100f));

        valueTvThree_x.setDuration(2000);
        valueTvThree_x.setRepeatCount(0);
        valueTvTwo_x.setStartDelay(40);
        valueTvThree_x.setRepeatMode(ValueAnimator.REVERSE);

        valueTvThree_x.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                windowsTvThree.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

        windowsAnimatorSet = new AnimatorSet();
        windowsAnimatorSet.playTogether(valueTvTwo_x, valueTvThree_x, valueTvOne_x);

        windowsAnimatorSet.start();
        windowsAnimatorSet.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                windowsAnimatorSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }
        });

    }

    public static boolean verificaConexion(Context ctx) {
        boolean bConectado = false;
        ConnectivityManager connec = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // No sólo wifi, también GPRS
        NetworkInfo[] redes = connec.getAllNetworkInfo();
        // este bucle debería no ser tan ñapa
        for (int i = 0; i < 2; i++) {
            // ¿Tenemos conexión? ponemos a true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                bConectado = true;
            }
        }
        return bConectado;
    }

//       /*LOCATIO MAP DISFRUTA*/
//
//    public void location() {
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//        }
//
//    }
//    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        BandejaBeneficioListaService bandejaServiceF = new BandejaBeneficioListaImpl();
//        switch (requestCode) {
//            case MY_PERMISSIONS_REQUEST_LOCATION: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                    if (requestCode == 1) {
//                       location();
//                    }
//
//                    LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//                    Location location=null;
//
//                    if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_FINE_LOCATION)
//                            == PackageManager.PERMISSION_GRANTED) {
//
//                        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//                        bandejaServiceF.CargarBeneficioLista(ctx, location.getLatitude(), location.getLongitude());
//
//                    }
//                    // permission was granted, yay! Do the
//                    // contacts-related task you need to do.
//
//                } else {
//                    bandejaServiceF.CargarBeneficioLista(ctx, 0.0, 0.0);
//                    Toast.makeText(ctx, "Sin coordenadas ", Toast.LENGTH_SHORT).show();
//                    // permission denied, boo! Disable the
//                    // functionality that depends on this permission.
//                }
//                return;
//            }
//
//            // other 'case' lines to check for other
//            // permissions this app might request
//        }
//
//    }



//    private void checkLocationPermission() {
//        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            // Should we show an explanation?
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION)) {
//
//                // Show an explanation to the user *asynchronously* -- don't block
//                // this thread waiting for the user's response! After the user
//                // sees the explanation, try again to request the permission.
//                new AlertDialog.Builder(ctx)
//                        .setTitle("Location Permission Needed")
//                        .setMessage("This app needs the Location permission, please accept to use location functionality")
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                //Prompt the user once explanation has been shown
//                                ActivityCompat.requestPermissions(SplashActivity.this,
//                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                                        MY_PERMISSIONS_REQUEST_LOCATION );
//                            }
//                        })
//                        .create()
//                        .show();
//
//
//            } else {
//                // No explanation needed, we can request the permission.
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                        MY_PERMISSIONS_REQUEST_LOCATION );
//            }
//        }
//    }



}