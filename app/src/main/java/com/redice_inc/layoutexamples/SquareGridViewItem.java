package com.redice_inc.layoutexamples;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SquareGridViewItem extends ImageView {

    public SquareGridViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
