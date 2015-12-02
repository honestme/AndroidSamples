package com.honestme.androidsamples.loading;

import android.app.Activity;

import com.honestme.androidsamples.BaseDisplay;
import com.honestme.androidsamples.main.MainActivity;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class LoadingDisplay extends BaseDisplay {
    private  Activity mActivity;

    public void action_start_mainactivity(){

        MainActivity.actionStartIntent(mActivity);
    }

    public LoadingDisplay(Activity activity) {
        mActivity = activity;
    }
}
