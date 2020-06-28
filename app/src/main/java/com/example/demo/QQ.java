package com.example.demo;

import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.BatchUpdateException;
import java.util.Map;

public class QQ extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private EditText editText1;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.qq);
        super.onCreate(savedInstanceState);
        view();
        Map<String, String> stringStringMap = filesaveqq.get(this);
        if (stringStringMap!=null) {
          editText.setText(stringStringMap.get("number"));
          editText1.setText(stringStringMap.get("password"));
        }

    }

    private void view() {
        editText = findViewById(R.id.zhanghao);
        editText1 = findViewById(R.id.mima);
        button = findViewById(R.id.dl);

        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String number=editText.getText().toString();
        String pass=editText1.getText().toString();
        if(TextUtils.isEmpty(number))
        {
            Toast.makeText(this,"请输入QQ账号",Toast.LENGTH_SHORT);
        }
        if(TextUtils.isEmpty(number))
        {
            Toast.makeText(this,"请输入QQ密码",Toast.LENGTH_SHORT);
        }

        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT);

        boolean saveuserinfo = filesaveqq.saveuserinfo(this, number, pass);
        if(saveuserinfo)
        {
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT);
        }
        else
        {
            Toast.makeText(this,"失败",Toast.LENGTH_SHORT);
        }

    }
}
