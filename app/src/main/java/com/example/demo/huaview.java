package com.example.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Environment;
import android.view.View;

public class huaview extends View {
    public huaview(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
    paint.setColor(0xFFFF6600);
    paint.setStyle(Paint.Style.FILL);
    canvas.drawRect(10,10,280,150,paint);


    paint.setAntiAlias(true);//采用抗锯齿
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(12);
        canvas.drawText("hi ,我绘制了一个文字",175,160,paint);


        String path= Environment.getExternalStorageDirectory()+"/demo.jpg";
        Bitmap bitmap= BitmapFactory.decodeFile(path);
        canvas.drawBitmap(bitmap,200,260,paint);

    }
}
