package cn.gdcp.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yls on 2017/5/18.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private List<News> mNewsList;

    public  NewsAdapter(List<News> newsList){
        this.mNewsList = newsList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        NewsViewHolder holder = new NewsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News news = mNewsList.get(position);
//        news.getImgurl()
//        holder.imgView
        holder.titleView.setText(news.getTitle());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}
