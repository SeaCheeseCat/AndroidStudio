package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class xml extends AppCompatActivity implements View.OnClickListener {

    private TextView c1;
    private TextView c2;
    private TextView c3;
    private List<Map<String, String>> list;
private Map<String,String> map;
    private TextView c4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        initview();

        //解析xml
        //InputStream inputStream = getResources().openRawResource(R.raw.weather1);
        InputStream inputStream = getResources().openRawResource(R.raw.weather2);
        try {
            //List<xweatherinfo> getinfor = xweatherservice.getinfor(inputStream);
            List<xweatherinfo> getinfor = xweatherservice.getinfojson(inputStream);
            list = new ArrayList<>();
            for (xweatherinfo info: getinfor) {
                map=new HashMap<>();
                map.put("1",info.getWeather());
                map.put("2",info.getTemp());

                map.put("3",info.getWind());
                map.put("4",info.getName());
                list.add(map);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        //自定义一个方法getmal方法

    }


   public void getmap(int i)
    {
        Map<String,String> citymap=list.get(i);
        String temp=citymap.get("1");
        String name=citymap.get("2") ;
        String weather=citymap.get("3");
        String wind=citymap.get("4") ;
        c1.setText(name);
        c2.setText(weather);
        c3.setText(wind);
        c4.setText(temp);

    }

    private void initview() {
        c1 = findViewById(R.id.city2);
        c2 = findViewById(R.id.tianqi);
        c3 = findViewById(R.id.wnedu);
        c4 = findViewById(R.id.temp);
        findViewById(R.id.shanghai).setOnClickListener(this);
        findViewById(R.id.guangdong).setOnClickListener(this);
        findViewById(R.id.beijing).setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
switch (v.getId())
{
    case R.id.shanghai:
getmap(0);
        break;
    case R.id.beijing:
getmap(1);
        break;
    case R.id.guangdong:
getmap(2);
        break;
}
    }





}
