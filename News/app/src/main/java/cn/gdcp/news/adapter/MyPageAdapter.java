package cn.gdcp.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import cn.gdcp.news.fragment.NewsFragment;

/**
 * Created by yls on 2017/5/16.
 */
public class MyPageAdapter extends FragmentPagerAdapter {
    private ArrayList<NewsFragment> mFragmentArrayList;
    private ArrayList<String> mTitleList;

    public MyPageAdapter(FragmentManager fm, ArrayList<NewsFragment> fragmentArrayList, ArrayList<String> titleList) {
        super(fm);
        this.mFragmentArrayList = fragmentArrayList;
        this.mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        if(position < mFragmentArrayList.size()){
            return mFragmentArrayList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if(mFragmentArrayList == null){
            return 0;
        }
        return mFragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(mTitleList != null && position < mTitleList.size()) {
            return mTitleList.get(position);
        }

        return "notitle";
    }
}
