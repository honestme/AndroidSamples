package com.honestme.androidsamples.Fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.honestme.androidsamples.ExBaseAdapter;
import com.honestme.androidsamples.R;

/**
 * Created by Administrator on 2015/12/3 0003.
 */
public class FragmentAdapter extends ExBaseAdapter<NewsModel> {

    public FragmentAdapter(Context context, int resourceId) {
        super(context, resourceId);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsModel newsItem = (NewsModel)getItem(position);

        TextView textViewTitle;
        ViewHolder viewHolder;
        if(convertView != null){
            viewHolder = (ViewHolder)convertView.getTag();
            textViewTitle = viewHolder.getTextView();
        }else {
            convertView = mLayoutInflater.inflate(mResourceId,parent);
            textViewTitle = (TextView)convertView.findViewById(R.id.fragment_listitem_title);
            viewHolder = new ViewHolder(textViewTitle);
            convertView.setTag(viewHolder);
        }

        textViewTitle.setText(newsItem.getTitle());
        return convertView;
    }

    private class ViewHolder{
        TextView mTextView;

        public ViewHolder(TextView textView){
            mTextView = textView;
        }

        public TextView getTextView() {
            return mTextView;
        }
    }
}
