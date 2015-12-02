package com.honestme.androidsamples.main;

import android.content.Context;

import com.honestme.androidsamples.BaseDisplay;
import com.honestme.androidsamples.checkpermissions.CheckPermissionActivity;

/**
 * Created by Administrator on 2015/12/2 0002.
 */
public class MainDisplay extends BaseDisplay {

    public MainDisplay(Context context) {
        super(context);
    }

    public void showCheckPermissions(){
        CheckPermissionActivity.startActionIntent(mContext);
    }
}
