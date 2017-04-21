package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.User;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.request.LoginRequest;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.ro.response.LoginResponse;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.UserService;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.business.impl.UserServiceImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.UserDAO;
import com.gmdinnovacion.beneficiosgmd.disfruta.services.dao.impl.UserDAOImpl;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AndroidApplication;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.LoginActivity;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.activity.NotificacionesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by avermes on 06/12/2016.
 */
public class UsuarioFragment extends Fragment {
    AlertDialog alert = null;
    @BindView(R.id.ly_cerrar_session)
    LinearLayout cerrarSesion;
    @BindView(R.id.lnrConfigNotificaciones)
    LinearLayout lnrConfigNotificaciones;
    @BindView(R.id.txt_nombre)
    TextView textNombre;
    @BindView(R.id.txt_apellido)
    TextView textApellido;
    @BindView(R.id.txt_dni)
    TextView textDNI;
    @BindView(R.id.txt_celular)
    TextView textCelular;


    Context context;
    String tipoUsuario;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onResume() {
        super.onResume();
        //tipoUsuario = getArguments().getString("tipoUsuario");
        //tipoUsuario = getArguments().getString("2");
        tipoUsuario = getArguments().getString("tipoUsuario");
    }

    public UsuarioFragment() {
        // Required empty public constructor

    }


    // TODO: Rename and change types and number of parameters
    public static UsuarioFragment newInstance(String tipoUsuario) {
        Bundle args = new Bundle();
        UsuarioFragment fragment = new UsuarioFragment();
        args.putString("tipoUsuario", tipoUsuario);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragmemt_usuario, container, false);
        ButterKnife.bind(this, view);

        UserDAO userDAO = new UserDAOImpl();
        User a = userDAO.getCurrentUser();


        textNombre.setText(a.getNomUsuario());
        textApellido.setText(a.getApeUsuario());
        textDNI.setText(a.getNumDni());
        textCelular.setText(a.getNumCelular());
        return view;

    }


    @OnClick({R.id.ly_cerrar_session})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ly_cerrar_session:
                //AlertClose();
                showDialogCloseSessionConfirmation();
                break;

        }
    }

//    private void AlertClose() {
//        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.YourDialogStyle);
//        builder.setMessage("¿Desea cerrar sesión?")
//                .setCancelable(false)
//                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
//
//                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
//
//                        startActivity(new Intent(getActivity(), LoginActivity.class));
//                        getActivity().finish();
//
//                    }
//                })
//                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
//                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
//                        dialog.cancel();
//
//                    }
//                });
//        alert = builder.create();
//        alert.show();
//    }

    public void showDialogCloseSessionConfirmation() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity(), R.style.YourDialogStyle);
        alertDialog.setTitle(R.string.titleDialog);
        alertDialog.setMessage(R.string.closeSessionConfirmation);
        alertDialog.setPositiveButton(R.string.yesDialog,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        removeTokenFCM();
//                        SharedPreferences pref = getActivity().getSharedPreferences("MyPref", 0);
//                        SharedPreferences.Editor editor = pref.edit();
//                        editor.clear();
//                        editor.commit();
                        AndroidApplication.getInstance().clearBeneficioLista();

                        UserDAO userDao = new UserDAOImpl();
                        userDao.logout();

                        startActivity(new Intent(getActivity(),LoginActivity.class));
//                finish();

                    }
                });
        alertDialog.setNegativeButton(R.string.notDialog,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        alertDialog.show();
    }

    @OnClick(R.id.lnrConfigNotificaciones)
    public void onClick() {
        Intent intNotAct = new Intent(getActivity(),NotificacionesActivity.class);
        startActivity(intNotAct);
    }
}
