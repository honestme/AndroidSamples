package com.honestme.androidsamples.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.honestme.androidsamples.R;

import java.util.List;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class MainAdapter extends BaseAdapter {

    List<MainListItem> mItems;

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private TextView mTextView;

    public MainAdapter(Context context){
        mContext = context;
        mLayoutInflater =(LayoutInflater)LayoutInflater.from(mContext);

    }

    public void setItems(List<MainListItem> items){
        mItems = items;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView != null){
            viewHolder =(ViewHolder)convertView.getTag();
            mTextView = viewHolder.mTextView;
        }else{
            convertView = mLayoutInflater.inflate(R.layout.main_list_item,null);
            mTextView = (TextView)convertView.findViewById(R.id.listview_main_textview);
            viewHolder = new ViewHolder(mTextView);
            convertView.setTag((Object)viewHolder);
        }

        mTextView.setText(mItems.get(position).getName());

        return null;
    }

    private class ViewHolder{
        public TextView mTextView;

        public ViewHolder(TextView textView){
            mTextView = textView;
        }
    }
}
