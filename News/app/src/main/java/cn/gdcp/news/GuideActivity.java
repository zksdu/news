package cn.gdcp.news;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GuideActivity extends Activity {
    private ViewFlipper guide_flipper;
    private CustomGestureDetectorListener mDetectorListener;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide);

        guide_flipper = (ViewFlipper) findViewById(R.id.guide_flipper);
        mDetectorListener = new CustomGestureDetectorListener();
        mGestureDetector = new GestureDetector(GuideActivity.this, mDetectorListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class CustomGestureDetectorListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() > e2.getX()) { //如果初始触点的X坐标比最终触点的X坐标大表示向左滑动
                guide_flipper.showNext();
            }

            if (e1.getX() < e2.getX()) { //如果初始触点的X坐标比最终触点的X坐标小表示向右滑动
                guide_flipper.showPrevious();
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }






}
