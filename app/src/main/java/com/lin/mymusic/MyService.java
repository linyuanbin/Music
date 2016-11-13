package com.lin.mymusic;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Created by lin on 2016/11/9.
 */
public class MyService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("dsds","onCreat");
        //创建通知栏通知实例
        Notification notification=new Notification();
        //设置图片
        notification.icon=R.drawable.star;
        //设置内容
        notification.contentView=new RemoteViews(getPackageName(),R.layout.notify);
        //设置点击通知栏通知时的跳转
        Intent intent=new Intent(this,MainActivity.class);
        notification.contentIntent= PendingIntent.getActivity(this,0,intent,0);

        //启动
        startForeground(1,notification); //这是第一个服务所有ID从1开始
    }

    @Override
    public void onDestroy() {
        Log.i("dsds","onDestory");
        super.onDestroy();
    }
}
