package com.cth.cuotiben.common;

import android.content.ContentValues;

import java.io.Serializable;

/**
 * BaseInfo
 * Created by yangjiajia on 2017/5/8 0008.
 */

public class BaseInfo implements Serializable {

    public final static int NO_ID = -1;
    public int userType = -1;
    public long id = NO_ID;
    public BaseInfo() {
    }

    public BaseInfo(BaseInfo info){
        id = info.id;
        userType = info.userType;
    }

    public void onAddToDatabase(ContentValues values) {
        //values.put("_id",id);
    }
}
