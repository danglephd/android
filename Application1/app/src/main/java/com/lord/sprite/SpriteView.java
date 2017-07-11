package com.lord.sprite;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SpriteView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = SpriteView.class.getSimpleName();

    private TutorialThread _Thread;
    private float x = 0;
    private float y = 0;
    private Paint paint = null;

    public SpriteView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        getHolder().addCallback(this);
        _Thread = new TutorialThread(getHolder(), this);
        setFocusable(true);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        x = event.getX();
        y = event.getY();
        return super.onTouchEvent(event);
    }

    /**
     * @param canvas
     */
    @Override
    public void draw(Canvas canvas) {
        // TODO Auto-generated method stub
        try {
            super.draw(canvas);
            canvas.drawColor(Color.RED);
            canvas.drawCircle(x, y, 50.0f, paint);

        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage(), ex);
        }
    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {

    }

    public void surfaceCreated(SurfaceHolder arg0) {
        _Thread.setRunning(true);
        _Thread.start();
    }

    public void surfaceDestroyed(SurfaceHolder arg0) {

        boolean retry = true;
        _Thread.setRunning(false);
        while (retry) {
            try {
                _Thread.join();
                retry = false;
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
    }

    class TutorialThread extends Thread {
        private SurfaceHolder m_Holder;
        private SpriteView m_ShowImgIcon;
        private boolean _run = false;

        public TutorialThread(SurfaceHolder surfaceHolder, SpriteView showImgIcon) {
            // TODO Auto-generated constructor stub
            m_Holder = surfaceHolder;
            m_ShowImgIcon = showImgIcon;
        }

        public void setRunning(boolean run) {
            // TODO Auto-generated method stub
            _run = run;
        }

        public SurfaceHolder getSurfaceHolder() {
            // TODO Auto-generated method stub

            return m_Holder;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            Canvas c;
            while (_run) {
                c = null;
                try {
                    c = m_Holder.lockCanvas();
                    synchronized (c) {
                        m_ShowImgIcon.draw(c);
                    }
                } finally {
                    // TODO: handle exception
                    if (c != null) {
                        m_Holder.unlockCanvasAndPost(c);
                    }
                }
            }
        }
    }
}
