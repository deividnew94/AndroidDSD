package com.gmdinnovacion.beneficiosgmd.disfruta.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by tincio on 16/12/2015.
 */

public class CustomMapFragment extends SupportMapFragment {

    private View mOriginalView;
    private MapWrapperLayout mMapWrapperLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mOriginalView = super.onCreateView(inflater, container, savedInstanceState);

        mMapWrapperLayout = new MapWrapperLayout(getActivity());
        mMapWrapperLayout.addView(mOriginalView);

        return mMapWrapperLayout;
    }

    @Override
    public View getView() {
        return mOriginalView;
    }

    public void setOnDragListener(MapWrapperLayout.OnDragListener onDragListener) {
        mMapWrapperLayout.setOnDragListener(onDragListener);
    }

    public static class MapWrapperLayout extends FrameLayout {

        public interface OnDragListener {
            public void onDrag(MotionEvent motionEvent);
        }

        private OnDragListener mOnDragListener;

        public MapWrapperLayout(Context context) {
            super(context);
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            if (mOnDragListener != null) {
                mOnDragListener.onDrag(ev);
            }
            return super.dispatchTouchEvent(ev);
        }

        public void setOnDragListener(OnDragListener mOnDragListener) {
            this.mOnDragListener = mOnDragListener;
        }
    }
}
