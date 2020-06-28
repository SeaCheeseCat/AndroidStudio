package com.example.demo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class caipiaoservise extends Service {

    public caipiaoservise() {


    }
   public class MyBinder extends Binder{


        public caipiaoservise getService()
        {
            return caipiaoservise.this;
        }
   }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
     //   throw new UnsupportedOperationException("Not yet implemented");
        return new MyBinder();
    }

    public List<String> getnumb()
    {
        String n;
        ArrayList<String> arrayList=new ArrayList<>();
        for (int i=0;i<5;i++) {
            int numb = new Random().nextInt(32);
            if (numb < 10) {
                n = "0" + numb;

            }
            else
            {
                n=String.valueOf(numb);
            }

            arrayList.add(n);

        }
        return arrayList;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
