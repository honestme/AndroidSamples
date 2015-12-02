package com.honestme.androidsamples.login;

import com.honestme.androidsamples.BaseUiController;
import com.honestme.androidsamples.util.TextUtil;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class LoginController extends BaseUiController<LoginController.LoginUi,LoginController.LoginUiCallbacks> {

    private final LoginState mLoginState;
    private final LoginDisplay mLoginDisplay;


    public interface LoginUi extends BaseUiController.Ui<LoginUiCallbacks>{

    }

    public interface LoginUiCallbacks{
        public void login(String userName, String passWord);
    }

    public LoginController(LoginState LoginState, LoginDisplay LoginDisplay){
        mLoginState = LoginState;
        mLoginDisplay = LoginDisplay;
       
    }

    @Override
    protected boolean onInited() {
        super.onInited();

        if(validCredentials()){
            mLoginDisplay.showLoginFragment();
        }else {
            return false;
        }

        return true;

    }

    public boolean validCredentials(){
        return !TextUtil.isEmpty(mLoginState.getUserName())
                && !TextUtil.isEmpty(mLoginState.getHashPassword());
    }

    @Override
    protected boolean populateUi() {
        return super.populateUi();
    }

    @Override
    protected LoginUiCallbacks createUiCallBacks() {
        return new LoginUiCallbacks() {
            @Override
            public void login(String userName, String passWord) {

            }
        };
    }

    @Override
    protected boolean onSuspended() {
        mLoginState.unRegisterForEvents(this);
        return super.onSuspended();
    }
}
