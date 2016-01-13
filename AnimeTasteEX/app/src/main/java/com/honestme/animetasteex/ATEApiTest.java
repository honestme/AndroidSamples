package com.honestme.animetasteex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangconglin on 2016/1/12.
 */
public class ATEApiTest {

    public void createTest(int type,int page){
        List<ATEItem> list = ATEApiUtil.getDataFromUri(type,page);

        for(int i = 0;i<list.size();++i){
            LogUtil.d("TEST",list.get(i).toString());
        }
    }
}
