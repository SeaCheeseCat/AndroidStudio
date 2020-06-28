package com.example.demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.net.URL;

public class intent1 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent1);
        final Intent intent=new Intent();

        ((Button)findViewById(R.id.intenta1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");

                intent.setFlags(intent.FLAG_ACTIVITY_NO_HISTORY);//该inten不在历史栈中保留
                startActivity(intent);

            }
        });


       ((Button)findViewById(R.id.intenta2)).setOnClickListener(onClickListener);
        ((Button)findViewById(R.id.intenta3)).setOnClickListener(onClickListener);
        ((Button)findViewById(R.id.guanbi)).setOnClickListener(onClickListener);
        ((Button)findViewById(R.id.net)).setOnClickListener(onClickListener);
        ((Button)findViewById(R.id.guo)).setOnClickListener(onClickListener);

    }


    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         Intent intent=new Intent();
         Button button=(Button) v;
         switch (button.getId())
         {
             case R.id.intenta2:
                 intent.setAction(intent.ACTION_DIAL);//表示调用接号面板
                 intent.setData(Uri.parse("tel:10086"));
                 startActivity(intent);
                 break;
             case R.id.intenta3:
                 intent.setAction(intent.ACTION_SENDTO);//表示调用接号面板
                 intent.setData(Uri.parse("smsto:10086"));
                 intent.putExtra("sms_body","hi");
                 startActivity(intent);
                 break;


             case R.id.guanbi:
               intent.setAction(intent.ACTION_MAIN);
               intent.addCategory(intent.CATEGORY_HOME);
               startActivity(intent);
                 break;

             case R.id.net:
                 intent.setAction("android.intent.action.VIEW");
                 intent.setData(Uri.parse("https://keylol.com/f161-1"));
                 startActivity(intent);
                 break;
             case R.id.guo:
                 intent.setAction(intent.ACTION_VIEW);
                 startActivity(intent);
                 break;
         }

        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(intent1.this,"ontouch方法调用了",Toast.LENGTH_SHORT).show();

        return super.onTouchEvent(event);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(intent1.this,"按下",Toast.LENGTH_SHORT).show();

        return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Toast.makeText(intent1.this,"抬起",Toast.LENGTH_SHORT).show();

        return super.onKeyUp(keyCode, event);
    }
}
