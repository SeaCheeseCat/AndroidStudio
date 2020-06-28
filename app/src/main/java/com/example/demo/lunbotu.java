package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class lunbotu extends AppCompatActivity {


    final  int FLAG_MSG=0x666;
    private int[] images=new int[]{R.mipmap.a,R.mipmap.b};
    private ViewFlipper flipper;
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunbotu);
        flipper = findViewById(R.id.viewFlipper);
        for (int i=0;i<images.length;i++)
        {
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(images[i]);
            flipper.addView(imageView);
        }

        //开启广告轮播
        message=Message.obtain();//获取message对象
        message.what=FLAG_MSG;//设置what消息代码
        handler.sendMessage(message);//发送消息
    }
    Handler handler=new Handler()
    {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        if(msg.what==FLAG_MSG)
        {
            flipper.showPrevious();//切换到下一个图片
            message=handler.obtainMessage(FLAG_MSG);
            handler.sendMessageDelayed(message,3000);//延迟3秒发送消息

        }
        }
    };


}
