package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class two extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        ((Button)findViewById(R.id.button16)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(two.this,caipiao.class);
                startActivity(intent);
            }
    });
        ((Button)findViewById(R.id.button17)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(two.this,xml.class);
                startActivity(intent);
            }
        });


        ((Button)findViewById(R.id.button18)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(two.this,hua .class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.button19)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(two.this,donghua.class);
                startActivity(intent);
            }
        });
        ((Button)findViewById(R.id.button20)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(two.this,http.class);
                startActivity(intent);
            }
        });


        ((Button)findViewById(R.id.button21)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(two.this,Alertdialog.class);
                startActivity(intent);
            }
        });
}
}
