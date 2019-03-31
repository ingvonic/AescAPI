package com.ingvonic.aesc.graphics;

public class Sprite {

    private int[][] raster;

    private int w;
    private int h;

    public Sprite(SpriteSheet sheet, int x, int y, int w, int h) {
        this.w = w;
        this.h = h;
        for (int xx = 0; xx < w; xx++)
            for (int yy = 0; yy < h; yy++)
                raster[xx][yy] = sheet.getRaster()[x * w + xx][y * h + yy];
    }

    public int getPixel(int x, int y) {
        return raster[x][y];
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }
}
