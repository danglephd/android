package com.lord.sprite;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by danglph on 03/07/2017.
 */

public class NewSpriteView extends View {

    private static final String TAG = NewSpriteView.class.getSimpleName();
    public NewSpriteView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            super.onDraw(canvas);
            canvas.drawColor(Color.RED);
//            canvas.drawCircle(x, y, 10.0f, paint);

        }catch (Exception ex){
            Log.e(TAG, ex.getMessage(), ex);
        }
        invalidate();
    }
//    public NewSpriteView(Context context) {
//        super(context);
//        // TODO Auto-generated constructor stub
//        getHolder().addCallback(this);
//        _Thread = new SpriteView.TutorialThread(getHolder(), this);
//        setFocusable(true);
//        paint = new Paint();
//        paint.setColor(Color.BLUE);
//        paint.setStyle(Paint.Style.FILL);
//    }

}
