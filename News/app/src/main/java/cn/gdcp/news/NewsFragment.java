package cn.gdcp.news;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yls on 2017/5/16.
 */

public class NewsFragment extends Fragment {
    private TextView txtContent;
    private String text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("AAA", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        txtContent = (TextView) view.findViewById(R.id.txt_content);
        txtContent.setText(text);
        return view;
    }

    public void setTxtContent(String text){
        Log.e("AAA", "setTxtContent");
        this.text = text;
    }
}
