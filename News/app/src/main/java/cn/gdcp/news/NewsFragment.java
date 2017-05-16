package cn.gdcp.news;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yls on 2017/5/16.
 */

public class NewsFragment extends Fragment {
    private TextView txtContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container);

        txtContent = (TextView) view.findViewById(R.id.txt_content);
        return view;
    }

    public void setTxtContent(String text){
        if(txtContent != null){
            txtContent.setText(text);
        }
    }
}
