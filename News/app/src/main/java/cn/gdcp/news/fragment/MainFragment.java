package cn.gdcp.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.gdcp.news.R;
import cn.gdcp.news.adapter.MyPageAdapter;

/**
 * Created by yls on 2017/5/27.
 */

public class MainFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyPageAdapter mPageAdapter;
    private ArrayList<NewsFragment> mFragmentArrayList = new ArrayList<NewsFragment>();
    private ArrayList<String> mTitleList = new ArrayList<String>();;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentArrayList();
        initTitleList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        mTabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);

        mPageAdapter = new MyPageAdapter(getFragmentManager(), mFragmentArrayList, mTitleList);
        mViewPager.setAdapter(mPageAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);

        return view;
    }


    private void initTitleList() {

        mTitleList.add("头条");
        mTitleList.add("娱乐");
        mTitleList.add("体育");
        mTitleList.add("科技");
    }

    private void initFragmentArrayList() {
        NewsFragment fa = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("NEWSTYPE", 1);
        fa.setArguments(bundle);


        NewsFragment fb = new NewsFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("NEWSTYPE", 2);
        fb.setArguments(bundle2);

        NewsFragment fc = new NewsFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("NEWSTYPE", 3);
        fc.setArguments(bundle3);

        NewsFragment fd = new NewsFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putInt("NEWSTYPE", 4);
        fd.setArguments(bundle4);


        mFragmentArrayList.add(fa);
        mFragmentArrayList.add(fb);
        mFragmentArrayList.add(fc);
        mFragmentArrayList.add(fd);
    }
}
