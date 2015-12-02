package com.honestme.androidsamples.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.common.base.Preconditions;
import com.honestme.androidsamples.BaseActivity;
import com.honestme.androidsamples.R;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements ListView.OnItemClickListener{

    MainAdapter mMainAdapter;
    MainController mMainController;
    MainDisplay mMainDisplay;

    ListView mListView;

    List<MainListItem> mItems = new ArrayList<MainListItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainAdapter = new MainAdapter(this);
        mMainAdapter.setItems(mItems);

        mMainController = new MainController();

        mListView =(ListView)findViewById(R.id.listview_main);

        mListView.setAdapter(mMainAdapter);
    }

    public static void actionStartIntent(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_main;
    }


    public void updateListResource(List<MainListItem> items){
        mItems = Preconditions.checkNotNull(items,"items can't be null");
        mMainAdapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (mItems.get(position).getName()){
            case "check user-permissions":
                mMainDisplay.showCheckPermissions();
        }
    }

    public void setItems(){
        MainListItem item1 = new MainListItem("check user-permissions");
        mItems.add(item1);
    }


}
