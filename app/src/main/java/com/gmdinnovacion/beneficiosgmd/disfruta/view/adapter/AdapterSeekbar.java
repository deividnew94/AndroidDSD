package com.gmdinnovacion.beneficiosgmd.disfruta.view.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

/**
 * Created by avermes on 17/01/2017.
 */

public class AdapterSeekbar extends CrystalRangeSeekbar{

    public AdapterSeekbar(Context context) {
        super(context);
    }

    public AdapterSeekbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdapterSeekbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected float getMinValue(TypedArray typedArray) {
        return 5f;
    }

    @Override
    protected float getMaxValue(TypedArray typedArray) {
        return 90f;
    }

    @Override
    protected float getMinStartValue(TypedArray typedArray) {
        return 20f;
    }

    @Override
    protected int getBarColor(TypedArray typedArray) {
        return Color.parseColor("#A0E3F7");
    }

    @Override
    protected int getBarHighlightColor(TypedArray typedArray) {
        return Color.parseColor("#53C9ED");
    }

    @Override
    protected int getLeftThumbColor(TypedArray typedArray) {
        return Color.parseColor("#058EB7");
    }

    @Override
    protected int getLeftThumbColorPressed(TypedArray typedArray) {
        return Color.parseColor("#046887");
    }

}
