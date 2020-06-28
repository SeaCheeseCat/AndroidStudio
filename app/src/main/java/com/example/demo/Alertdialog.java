package com.example.demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Alertdialog extends AppCompatActivity {

    private static final int NOTIFIY = 0x666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);

        Button dui1 = findViewById(R.id.dui1);
        dui1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog1=new AlertDialog.Builder(Alertdialog.this).create();//这里不能直接new alerdialog()他说的是因为受保护了
                alertDialog1.setIcon(R.mipmap.a);
                alertDialog1.setTitle("这是第一种提示框");
                alertDialog1.setMessage("第一啊啊啊啊啊啊啊啊啊啊啊啊啊");
                alertDialog1.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Alertdialog.this,"点击了取消按钮",Toast.LENGTH_SHORT).show();

                    }
                });

                alertDialog1.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Alertdialog.this,"点击了确定按钮",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog1.show();
            }
        });

            Button dui2=findViewById(R.id.dui2);
        dui2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             AlertDialog.Builder alertDialog2=new AlertDialog.Builder(Alertdialog.this);

             alertDialog2.setIcon(R.mipmap.a);
             alertDialog2.setTitle("123");
             String a[]={"aaa","123","ccc","sd"};
             alertDialog2.setItems(a, new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     Toast.makeText(Alertdialog.this, "这是第"+which+"个", Toast.LENGTH_SHORT).show();
                 }
             });

             alertDialog2.create().show();
            }


        });





        ((Button)findViewById(R.id.tongzhi)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);//获取一个通知管理器
                NotificationCompat.Builder no=new NotificationCompat.Builder(Alertdialog.this);

                no.setAutoCancel(true);//设置通知打开后自动消失
                no.setSmallIcon(R.mipmap.a);
                no.setContentTitle("这是一个标题");
                no.setContentText("点击查看");
                no.setWhen(System.currentTimeMillis());//设置发送的时间
                no.setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE);//设置声音和振动
                Intent inten=new Intent(Alertdialog.this,caipiao.class);
                PendingIntent pi=PendingIntent.getActivity(Alertdialog.this,0,inten,0);//设置通知点击跳转
                no.setContentIntent(pi);
                notificationManager.notify(NOTIFIY,no.build());
            }
        });

    }
}
