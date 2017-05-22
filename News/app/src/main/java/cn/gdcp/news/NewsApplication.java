package cn.gdcp.news;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by yls on 2017/5/22.
 */

public class NewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "7e0d2c0bb90bd831fc7556c9b5638da5");
    }
}
