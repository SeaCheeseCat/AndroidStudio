package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class jishi extends AppCompatActivity {

   byte[] buffer=null;
    File file;
    private EditText jis;
    private FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jishi);
        Button baochun = findViewById(R.id.baochun);
        jis = findViewById(R.id.ji);
        file=new File(Environment.getExternalStorageDirectory(),"new.txt");

        try {
            fis = new FileInputStream(file);
            buffer =new byte[fis.available()];
            fis.read(buffer);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                fis.close();
                String data=new String(buffer);
                jis.setText(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        baochun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fos=null;
                String text= jis.getText().toString();

                try {
                    fos=new FileOutputStream(file);
                    fos.write(text.getBytes());
                    fos.flush();
                    Toast.makeText(jishi.this,"保存成功",Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(jishi.this,"文件不存在异常",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(jishi.this,"io异常",Toast.LENGTH_SHORT).show();
                }finally {
                    if(fos!=null)
                    {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        });
    }


}
