package com.example.demo;

import android.util.Xml;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//解析天气的工具类
public class xweatherservice {
public static List<xweatherinfo> getinfor(InputStream is)throws Exception
{
    List<xweatherinfo> xweatherinfos=null;
    xweatherinfo xweatherinfo=null;
    //获取pull解析类
    XmlPullParser parser= Xml.newPullParser();
    //初始化解析器，告诉解析器要解析的xml文件
    parser.setInput(is,"utf-8");

    //得到当前的事件类型
    int eventType = parser.getEventType();
    while(eventType!=XmlPullParser.END_DOCUMENT)
    {
        //具体判断一下解析的是开始标签还是结束
        switch (eventType)
        {
            case XmlPullParser.START_TAG://解析的是开始标签
                if("infos".equals(parser.getName()))
                {
                    xweatherinfos=new ArrayList<xweatherinfo>();
                }else if("city".equals(parser.getName()))
                {
                    xweatherinfo =new xweatherinfo();
                    String id=parser.getAttributeValue(0);
                    xweatherinfo.setId(id);
                }else if("temp".equals(parser.getName()))
                {
                    String temp=parser.nextText();
                    xweatherinfo.setTemp(temp);
                }else if("weather".equals(parser.getName()))
                {
                    String weather=parser.nextText();
                    xweatherinfo.setTemp(weather);
                }else if("name".equals(parser.getName()))
                {
                    String name=parser.nextText();
                    xweatherinfo.setTemp(name);
                }else if("wind".equals(parser.getName()))
                {
                    String wind=parser.nextText();
                    xweatherinfo.setTemp(wind);
                }

                break;

            case XmlPullParser.END_TAG:
                if("city".equals(parser.getName()))
                {
                    xweatherinfos.add(xweatherinfo);
                }
                break;
        }
        eventType=parser.next();
    }
    return xweatherinfos;

}


public static List<xweatherinfo> getinfojson(InputStream is) throws IOException {
    byte[] buff=new byte[is.available()];
    is.read(buff);
   String json= new String(buff,"utf-8");
    //使用Gson进行解析
    Gson gson=new Gson();
    Type list=new TypeToken<List<xweatherinfo>>(){}.getType();
    List<xweatherinfo> weinfo=gson.fromJson(json,list);

    return weinfo;
}

}
