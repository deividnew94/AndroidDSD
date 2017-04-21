package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.gmdinnovacion.beneficiosgmd.disfruta.R;

import java.util.ArrayList;
import java.util.List;

public class TabsPushMensajeT extends Fragment {

    Context ctx;
    TabLayout tabLayout;
    String tipo;
    ViewPager viewPager;
    List<Fragment> fragments = new ArrayList<>();
    //public  Context context;
    //String tipoPushMensaje;
    //private final static String TAG = TabPushMensaje.class.getSimpleName();
    View inflatedView;

    ////////////////////////////////////


    public static TabsPushMensajeT newInstance(String tipo) {

        Bundle args = new Bundle();

        args.putString("tipo", tipo);

        TabsPushMensajeT fragment = new TabsPushMensajeT();
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public TabsPushMensajeT() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        inflatedView = inflater.inflate(R.layout.fragment_tabs_push_mensaje, container, false);
        ctx = getActivity();
        tipo = getArguments().getString("tipo");
        fragments.add(NotificacionesPushMensajeFragment.newInstance("push"));
        fragments.add(NotificacionesMensajeFragment.newInstance("1"));


        tabLayout = (TabLayout) inflatedView.findViewById(R.id.tabsPM);

        viewPager = (ViewPager) inflatedView.findViewById(R.id.viewPagerTab);

        /*CREAE TABS TITLE PUSH  // MENSAJE*/
        tabLayout.addTab(tabLayout.newTab().setText("PUSH"));
        tabLayout.addTab(tabLayout.newTab().setText("MENSAJE"));

        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), tabLayout.getTabCount(), fragments));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }
        });

        /*CREATE TABS PUSH MENSAJE*/
        return inflatedView;
    }

    public class PagerAdapter extends FragmentPagerAdapter {
        int mNumOfTabs;
        List<Fragment> fragments;


        public PagerAdapter(FragmentManager fm, int NumOfTabs, List<Fragment> fragments) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
            this.fragments = fragments;
        }


        @Override
        public Fragment getItem(int position) {
            return  fragments.get(position);
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}