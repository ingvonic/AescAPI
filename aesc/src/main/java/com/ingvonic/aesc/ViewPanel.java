package com.ingvonic.aesc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Chris Beimers, Ingvonic Studios
 * @date March 22nd, 2019
 */
public class ViewPanel extends SurfaceView implements SurfaceHolder.Callback {

    private AescActivity context;
    private MainThread thread;

    private int bgCol;

    public ViewPanel(Context context) {
        super(context);
        this.context = (AescActivity) context;
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setBGCol(0xffffff);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:

                break;
        }
        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(bgCol);
        context.render(canvas);
    }

    public void update() {
        context.update();
    }

    public void setBGCol(int bgCol) {
        this.bgCol = bgCol;
    }
}
