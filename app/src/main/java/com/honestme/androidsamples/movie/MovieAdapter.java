package com.honestme.androidsamples.movie;

import android.content.Context;
import android.graphics.Movie;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class MovieAdapter extends BaseAdapter {

    private final Context mContext;

    private List<Movie> mMovieList;

    public MovieAdapter(Context context){
        super();
        mContext = context;
    }

    public void setSource(List<Movie> movieList){
        mMovieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return mMovieList.get(position);
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
