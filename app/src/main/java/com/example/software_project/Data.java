package com.example.software_project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Data {

    private String title;
    private String content;
    private byte[] img = new byte[0];
    private Bitmap image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }



    public Bitmap getImage() {
        image = BitmapFactory.decodeByteArray(img,0,img.length);
        return image;
    }
}