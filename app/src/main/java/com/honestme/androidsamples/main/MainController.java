package com.honestme.androidsamples.main;

import com.honestme.androidsamples.BaseUiController;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class MainController
        extends BaseUiController<MainController.MainUi,MainController.MainUiCallbacks> {


    public interface MainUi extends BaseUiController.Ui<MainUiCallbacks>{}

    public interface MainUiCallbacks{}

    public MainController(){

    }

    @Override
    protected MainUiCallbacks createUiCallBacks() {
        return new MainUiCallbacks() {
        };
    }

    @Override
    protected boolean onInited() {
        return super.init();
    }

    @Override
    protected boolean onSuspended() {

        return super.suspend();

    }
}
