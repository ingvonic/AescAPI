package com.ingvonic.aesc.graphics;

public class SpriteSheet {

    private byte[][]raster;

    private int width;
    private int height;

    public SpriteSheet(byte[][]raster, int width, int height){
        this.raster=raster;
        this.width=width;
        this.height=height;
    }

    public byte[][]getRaster(){
        return raster;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
