package com.honestme.androidsamples.main;

import com.google.common.base.Preconditions;
import com.honestme.androidsamples.BaseController;
import com.honestme.androidsamples.login.LoginController;
import com.honestme.androidsamples.movie.MovieController;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class MainController extends BaseController {
    MovieController mMovieController;
    LoginController mUserController;

    public MainController(MovieController movieController,LoginController userController){
        mMovieController = Preconditions.checkNotNull(movieController,"movieController can't be null");
        mUserController = Preconditions.checkNotNull(userController,"usercontroller can't be null");

    }

    public MovieController getMovieController(){
        return  mMovieController;
    }

    @Override
    protected boolean onInited() {
        return mMovieController.init() && mUserController.init();
    }

    @Override
    protected boolean onSuspended() {

        return mMovieController.suspend();

    }
}
