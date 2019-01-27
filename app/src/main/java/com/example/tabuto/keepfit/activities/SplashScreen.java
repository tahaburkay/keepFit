package com.example.tabuto.keepfit.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tabuto.keepfit.R;

public class SplashScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    SharedPreferences pref = getSharedPreferences("MyPref",0);
                    String str = pref.getString("username","");
                    Intent intent;
                    if (str.equals("")){
                        intent = new Intent(SplashScreen.this,MainActivity.class);
                    }else {
                        intent = new Intent(SplashScreen.this,AnaSayfa.class);
                    }

                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
