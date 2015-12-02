package com.honestme.androidsamples.util;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    int resourceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.d(getLocalClassName(),getPackageName().getClass().getSimpleName(),null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void setLayoutView(int layoutView){
        resourceID = layoutView;

    }

    @Override
    public void onClick(View v) {

    }
}
