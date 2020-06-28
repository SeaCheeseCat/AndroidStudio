package com.example.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class winds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winds);
        final ActionBar supportActionBar = getSupportActionBar();
        ((Button)findViewById(R.id.kai)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
supportActionBar.show();

            }
        });

        ((Button)findViewById(R.id.guan)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supportActionBar.hide();

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();//实例化一个menuinflaster对象
        inflater.inflate(R.menu.menu,menu);//解析一个menu对象
        return super.onCreateOptionsMenu(menu);
    }
}
