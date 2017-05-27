package cn.gdcp.news.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cn.gdcp.news.R;
import cn.gdcp.news.fragment.JokeFragment;
import cn.gdcp.news.fragment.MainFragment;
import cn.gdcp.news.fragment.MyFragment;
import cn.gdcp.news.fragment.WeatherFragment;

public class TopActivity extends FragmentActivity {
    private ViewPager topPager;
    private List<Fragment> topFragmentList =  new ArrayList<>();
    private TopAdatper mAdatper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        topPager = (ViewPager) findViewById(R.id.top_pager);

        MainFragment mf = new MainFragment();
        topFragmentList.add(mf);

        JokeFragment jf = new JokeFragment();
        topFragmentList.add(jf);

        WeatherFragment wf = new WeatherFragment();
        topFragmentList.add(wf);

        MyFragment myf = new MyFragment();
        topFragmentList.add(myf);

        mAdatper = new TopAdatper(getSupportFragmentManager(),topFragmentList);
        topPager.setAdapter(mAdatper);
    }
}
