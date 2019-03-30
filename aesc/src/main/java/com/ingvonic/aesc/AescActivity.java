package com.ingvonic.aesc;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * AescActivity is the class which the application's main activity will extend.
 *
 * @author Chris Beimers, Ingvonic Studios
 * @date March 22nd, 2019
 */
public abstract class AescActivity extends Activity {

    private Point screenSize;

    protected ViewPanel render;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);
        render = new ViewPanel(this);
        setContentView(render);
        init();
    }

    public abstract void init();

    public abstract void update();

    public abstract void render(Canvas canvas);

    public int getWidth() {
        return screenSize.x;
    }

    public int getHeight() {
        return screenSize.y;
    }
}
