package com.honestme.androidsamples;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class BaseActivity extends AppCompatActivity implements BaseUiController.HostCallbacks{

    private Context mContext;
    BaseUiController mController;
    BaseDisplay mDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResource());

        handleIntent(mContext,mDisplay);
    }

    @Override
    protected void onPause() {
        mController.suspend();
        mController.detachDisplay(mDisplay);
        mController.setHostCallbacks(null);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mController.populateUi();
        mController.attachDisplay(mDisplay);
        mController.setHostCallbacks(this);
    }

    protected void setController(BaseUiController controller){
        mController = controller;
    }

    protected void setDisplay(BaseDisplay display){
        mDisplay = display;
    }

    protected int setLayoutResource(){
        return 0;
    }

    public void handleIntent(Context context, BaseDisplay display){

    }

}
