package com.example.software_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.example.software_project.BestWord.setDB;

public class MainActivity extends AppCompatActivity {

    public static final String ROOT_DIR = "/data/data/com.example.software_project/databases/";
    public SQLiteDatabase db;
    public Cursor c;
    ProductDBHelper mHelper;

    private Object imgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메인 화면

        ImageButton imgbtn_main = (ImageButton) findViewById(R.id.imgbtn_Main);
        imgbtn_main.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_ma = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_ma);
                finish();
            }
        });

        //명언 액티비티
        ImageButton imgbtn_bestword = (ImageButton) findViewById(R.id.imgbtn_BestWord);
        imgbtn_bestword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_bw = new Intent(getApplicationContext(), BestWord.class);
                startActivity(intent_bw);
                finish();
            }
        });

        //커뮤니티 액티비티
        ImageButton imgbtn_community = (ImageButton) findViewById(R.id.imgbtn_Community);
        imgbtn_community.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_cm = new Intent(getApplicationContext(), Community.class);
                startActivity(intent_cm);
                finish();
            }
        });

        //책 추천 액티비티
        ImageButton imgbtn_bookrecommend = (ImageButton) findViewById(R.id.imgbtn_BookRecommend);
        imgbtn_bookrecommend.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent_br = new Intent(getApplicationContext(), BookRecommend.class);
                startActivity(intent_br);
                finish();
            }
        });


        TextView textView = (TextView) findViewById(R.id.Txt_Main_bw);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Maplestory Light.ttf");
        textView.setTypeface(typeface);

        TextView textView2 = (TextView) findViewById(R.id.Txt_Main_cm);
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "Maplestory Light.ttf");
        textView2.setTypeface(typeface2);

        TextView textView3 = (TextView) findViewById(R.id.Txt_Main_br);
        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "Maplestory Light.ttf");
        textView3.setTypeface(typeface3);


    }
}
