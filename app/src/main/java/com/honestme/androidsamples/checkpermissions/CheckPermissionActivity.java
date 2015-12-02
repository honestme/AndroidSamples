package com.honestme.androidsamples.checkpermissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.honestme.androidsamples.BaseActivity;
import com.honestme.androidsamples.BaseDisplay;
import com.honestme.androidsamples.R;
import com.honestme.androidsamples.util.Constants;

/**
 * Created by Administrator on 2015/12/2 0002.
 */
public class CheckPermissionActivity extends BaseActivity {

    private Activity mActivity = this;
    private Context mContext = CheckPermissionActivity.this;

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_checkpermissions;
    }

    @Override
    public void handleIntent(Context context, BaseDisplay display) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public static void startActionIntent(Context context) {
        Intent intent = new Intent(context,CheckPermissionActivity.class);
        context.startActivity(intent);
    }


    //check if the permissions we need is granted by user.Usually,if user reject our request,
    //we build a explanation dialog to explain to user why we need the permission.
    public void checkPermissions(){
        if(ContextCompat.checkSelfPermission(mContext,
                Manifest.permission.MODIFY_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(mActivity,
                    Manifest.permission.MODIFY_PHONE_STATE)){

            }else {
                ActivityCompat.requestPermissions(mActivity,
                        new String[]{Manifest.permission.MODIFY_PHONE_STATE},
                        Constants.MY_PERMISSION_REQUEST_MODIFY_PHONE_STATE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case Constants.MY_PERMISSION_REQUEST_MODIFY_PHONE_STATE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }else {

                }
                break;

            default:break;
        }
    }
}
