package app.coolweather.com.myapplication.presenter;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import app.coolweather.com.myapplication.model.util.BaseFragment;

/**
 * Created by Administrator on 2017/10/25.
 */

public class UserBaseFragment extends BaseFragment {

    private TextView textView;
    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i("baseFragment","UserBaseFragment");
        textView.setText("user");
    }
}
