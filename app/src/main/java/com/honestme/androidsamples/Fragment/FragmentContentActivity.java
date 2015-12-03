package com.honestme.androidsamples.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.honestme.androidsamples.BaseActivity;
import com.honestme.androidsamples.BaseDisplay;
import com.honestme.androidsamples.R;

/**
 * Created by Administrator on 2015/12/3 0003.
 */
public class FragmentContentActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void handleIntent(Context context, BaseDisplay display) {
        super.handleIntent(context, display);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.fragment_content_activity;
    }

    public static void startActionIntent(Context context,String title,String content){
        Intent intent = new Intent(context,FragmentActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        context.startActivity(intent);
    }
}
