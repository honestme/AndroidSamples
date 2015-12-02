package com.honestme.androidsamples.loading;

import android.content.Context;
import android.os.Bundle;

import com.honestme.androidsamples.BaseActivity;
import com.honestme.androidsamples.BaseDisplay;
import com.honestme.androidsamples.R;

public class LoadingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_loading;
    }

    @Override
    public void handleIntent(Context context, BaseDisplay display) {

    }
}
