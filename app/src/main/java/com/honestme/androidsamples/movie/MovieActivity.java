package com.honestme.androidsamples.movie;

import android.graphics.Movie;
import android.os.Bundle;

import com.honestme.androidsamples.BaseActivity;

import java.util.List;

public class MovieActivity extends BaseActivity implements MovieController.MovieUi{

    @Override
    public void setCallBack(MovieController.MovieUiCallBacks callbacks) {

    }


    @Override
    public void setCollection(List<Movie> collection) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
