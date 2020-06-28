package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class wexindemo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.wechat);
        Button button=findViewById(R.id.py);
        Button button2=findViewById(R.id.lt);
        Button button3=findViewById(R.id.pyq);
button.setOnClickListener(l);
        button2.setOnClickListener(l);
        button3.setOnClickListener(l);

       

    }

    View.OnClickListener l=new View.OnClickListener()
    {

        @Override
        public void onClick(View v) {
            FragmentManager f=getSupportFragmentManager();
            FragmentTransaction ft=f.beginTransaction();
            Fragment f1=null;
            switch (v.getId())
            {
                case R.id.py:
                    f1=new wechatf1();
                    break;
                case R.id.lt:
                    f1=new wechatf2();
                    break;
                case R.id.pyq:
                    f1=new wechatf3();
                    break;
            }

          ft.replace(R.id.fragment,f1);

            ft.commit();

        }
    };
}
