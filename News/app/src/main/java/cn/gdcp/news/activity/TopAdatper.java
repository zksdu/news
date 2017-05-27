package cn.gdcp.news.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yls on 2017/5/27.
 */
public class TopAdatper extends FragmentPagerAdapter {
    private List<Fragment> topFragmentList;

    public TopAdatper(FragmentManager fm, List<Fragment> topFragmentList) {
        super(fm);
        this.topFragmentList = topFragmentList;
    }

    @Override
    public int getCount() {
        return topFragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return topFragmentList.get(position);
    }

}
