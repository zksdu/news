package cn.gdcp.news;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yls on 2017/5/16.
 */

public class NewsFragment extends Fragment {
//    private TextView txtContent;
    private String text;
    private RecyclerView mRecyclerView;
    private List<News> mNewsList = new ArrayList<>();
    private NewsAdapter mNewsAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        News n1 = new News();
        n1.setTitle("aaaaaaaaaa");
        mNewsList.add(n1);

        News n2 = new News();
        n2.setTitle("bbbbbbbbbb");
        mNewsList.add(n2);

        News n3 = new News();
        n3.setTitle("ccccccccc");
        mNewsList.add(n3);

        News n4 = new News();
        n4.setTitle("ddddddddd");
        mNewsList.add(n4);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("AAA", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_news, container, false);

//        txtContent = (TextView) view.findViewById(R.id.txt_content);
//        txtContent.setText(text);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.news_listview);
        mNewsAdapter = new NewsAdapter(mNewsList);
        mRecyclerView.setAdapter(mNewsAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    public void setTxtContent(String text){
        Log.e("AAA", "setTxtContent");
        this.text = text;
    }
}
