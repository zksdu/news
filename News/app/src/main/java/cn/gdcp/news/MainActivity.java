package cn.gdcp.news;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyPageAdapter mPageAdapter;
    private ArrayList<NewsFragment> mFragmentArrayList = new ArrayList<NewsFragment>();
    private ArrayList<String> mTitleList = new ArrayList<String>();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragmentArrayList();
        initTitleList();

        mTabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mPageAdapter = new MyPageAdapter(getSupportFragmentManager(), mFragmentArrayList, mTitleList);
        mViewPager.setAdapter(mPageAdapter);
//
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initTitleList() {

        mTitleList.add("头条");
//        mTitleList.add("娱乐");
//        mTitleList.add("体育");
//        mTitleList.add("科技");
    }

    private void initFragmentArrayList() {
        NewsFragment fa = new NewsFragment();
        fa.setTxtContent("头条页面");

        NewsFragment fb = new NewsFragment();
        fb.setTxtContent("页面");

        NewsFragment fc = new NewsFragment();
        fc.setTxtContent("体育页面");

        NewsFragment fd = new NewsFragment();
        fd.setTxtContent("科技页面");
        mFragmentArrayList.add(fa);
//        mFragmentArrayList.add(fb);
//        mFragmentArrayList.add(fc);
//        mFragmentArrayList.add(fd);
    }
}
