package com.example.raportHDPro.data;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Spinner;

public class MySpinner extends androidx.appcompat.widget.AppCompatSpinner {
    public MySpinner(Context context) {
        super(context);
    }

    public MySpinner(Context context, int mode) {
        super(context, mode);
    }

    public MySpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MySpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    @Override
    public void addView(View child, int index) {

    }

    @Override
    public void removeView(View child) {

    }
}
