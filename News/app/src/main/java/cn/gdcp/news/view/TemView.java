package cn.gdcp.news.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;

import cn.gdcp.news.data.TempPoint;
import cn.gdcp.news.data.Temperature;

/**
 * Created by yls on 2017/6/1.
 */

public class TemView extends View {
    ArrayList<Temperature>  temList =  new ArrayList<>();
    ArrayList<TempPoint> pointList = new ArrayList<>();
    Paint paint = new Paint();
    private int radius = 10;

    public TemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initTempList();
        calPoint();
    }

    private void calPoint() {
        for (int i=0; i<temList.size(); i++){
            int x = 50 + (i*150);
            int lowy = (40 - (temList.get(i).low)) * 10;
            int highy = (40 - (temList.get(i).high)) * 10;

            TempPoint point = new TempPoint(x, lowy, highy);
            pointList.add(point);
        }
    }

    private void initTempList() {
        Temperature t1 = new Temperature(12, 26, new Date(2017, 5, 1));
        Temperature t2 = new Temperature(14, 32, new Date(2017, 5, 2));
        Temperature t3 = new Temperature(16, 29, new Date(2017, 5, 3));
        Temperature t4 = new Temperature(13, 31, new Date(2017, 5, 4));
        Temperature t5 = new Temperature(15, 28, new Date(2017, 5, 5));
        temList.add(t1);
        temList.add(t2);
        temList.add(t3);
        temList.add(t4);
        temList.add(t5);
        temList.add(t1);
        temList.add(t2);
        temList.add(t3);
        temList.add(t4);
        temList.add(t5);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.CYAN);

        drawPoints(canvas);

        drawLint(canvas);

        super.onDraw(canvas);


    }

    private void drawLint(Canvas canvas) {

        Path lowPath = new Path();
        Path hignPath = new Path();
        for(int i=0; i<pointList.size(); i++){
            TempPoint tp = pointList.get(i);
            if(i==0){
                lowPath.moveTo(tp.x, tp.lowy);
                hignPath.moveTo(tp.x, tp.highy);
            }else {
                lowPath.lineTo(tp.x, tp.lowy);
                hignPath.lineTo(tp.x, tp.highy);
            }
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.GREEN);
        canvas.drawPath(lowPath, paint);

        paint.setColor(Color.RED);
        canvas.drawPath(hignPath, paint);

    }

    private void drawPoints(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        for(int i=0;  i<pointList.size(); i++) {
            TempPoint tp = pointList.get(i);

            paint.setColor(Color.GREEN);
            canvas.drawCircle(tp.x, tp.lowy, radius, paint);

            paint.setColor(Color.RED);
            canvas.drawCircle(tp.x, tp.highy, radius, paint);
        }
    }
}
