package com.ingvonic.aesc;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * @author Chris Beimers, Ingvonic Studios
 * @date March 22nd, 2019
 */
public class MainThread extends Thread {

    public static final int MAX_FPS = 30;

    public static Canvas canvas;

    private double avgFPS;

    private boolean running;

    private SurfaceHolder surfaceHolder;
    private ViewPanel viewPanel;

    public MainThread(SurfaceHolder surfaceHolder, ViewPanel viewPanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.viewPanel = viewPanel;
    }

    @Override
    public void run() {
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        long targetTime = 1_000 / MAX_FPS;

        int frameCount = 0;

        while (running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    viewPanel.update();
                    viewPanel.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            timeMillis = (System.nanoTime() - startTime) / 1_000_000;
            waitTime = targetTime - timeMillis;
            try {
                if (waitTime > 0) {
                    sleep(waitTime);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            totalTime += System.nanoTime() - startTime;
            frameCount++;

            if (frameCount == MAX_FPS) {
                avgFPS = 1_000 / ((totalTime / frameCount) / 1_000_000);
                frameCount = 0;
                totalTime = 0;
                System.out.println("FPS: " + avgFPS);
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }
}
