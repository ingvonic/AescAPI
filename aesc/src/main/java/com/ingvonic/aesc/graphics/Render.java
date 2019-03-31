package com.ingvonic.aesc.graphics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class Render {

    private Canvas canvas;
    private Paint paint;

    private int color;

    public Render(Canvas canvas, Paint paint) {
        this.canvas = canvas;
        this.paint = paint;
    }

    public void renderSprite(Sprite sprite, int x, int y) {
        for (int xx = 0; xx < sprite.getWidth(); xx++)
            for (int yy = 0; yy < sprite.getHeight(); yy++) {
                Paint p = new Paint();
                p.setColor(sprite.getPixel(xx, yy));
                canvas.drawPoint(x + xx, y + yy, p);
            }
    }

    public void renderText(String text, Point pos) {
        canvas.drawText(text, pos.x, pos.y, paint);
    }

    public void renderBackground() {
        canvas.drawColor(color);
    }

    public void renderBackground(int color) {
        setColor(color);
        renderBackground();
    }

    public void setColor(int color) {
        this.color = color;
    }
}
