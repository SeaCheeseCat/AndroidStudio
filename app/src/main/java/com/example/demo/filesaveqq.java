package com.example.demo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class filesaveqq {
    //保存QQ账号和密码，到data.txt
    public static boolean saveuserinfo(Context context,String number,String pass)  {


        try {
            FileOutputStream fileOutputStream = context.openFileOutput("data.txt", context.MODE_PRIVATE);
            fileOutputStream.write((number+":"+pass).getBytes());
            fileOutputStream.close();
            return false;
        } catch (IOException e) {

            e.printStackTrace();
            return true;
        }

    }

    public static Map<String,String> get(Context context)
    {
        String content=null;
        try {
            FileInputStream fileInputStream = context.openFileInput("data.txt");
            byte[] bytes=new byte[fileInputStream.available()];
         fileInputStream.read(bytes);
         Map<String,String> map=new HashMap<>();
        content=new String(bytes);
        String[] info=content.split(":");
        map.put("number",info[0]);
         map.put("password",info[1]);
        fileInputStream.close();
        return map;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
