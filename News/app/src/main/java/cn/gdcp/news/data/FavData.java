package cn.gdcp.news.data;

import cn.bmob.v3.BmobObject;

/**
 * Created by yls on 2017/5/22.
 */

public class FavData extends BmobObject {
    String phone;
    String newsKey;
    String newsTitle;
    String newsUrl;
    boolean isFav;
}
