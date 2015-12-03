package com.honestme.androidsamples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.*;
/**
 * Created by Administrator on 2015/12/3 0003.
 */
public class ExBaseAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected LayoutInflater mLayoutInflater;
    protected List<T> mList;
    protected int mResourceId;

    public ExBaseAdapter(Context context,int resourceId) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mList = new ArrayList<T>();
        mResourceId = resourceId;
    }

    public void setItems(ArrayList<T> arrayList){
        mList = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
