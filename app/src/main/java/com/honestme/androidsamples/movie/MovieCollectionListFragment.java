package com.honestme.androidsamples.movie;

import android.app.ListFragment;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class MovieCollectionListFragment extends ListFragment implements MovieController.MovieUi{

    MovieController mMovieController;

    private MovieController.MovieUiCallBacks mMovieUiCallBacks;

    private MovieAdapter mMovieAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMovieAdapter = new MovieAdapter(getActivity());
        this.setListAdapter(mMovieAdapter);

        setListShown(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMovieController.attachUi(this);

    }

    @Override
    public void onPause() {
        mMovieController.detachUi(this);
        super.onPause();

    }

    @Override
    public void setCollection(List<Movie> collection) {
        mMovieAdapter.setSource(collection);
        setListShown(true);
    }

    @Override
    public void setCallBack(MovieController.MovieUiCallBacks callbacks) {
        mMovieUiCallBacks = callbacks;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
