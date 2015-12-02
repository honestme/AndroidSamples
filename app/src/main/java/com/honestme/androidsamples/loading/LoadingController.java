package com.honestme.androidsamples.loading;

import com.google.common.base.Preconditions;
import com.honestme.androidsamples.BaseUiController;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class LoadingController extends
        BaseUiController<LoadingController.LoadingUi,LoadingController.LoadingUiCallbacks> {


    private final LoadingState mLoadingState;
    private final LoadingDisplay mLoadingDisplay;


    public interface LoadingUi extends BaseUiController.Ui<LoadingUiCallbacks>{

    }

    public interface LoadingUiCallbacks{}

    public LoadingController(LoadingState loadingState, LoadingDisplay loadingDisplay) {
        mLoadingState = Preconditions.checkNotNull(loadingState,"loadingState can't be null");
        mLoadingDisplay = Preconditions.checkNotNull(loadingDisplay,"loadingDilsplay can't be null");

    }

    @Override
    protected LoadingUiCallbacks createUiCallBacks() {
        return new LoadingUiCallbacks() {
        };
    }


}
