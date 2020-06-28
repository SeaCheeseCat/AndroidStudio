package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class qq2 extends AppCompatActivity {
 // private String mr="mr",mrsofts="mrsofts";
    private SharedPreferences mrsoft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq2);
        final EditText qqzh = findViewById(R.id.qqzh);
        final EditText qqmm = findViewById(R.id.qqmm);
        Button qqdl=findViewById(R.id.qqdl);


        mrsoft = getSharedPreferences("mrsoft", MODE_PRIVATE);
       String username= mrsoft.getString("username",null);//获取账号，默认值设为mr
        String password= mrsoft.getString("password",null);
        if(username!=null && password!=null)
        {
            qqzh.setText(username);
            qqmm.setText(password);

           // if (username.equals(mr)&&password.equals(mrsofts)) {
             //   Intent intent = new Intent(qq2.this, duo.class);
              //  startActivity(intent);
            //}
        }

          qqdl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String in_username = qqzh.getText().toString();
                    String in_password = qqmm.getText().toString();
                    SharedPreferences.Editor editor = mrsoft.edit();
                    //if (in_username.equals(mr) && in_password.equals(mrsofts)) {
                    editor.putString("username1", in_username);
                    editor.putString("password1", in_password);
                    Log.i("调试是否获取到", "执行到此");

                    Intent intent = new Intent(qq2.this, duo.class);
                    startActivity(intent);
                    Toast.makeText(qq2.this, "已保存密码", Toast.LENGTH_SHORT).show();

                    editor.commit();
                    //}
                    //else {
                    //  Toast.makeText(qq2.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                    //}

                }
            });
        }

    }

