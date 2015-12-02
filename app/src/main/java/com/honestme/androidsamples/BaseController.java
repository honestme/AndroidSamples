package com.honestme.androidsamples;

import com.google.common.base.Preconditions;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class BaseController  {
        private boolean mInited;
        private BaseDisplay mDisplay;

        public BaseController(){

        }

        public final void attachDisplay(BaseDisplay display){
            Preconditions.checkArgument(display != null,"display can't be null");
            Preconditions.checkState(getDisplay() == null,"we already have a display");
            setDisplay(display);
        }

        public final void detachDisplay(BaseDisplay display){
            Preconditions.checkArgument(display != null,"display can't be null");
            Preconditions.checkState(getDisplay() == display, "display already be detached");
            setDisplay(null);
        }

        protected void setDisplay(BaseDisplay display){
            mDisplay = display;
        }

        public final BaseDisplay getDisplay(){
            return mDisplay;
        }

        public boolean init(){
            Preconditions.checkState(mInited == false, "Already inited");
            mInited = true;
            return onInited();
        }

        public boolean suspend(){
            Preconditions.checkState(mInited == true,"Not inited");

            mInited = false;
            return onSuspended();

        }

        public boolean isInited(){
            return mInited;
        }

        protected boolean onInited(){return true;}
        protected boolean onSuspended(){return true;}
}
