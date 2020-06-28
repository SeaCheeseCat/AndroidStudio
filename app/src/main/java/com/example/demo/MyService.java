package com.example.demo;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MyService extends Service {
    static boolean isplay;
    MediaPlayer player;
    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(this,R.raw.who);
        Log.i("Service","oncreat方法调用");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(!player.isPlaying())
        {
            player.start();
            isplay=player.isPlaying();

        }

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//            int i=0;
//            while(true)
//            {
//
//                Log.i("Servive",String.valueOf(++i));
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            }
//        }).start();
//        Log.i("Service","onstartcommand方法调用");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("Service","销毁方法调用");
        player.stop();
        isplay=player.isPlaying();
        player.release();
        super.onDestroy();
    }

//    public boolean isRunning()
//    {
//        ActivityManager activityManager=(ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        ArrayList<ActivityManager.RunningServiceInfo> runningServiceInfos=(ArrayList<ActivityManager.RunningServiceInfo>)
//                for(int i=0;i<runningServiceInfos.size();i++)
//                {
//                    if(runningServiceInfos.get(i).service.getClassName().toString().equals("com."))
//                }
//
//    }
}
