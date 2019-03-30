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

    public void renderText(String text, Point pos){
        canvas.drawText(text, pos.x, pos.y, paint);
    }

    public void renderBackground(){
        canvas.drawColor(color);
    }

    public void renderBackground(int color){
        setColor(color);
        renderBackground();
    }

    public void setColor(int color){
        this.color=color;
    }
}
