package com.honestme.androidsamples.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.honestme.androidsamples.R;

/**
 * Created by Administrator on 2015/12/3 0003.
 */
public class NewsContentFragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_content_activity,container);
        return mView;
    }
}
