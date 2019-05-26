package com.example.software_project;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.software_project.MainActivity.setDB;

public class BestWord extends AppCompatActivity { //software_project

    private Object imgbtn;

    public SQLiteDatabase db;
    public Cursor c;
    ProductDBHelper mHelper;

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.best_word);

        setDB(this);
        mHelper = new ProductDBHelper(this);
        db = mHelper.getReadableDatabase();
        c = db.rawQuery("SELECT * FROM Saying", null);
        startManagingCursor(c);

        listview = (ListView) findViewById(R.id.listView);
        List<String> list = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
        String a;


        while (c.moveToNext()) {

            a = c.getString(1);
            list.add(a);
        }
        c.close();
        db.close();

        /*adapter = new SimpleAdapter(
                this, sayingList, R.layout.list_item,
                new String[]{TAG_NAME,TAG_CONTENT},
                new int[]{ R.id.name, R.id.content}
        );*/


        //메인 화면

        ImageButton imgbtn_main = (ImageButton) findViewById(R.id.bw_imgbtn_Main);
        imgbtn_main.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_ma = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_ma);
                finish();
            }
        });

        //명언 액티비티
        ImageButton imgbtn_bestword = (ImageButton) findViewById(R.id.bw_imgbtn_BestWord);
        imgbtn_bestword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_bw = new Intent(getApplicationContext(), BestWord.class);
                startActivity(intent_bw);
                finish();
            }
        });

        //커뮤니티 액티비티
        ImageButton imgbtn_community = (ImageButton) findViewById(R.id.bw_imgbtn_Community);
        imgbtn_community.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_cm = new Intent(getApplicationContext(), Community.class);
                startActivity(intent_cm);
                finish();
            }
        });

        //책 추천 액티비티
        ImageButton imgbtn_bookrecommend = (ImageButton) findViewById(R.id.bw_imgbtn_BookRecommend);
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