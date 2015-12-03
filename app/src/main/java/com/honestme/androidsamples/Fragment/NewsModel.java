package com.honestme.androidsamples.Fragment;

/**
 * Created by Administrator on 2015/12/3 0003.
 */
public class NewsModel {
    private String mTitle;
    private String mContent;

    public NewsModel(String title, String content){
        mTitle = title;
        mContent = content;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }
}
