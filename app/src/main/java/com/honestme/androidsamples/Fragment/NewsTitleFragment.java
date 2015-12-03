package com.honestme.androidsamples.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.honestme.androidsamples.R;

import java.util.*;
/**
 * Created by Administrator on 2015/12/3 0003.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener{
    private View mView;
    private ListView mListView;
    private List<NewsModel> mNewsModelsList;
    private FragmentAdapter mAdapter;
    private boolean isTwoPane;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mNewsModelsList = getNews();
        mAdapter = new FragmentAdapter(context,R.layout.fragment_activity_list_item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_title,container);
        mListView = (ListView)mView.findViewById(R.id.news_title_listview);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public List<NewsModel> getNews(){
        NewsModel news1 = new NewsModel("title1","content1");
        mNewsModelsList.add(news1);
        NewsModel new2 = new NewsModel("title2","content2");
        mNewsModelsList.add(new2);
        return mNewsModelsList;
    }
}
