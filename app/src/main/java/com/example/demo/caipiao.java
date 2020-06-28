package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class caipiao extends AppCompatActivity {
    caipiaoservise caipiaoservise;
   int[] tvid={R.id.h1,R.id.h2,R.id.h3,R.id.h4,R.id.h5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caipiao);
    Button button= findViewById(R.id.xuan);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            List<String> number=caipiaoservise.getnumb();
            for(int i=0;i<number.size();i++)
            {
                TextView tv=(TextView)findViewById(tvid[i]);
                tv.setText(number.get(i).toString());


            }
        }
    });

    }



    //创建servicescon
   private ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            caipiaoservise=((caipiaoservise.MyBinder)service).getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=new Intent(caipiao.this,caipiaoservise.class);
        bindService(intent,conn,BIND_AUTO_CREATE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
