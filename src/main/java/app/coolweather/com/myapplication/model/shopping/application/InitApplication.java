package app.coolweather.com.myapplication.model.shopping.application;


import android.app.Application;

import app.coolweather.com.myapplication.model.shopping.common.config.SharePreferenceUtilNew;
import app.coolweather.com.myapplication.model.shopping.common.util.ToastHelper;
import app.coolweather.com.myapplication.model.shopping.db.DBHelper;
import app.coolweather.com.myapplication.model.shopping.http.VollyHelperNew;


public class InitApplication extends Application {
    private static InitApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initVollyHelper();
        initSharePreferenceUtil();
        initToastHelper();
        initDBHelper();
    }

    private void initDBHelper() {
        DBHelper.init(getApplicationContext());
    }

    public static InitApplication getInstance() {
        if (mInstance == null) {
            mInstance = new InitApplication();
        }
        return mInstance;
    }

    private void initVollyHelper() {
        VollyHelperNew.getInstance().initVollyHelper(getApplicationContext());
    }

    private void initSharePreferenceUtil() {
        SharePreferenceUtilNew.getInstance().init(getApplicationContext());
    }

    private void initToastHelper() {
        ToastHelper.getInstance().init(getApplicationContext());
    }
}