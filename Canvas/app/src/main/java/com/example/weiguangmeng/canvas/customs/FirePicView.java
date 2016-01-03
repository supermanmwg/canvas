package com.example.weiguangmeng.canvas.customs;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by weiguangmeng on 16/1/3.
 */
public class FirePicView extends ViewGroup {
    private ImageView background;
    private ImageView foreground;
    private int fTop;
    private int fLeft;
    private int bTop;
    private int bLeft;

    public FirePicView(Context context) {
        this(context, null);
    }

    public FirePicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        background = new ImageView(getContext());
        background.setBackgroundColor(Color.BLACK);
        LinearLayout.LayoutParams blp = new LinearLayout.LayoutParams(300, 400);
        blp.setMargins(40, 40, 40, 40);
        addView(background, blp);

        foreground = new ImageView(getContext());
        foreground.setBackgroundColor(Color.BLUE);
        LinearLayout.LayoutParams flp = new LinearLayout.LayoutParams(300, 400);
        flp.setMargins(40, 40, 40, 40);
        addView(foreground, flp);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if(foreground != null) {
           measureChildWithMargins(foreground, widthMeasureSpec, 0, heightMeasureSpec, 0);
        }

        if(background != null) {
            measureChildWithMargins(background, widthMeasureSpec, 0, heightMeasureSpec, 0);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();

        if(foreground != null) {
            MarginLayoutParams lp = (MarginLayoutParams) foreground.getLayoutParams();
            int marginLeft = paddingLeft + lp.leftMargin;
            int marginTop = paddingTop + lp.topMargin;
            foreground.layout(marginLeft, marginTop,  marginLeft + foreground.getMeasuredWidth(), marginTop + foreground.getMeasuredHeight());
        }

        if(background != null) {
            MarginLayoutParams blp = (MarginLayoutParams)background.getLayoutParams();
            int marginLeft = paddingLeft + blp.leftMargin;
            int marginTop = paddingLeft + blp.topMargin;
            background.layout(
                    this.getMeasuredWidth() - background.getMeasuredWidth() - marginLeft,
                    this.getMeasuredHeight() - background.getMeasuredHeight() - marginTop,
                    this.getMeasuredWidth() - marginTop,
                    this.getMeasuredHeight() - marginTop);
        }

    }
}
