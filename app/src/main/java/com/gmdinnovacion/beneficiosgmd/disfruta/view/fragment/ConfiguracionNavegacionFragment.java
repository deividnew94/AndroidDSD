package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ConfiguracionNavegacionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ConfiguracionNavegacionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfiguracionNavegacionFragment extends DialogFragment {
    @BindView(R.id.rbgNavegarCon)
    RadioGroup rbgNavegarCon;

    @BindView(R.id.rbGoogleMaps)
    RadioButton rbGoogleMaps;

    @BindView(R.id.rbWaze)
    RadioButton rbWaze;

    @BindView(R.id.rbInternet)
    RadioButton rbInternet;

    @BindView(R.id.rbGoogleChrome)
    RadioButton rbGoogleChrome;

    @BindView(R.id.textCancelar)
    TextView textCancelar;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ConfiguracionNavegacionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfiguracionNavegacionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfiguracionNavegacionFragment newInstance(String param1, String param2) {
        ConfiguracionNavegacionFragment fragment = new ConfiguracionNavegacionFragment();
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
        setStyle(STYLE_NO_TITLE,0);

    }

    @Override
    public void onResume(){
        super.onResume();

        textCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });



        rbgNavegarCon.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbGoogleMaps){
                    rbGoogleMaps.setTextColor(getResources().getColor(R.color.black));
                    rbWaze.setTextColor(getResources().getColor(R.color.text_color));
                    rbInternet.setTextColor(getResources().getColor(R.color.text_color));
                    rbGoogleChrome.setTextColor(getResources().getColor(R.color.text_color));
                    //getDialog().dismiss();
                }else if(checkedId == R.id.rbWaze){
                    rbGoogleMaps.setTextColor(getResources().getColor(R.color.text_color));
                    rbWaze.setTextColor(getResources().getColor(R.color.black));
                    rbInternet.setTextColor(getResources().getColor(R.color.text_color));
                    rbGoogleChrome.setTextColor(getResources().getColor(R.color.text_color));
                    //getDialog().dismiss();
                }else if(checkedId == R.id.rbInternet){
                    rbGoogleMaps.setTextColor(getResources().getColor(R.color.text_color));
                    rbWaze.setTextColor(getResources().getColor(R.color.text_color));
                    rbInternet.setTextColor(getResources().getColor(R.color.black));
                    rbGoogleChrome.setTextColor(getResources().getColor(R.color.text_color));
                    //getDialog().dismiss();
                }else if(checkedId == R.id.rbGoogleChrome){
                    rbGoogleMaps.setTextColor(getResources().getColor(R.color.text_color));
                    rbWaze.setTextColor(getResources().getColor(R.color.text_color));
                    rbInternet.setTextColor(getResources().getColor(R.color.text_color));
                    rbGoogleChrome.setTextColor(getResources().getColor(R.color.black));
                    //getDialog().dismiss();
                }

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_configuracion_navegacion, container, false);
        ButterKnife.bind(this,v);
        rbGoogleMaps.setChecked(true);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
