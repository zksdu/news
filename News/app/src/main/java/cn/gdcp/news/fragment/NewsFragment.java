package cn.gdcp.news.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.gdcp.news.data.NewsData;
import cn.gdcp.news.R;
import cn.gdcp.news.adapter.NewsAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yls on 2017/5/16.
 */

public class NewsFragment extends Fragment {
    private static final int MSG_GET_NEWS = 1001;
    private int mType;

    //    private TextView txtContent;
    private String text;
    private RecyclerView mRecyclerView;
    private List<NewsData.ResultBean.NewsBean> mNewsList = new ArrayList<>();
    private NewsAdapter mNewsAdapter;
    private final String URL1 = "http://v.juhe.cn/toutiao/index?type=top&key=951120925db65e7801656e888efa6c4c";
    private final String URL2 = "http://v.juhe.cn/toutiao/index?type=yule&key=951120925db65e7801656e888efa6c4c";
    private final String URL3 = "http://v.juhe.cn/toutiao/index?type=tiyu&key=951120925db65e7801656e888efa6c4c";
    private final String URL4 = "http://v.juhe.cn/toutiao/index?type=keji&key=951120925db65e7801656e888efa6c4c";
    private android.os.Handler mHandler;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mType = getArguments().getInt("NEWSTYPE");
        initHandler();
        getNewsFromJuhe();

    }

    private void initHandler() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == MSG_GET_NEWS){
                    mNewsAdapter.changData(mNewsList);
                    return  true;
                }
                return false;
            }
        });

    }

    private void getNewsFromJuhe() {
        OkHttpClient client = new OkHttpClient();
        Request request;
        switch (mType){
            case 1:
                request = new Request.Builder().url(URL1).build();
                break;

            case 2:
                request = new Request.Builder().url(URL2).build();
                break;

            case 3:
                request = new Request.Builder().url(URL3).build();
                break;
            case 4:
                request = new Request.Builder().url(URL4).build();
                break;
            default:
                request = new Request.Builder().url(URL1).build();
                break;

        }

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("AAA", "GET DATA FAILED");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                NewsData newsData = gson.fromJson(response.body().string(), NewsData.class);
                mNewsList = newsData.getResult().getData();
                mHandler.sendEmptyMessage(MSG_GET_NEWS);
            }
        });
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
