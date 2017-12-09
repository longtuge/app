package app.coolweather.com.myapplication.model.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/11/14.
 */

public class CacheUtils {

    public static String getString(Context mContext, String key) {
        SharedPreferences sp = mContext.getSharedPreferences("taoBao",Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }

    public static void setString(Context mContext, String key,String value) {

        SharedPreferences sp = mContext.getSharedPreferences("taoBao",Context.MODE_PRIVATE);

        sp.edit().putString(key,value).commit();
    }

}



