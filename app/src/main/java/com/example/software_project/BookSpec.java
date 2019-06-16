package com.example.software_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.software_project.MainActivity.setDB;

public class BookSpec extends AppCompatActivity {
    private Object imgbtn;

    public SQLiteDatabase db;
    public Cursor c;
    ProductDBHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_spec);

        Intent intentb = getIntent();
        String b_id = intentb.getExtras().getString("sDay");

       // TextView tvname = (TextView) findViewById(R.id.tvbname);
        //tvname.setText(b_id);
        TextView tvname = (TextView) findViewById(R.id.tvbname);
        TextView tvwriter = (TextView) findViewById(R.id.tvwriter);
        TextView tvdes = (TextView) findViewById(R.id.tvbdes);
        TextView tvpu = (TextView) findViewById(R.id.tvpublisher);
        TextView tvprice = (TextView) findViewById(R.id.tvprice);
        ImageView imgv = (ImageView) findViewById(R.id.bimageView);

        setDB(this);
        mHelper = new ProductDBHelper(this);
        db = mHelper.getReadableDatabase();
        c = db.rawQuery("SELECT * FROM Book Where _id='" + b_id + "'", null);
        startManagingCursor(c);

        String name="";
        String writer ="";
        String des = "";
        String pub = "";
        int price =0;

        byte[] img = new byte[0];


        while (c.moveToNext()) {
            name=c.getString(1);
            writer =c.getString(2);
            price = c.getInt(3);
            pub = c.getString(4);
            des = c.getString(5);
            img = c.getBlob(6);

        }
        //c.close();

        Bitmap image = BitmapFactory.decodeByteArray(img,0,img.length);
        String sprice = String.valueOf(price);

        c.close();
        db.close();

        tvwriter.setText(writer);
        tvname.setText(name);
        tvdes.setText(des);
        tvpu.setText(pub);
        tvprice.setText(sprice);
        imgv.setImageBitmap(image);

        //메인 화면

        ImageButton imgbtn_main = (ImageButton) findViewById(R.id.bs_imgbtn_Main);
        imgbtn_main.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_ma = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_ma);
                //finish();
            }
        });

        //명언 액티비티
        ImageButton imgbtn_bestword = (ImageButton) findViewById(R.id.bs_imgbtn_BestWord);
        imgbtn_bestword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_bw = new Intent(getApplicationContext(), BestWord.class);
                startActivity(intent_bw);
                //finish();
            }
        });

        //커뮤니티 액티비티
        ImageButton imgbtn_community = (ImageButton) findViewById(R.id.bs_imgbtn_Community);
        imgbtn_community.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_cm = new Intent(getApplicationContext(), Community.class);
                startActivity(intent_cm);
                //finish();
            }
        });

        //책 추천 액티비티
        ImageButton imgbtn_bookrecommend = (ImageButton) findViewById(R.id.bs_imgbtn_BookRecommend);
        imgbtn_bookrecommend.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent_br = new Intent(getApplicationContext(), BookRecommend.class);
                startActivity(intent_br);
                //finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        //this.finish();
        //super.onBackPressed();
    }
}