package com.example.weiguangmeng.canvas;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.weiguangmeng.canvas.customs.FirePicView;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        final ImageView displayView = (ImageView) findViewById(R.id.display);
        final FirePicView fireView = (FirePicView) findViewById(R.id.fire_view);
        fireView.setDisplayView(displayView);
        fireView.setDrawingCacheEnabled(true);
        fireView.buildDrawingCache(true);
    }
}
