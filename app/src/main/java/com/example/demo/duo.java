package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class duo extends AppCompatActivity {

    private TextView xiaoxi;
    private ProgressBar times;
final  int TIME=60;//定义时间长度
    final int TIMEMSG=0x001;

    private  int mprogress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duo);
        xiaoxi = findViewById(R.id.xiaoxi);
        times = findViewById(R.id.time);

        Button xia = findViewById(R.id.xia);
handler1.sendEmptyMessage(TIMEMSG);
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what==0x123)
                {
                    xiaoxi.setText("变一条信息");
                }
            }
        };
xia.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                handler.sendEmptyMessage(0x123);//发送空消息
            }
        });

        thread.start();
    }
});


//在其他线程中创建handler对象，注意在主线程中调用的handler是自动创建loop对象的
       Thread thread2= new Thread(new Runnable() {
            Handler handler2;

            @Override
            public void run() {
                Looper.prepare();
              handler2 = new Handler()
                {
                    @Override
                    public void handleMessage(@NonNull Message msg) {

                        super.handleMessage(msg);
                    Toast.makeText(duo.this,"开启了hanndler",Toast.LENGTH_SHORT).show();
                    }
                };
                Message message2=handler2.obtainMessage();
                message2.what=0x7;
                handler1.sendMessage(message2);
                Looper.loop();
            }



       });
  thread2.start();


    }


    Handler handler1=new Handler()
    {
        @Override
        public void handleMessage(@NonNull Message msg) {

            super.handleMessage(msg);
            if(TIME-mprogress>0)
            {
                mprogress++;
                times.setProgress(TIME-mprogress);
                handler1.sendEmptyMessageDelayed(TIMEMSG,1000);

            }
            else
            {
                Toast.makeText(duo.this,"时间到",Toast.LENGTH_SHORT).show();;
            }
        }
    };


}
