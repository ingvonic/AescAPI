package com.ingvonic.aesc.graphics;

public class SpriteSheet {

    private String identifier;

    private byte[][]raster;

    private int width;
    private int height;

    public SpriteSheet(String identifier, byte[][]raster, int width, int height){
        this.identifier=identifier;
        this.raster=raster;
        this.width=width;
        this.height=height;
    }

    public String getIdentifier(){
        return identifier;
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
