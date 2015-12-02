package com.honestme.androidsamples;

import com.google.common.base.Preconditions;
import com.squareup.otto.Bus;

/**
 * Created by Administrator on 2015/11/29 0029.
 */
public class BaseState {

    protected Bus mBus;

    public BaseState(Bus bus){
        mBus = Preconditions.checkNotNull(bus,"bus can't be null");
    }

    public void registerForEvents(Object receiver){
         mBus.register(receiver);
    }
    public void unRegisterForEvents(Object receiver){
        mBus.unregister(receiver);
    }
}
