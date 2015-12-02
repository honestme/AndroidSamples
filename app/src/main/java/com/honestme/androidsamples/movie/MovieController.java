package com.honestme.androidsamples.movie;

import android.graphics.Movie;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.Subscribe;
import com.honestme.androidsamples.BaseDisplay;
import com.honestme.androidsamples.BaseUiController;

import java.util.List;

/**
 * Created by Administrator on 2015/11/27 0027.
 */
public class MovieController extends BaseUiController<MovieController.MovieUi,MovieController.MovieUiCallBacks> {

    public interface MovieUi extends BaseUiController.Ui<MovieUiCallBacks>{
        void setCollection(List<Movie> collection);
    }

    public interface MovieUiCallBacks {}

    private final MovieUiCallBacks mMovieUiCallBacks;
    private final MovieState mMovieState;
    private final BaseDisplay mDisplay;


    public MovieController(MovieState movieState,BaseDisplay display){
        mMovieState = Preconditions.checkNotNull(movieState,"moviestate can't be null");
        mDisplay = Preconditions.checkNotNull(display,"display can't be null");

        mMovieUiCallBacks = new MovieUiCallBacks() {
        };
    }

    @Override
    protected boolean onInited() {
        super.onInited();

        mMovieState.registerForEvents(this);
        return true;
    }

    @Override
    protected boolean populateUi() {
        super.populateUi();

        if(getUi() != null) {
            mMovieState.setCollection(mMovieState.getCollection());
        }

        return true;
    }

    @Override
    protected MovieUiCallBacks createUiCallBacks() {
        return mMovieUiCallBacks;
    }

    @Override
    protected boolean onSuspended() {
        super.onSuspended();
        mMovieState.unRegisterForEvents(this);
        return true;
    }

    @Subscribe
    public void collectionChange(MovieState.CollectionChangedEvent collectionChangedEvent){
        populateUi();
    }

}

