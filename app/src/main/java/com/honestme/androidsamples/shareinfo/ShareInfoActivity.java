package com.honestme.androidsamples.shareinfo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ShareActionProvider;

import com.google.common.base.Preconditions;
import com.honestme.androidsamples.BaseActivity;
import com.honestme.androidsamples.BaseDisplay;
import com.honestme.androidsamples.R;

import java.util.ArrayList;
import java.util.Map;
/**
 * Created by Administrator on 2015/12/3 0003.
 */
public class ShareInfoActivity extends BaseActivity implements View.OnClickListener {

    Button mButtonShareText;
    Button mButtonShareBinary;
    Button mButtonShareMuti;
    Button mButtonShareFile;

    ShareActionProvider mShareActionProvider;

    @Override
    public void handleIntent(Context context, BaseDisplay display) {

    }

    @Override
    protected int setLayoutResource() {
        return super.setLayoutResource();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mButtonShareText = (Button)findViewById(R.id.bt_share_text);
        mButtonShareBinary = (Button)findViewById(R.id.bt_share_binary);
        mButtonShareMuti = (Button)findViewById(R.id.bt_share_muti);
        mButtonShareFile = (Button)findViewById(R.id.bt_share_file);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_share_text:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra(Intent.EXTRA_TEXT, "hello,this is a share message");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"please choose..."));
                break;
            case R.id.bt_share_binary:
                Map<String,Object> map = new ArrayMap<>();
                map.put("action type",Intent.ACTION_VIEW);
                map.put("content type",Intent.EXTRA_STREAM);
                map.put("content","");
                map.put("type","image/*");
                map.put("title","please choose");
                break;
            case R.id.bt_share_muti:
                ArrayList<Uri> uriList = new ArrayList<Uri>();
                Intent intent_muti = new Intent(Intent.ACTION_SEND_MULTIPLE);
                intent_muti.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uriList);
                intent_muti.setType("image/*");
                startActivity(Intent.createChooser(intent_muti,"please choose..."));
        }
    }

    private void startShareIntent(Map map){
        Intent intent = new Intent((String)map.get("action type"));
        intent.putExtra((String)map.get("content type"), (String)map.get("content"));
        intent.setType((String) map.get("type"));
        startActivity(Intent.createChooser(intent, (String) map.get("title")));
    }

    public static void startActionIntent(Context context) {
        Intent intent = new Intent(context,ShareInfoActivity.class);
        context.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem menuItem = menu.getItem(R.id.action_share);

        mShareActionProvider = (ShareActionProvider)menuItem.getActionProvider();

        return true;
    }

    public void setShareIntent(Intent intent){
        Preconditions.checkNotNull(intent,"intent can't be null");
        mShareActionProvider.setShareIntent(intent);
    }
}
