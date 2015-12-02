package com.honestme.androidsamples.login;

import com.honestme.androidsamples.BaseState;
import com.squareup.otto.Bus;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class LoginState extends BaseState{

    private String mUserName;
    private String mPassWord;

    public LoginState(Bus bus) {
        super(bus);
    }

    public String getUserName(){
        return mUserName;
    }

    public String getHashPassword(){
        return mPassWord;
    }

    public void setCredentials(String userName, String passWord){
        mUserName = userName;
        mPassWord = passWord;
        mBus.post(new UserLoginEvent());
    }

    public static class UserLoginEvent{}


}
