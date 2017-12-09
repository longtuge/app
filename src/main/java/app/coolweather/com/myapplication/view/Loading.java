package app.coolweather.com.myapplication.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import app.coolweather.com.myapplication.R;


/**
 * Created by Administrator on 2017/10/20.
 */

public class Loading extends Activity {

    private static final long SLEEP_OUT= 1888;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Loading.this,MainActivity.class);

                startActivity(intent);
                //关闭LOGO界面
                finish();
            }
        }, SLEEP_OUT);

    }
}


