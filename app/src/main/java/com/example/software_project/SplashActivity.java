package com.example.software_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try{

            Thread.sleep((2000));
        }catch (InterruptedException e){

            e.printStackTrace();
        }

        Intent intent_sp = new Intent(this, MainActivity.class);
        startActivity(intent_sp);
        finish();
    }
}
