package cn.gdcp.news.data;

import java.util.Date;

/**
 * Created by yls on 2017/6/1.
 */

public class Temperature {
   public   int low;
    public  int high;
    public Date mDate;

    public Temperature(int low, int high, Date mDate) {
        this.high = high;
        this.low = low;
        this.mDate = mDate;
    }
}
