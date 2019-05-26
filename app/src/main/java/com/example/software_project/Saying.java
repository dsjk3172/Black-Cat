package com.example.software_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Saying extends AppCompatActivity {
    private Object imgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saying);

        //메인 화면

        ImageButton imgbtn_main = (ImageButton) findViewById(R.id.s_imgbtn_Main);
        imgbtn_main.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_ma = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_ma);
                finish();
            }
        });

        //명언 액티비티
        ImageButton imgbtn_bestword = (ImageButton) findViewById(R.id.s_imgbtn_BestWord);
        imgbtn_bestword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_bw = new Intent(getApplicationContext(), BestWord.class);
                startActivity(intent_bw);
                finish();
            }
        });

        //커뮤니티 액티비티
        ImageButton imgbtn_community = (ImageButton) findViewById(R.id.s_imgbtn_Community);
        imgbtn_community.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_cm = new Intent(getApplicationContext(), Community.class);
                startActivity(intent_cm);
                finish();
            }
        });

        //책 추천 액티비티
        ImageButton imgbtn_bookrecommend = (ImageButton) findViewById(R.id.s_imgbtn_BookRecommend);
        imgbtn_bookrecommend.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent_br = new Intent(getApplicationContext(), BookRecommend.class);
                startActivity(intent_br);
                finish();
            }
        });

    }
}
