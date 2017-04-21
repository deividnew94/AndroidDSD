package com.gmdinnovacion.beneficiosgmd.disfruta.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;
import com.gmdinnovacion.beneficiosgmd.disfruta.domain.model.Slides;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.AppPreferences;
import com.gmdinnovacion.beneficiosgmd.disfruta.utiles.BuildConfig;
import com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter.AdapterSlide;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.gmdinnovacion.beneficiosgmd.disfruta.utiles.BuildConfig.GETSLIDE;

/**
 * Created by innovagmd on 30/11/16.
 */

public class SlideActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    CirclePageIndicator indicator;
    @BindView(R.id.omitir)
    TextView omitir;
    @BindView(R.id.bt_back)
    ImageButton btBack;
    @BindView(R.id.bt_next)
    Button btNext;
    List<Slides> items;

    private int position = 0;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        context=this;
        btBack.setVisibility(View.GONE);
        items= BuildConfig.GETSLIDE();
        viewPager.setAdapter(new AdapterSlide(this, items));
        viewPager.addOnPageChangeListener(this);
        indicator.setViewPager(viewPager);
        saveFlagOnboarding();

       // items= GETSLIDE();
        if (Build.VERSION.SDK_INT >= 21) {

            btNext.setBackground(getResources().getDrawable(R.drawable.selector_boton_inferior_orange_sincurva));
        } else {
            btNext.setBackgroundColor(getResources().getColor(R.color.orange_button_dark));
        }


    }

    @OnClick({R.id.omitir, R.id.bt_back, R.id.bt_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.omitir:
                //
                callActivity(PrincipalMapaActivity.class.getName());
                break;
            case R.id.bt_back:

                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                break;
            case R.id.bt_next:
                if(position == items.size()-1){
                    goToHistoriasActivity();
                  //  startActivity(new Intent(context,PrincipalMapaActivity.class));
                }else{
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        this.position=position;
        if(position==2){
            btNext.setText(getString(R.string.finalizar));
            omitir.setVisibility(View.GONE);
        }else{
            btNext.setText(getString(R.string.siguiente));
            omitir.setVisibility(View.VISIBLE);
        }
        if(position==0){
            btBack.setVisibility(View.GONE);
        }else{
            btBack.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void saveFlagOnboarding() {
        AppPreferences.getInstance(context).savePreference(AppPreferences.FLAG_ONBOARDING,true);
    }

    private void goToHistoriasActivity() {
        callActivity(PrincipalMapaActivity.class.getName());
        finish();
    }

    @Override
    public void onBackPressed() {
        // disable
    }

}
