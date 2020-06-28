package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class hua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hua);
        FrameLayout frameLayout = findViewById(R.id.fragment);
        frameLayout.addView(new huaview(this));//将帧布局添加到自定义view去


    }
}
