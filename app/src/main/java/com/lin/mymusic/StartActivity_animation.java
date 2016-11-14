package com.lin.mymusic;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;


public class StartActivity_animation extends Activity {
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity_animation);

        bt1= (Button) findViewById(R.id.bt);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(StartActivity_animation.this,FirstActivity.class);
                startActivity(intent);
            }
        },3000); //3秒后跳转
    }

    public void mPlay(View view){
        Intent intent=new Intent(StartActivity_animation.this,FirstActivity.class);
        startActivity(intent);

    }

}
