package com.honestme.androidsamples.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.honestme.androidsamples.BaseActivity;
import com.honestme.androidsamples.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void actionStartIntent(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_main;
    }
}
