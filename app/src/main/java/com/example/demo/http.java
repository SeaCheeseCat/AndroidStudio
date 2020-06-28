package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.loopj.android.image.SmartImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class http extends AppCompatActivity{

    private EditText edit;
    private Button tijiao;
    private ImageView imageView;
    private String path;
    private Bitmap bitmap;
    private static final int CHANE = 0x666;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==1)
            {
                Toast.makeText(http.this,"成功了",Toast.LENGTH_SHORT).show();
                imageView.setImageBitmap((Bitmap) msg.obj);

            }
            if (msg.what==0x11)
            {

                Toast.makeText(http.this,"发生了某个异常",Toast.LENGTH_SHORT).show();
            }
            if (msg.what==11)
            {

                Toast.makeText(http.this,"发生了URL"+msg.obj.toString(),Toast.LENGTH_SHORT).show();

            }
            if (msg.what==22)
            {

                Toast.makeText(http.this,"发生了IO",Toast.LENGTH_SHORT).show();
            }

            if(msg.what==CHANE){
                Toast.makeText(http.this,"成功了",Toast.LENGTH_SHORT).show();
                Bitmap obj = (Bitmap)msg.obj;
                imageView.setImageBitmap(obj);

                Toast.makeText(http.this,bitmap.toString(),Toast.LENGTH_SHORT).show();

            }

        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        edit = findViewById(R.id.edit);
        tijiao = findViewById(R.id.tijiao);
        imageView = findViewById(R.id.tu);


  edit.setText("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1484816431839&di=d6a5e41cc3ebaff123ff8ed134df4578&imgtype=0&src=http%3A%2F%2Fnewsimg.5054399.com%2Fuploads%2Fuserup%2F1601%2F2910123392K.jpg");
//edit.setText("http://imgm.photophoto.cn/006/018/030/0180300388.jpg");


   tijiao.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           path = edit.getText().toString().trim();
           Toast.makeText(http.this,path,Toast.LENGTH_SHORT).show();

           final Message mess=new Message();

           mess.what=444;
           handler.sendMessage(mess);
           new Thread(new Runnable() {

               private InputStream inputStream;

               private int code;
               private HttpURLConnection conn;

               @Override
               public void run() {
                   try {
                       URL url=new URL(path);
                       conn = (HttpURLConnection) url.openConnection();//io
                       conn.setRequestMethod("GET");//io
                       conn.setConnectTimeout(5000);
//                       int code= conn.getResponseCode();//io


                         code= conn.getResponseCode();

                       if(code==200)
                       {
                           inputStream = conn.getInputStream();
                           bitmap = BitmapFactory.decodeStream(inputStream);//此时返回的就是图片了
                           Message message22 = new Message();
                           message22.what=CHANE;
                           message22.obj=bitmap;
                           handler.sendMessage(message22);
                       }

                   } catch (IOException e) {
                       Message message2=new Message();
                       message2.what=11;
                       message2.obj=code;

                       handler.sendMessage(message2);
                       e.printStackTrace();
                   }
                   conn.disconnect();
               }
           }).start();

       }
   });

    }


    public void showiv(View view) {

     SmartImageView sv_1;
        sv_1 = (SmartImageView) findViewById(R.id.smart);
        sv_1.setImageUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1484816431839&di=d6a5e41cc3ebaff123ff8ed134df4578&imgtype=0&src=http%3A%2F%2Fnewsimg.5054399.com%2Fuploads%2Fuserup%2F1601%2F2910123392K.jpg",//加载指定地址的图片
                R.mipmap.a,//指定图片没找到时显示的图片
                R.mipmap.b);//正在加载中显示的图片


            }






}
