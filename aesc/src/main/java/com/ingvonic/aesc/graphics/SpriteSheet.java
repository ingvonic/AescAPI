package com.ingvonic.aesc.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SpriteSheet {

    private int[][]raster;

    private int width;
    private int height;

    public SpriteSheet(String fileName, int width, int height){
        Bitmap bmp = BitmapFactory.decodeFile(fileName);

        this.width=width;
        this.height=height;
    }

    public int[][]getRaster(){
        return raster;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
