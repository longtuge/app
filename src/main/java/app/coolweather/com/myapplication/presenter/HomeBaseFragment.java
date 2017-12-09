package app.coolweather.com.myapplication.presenter;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import app.coolweather.com.myapplication.R;
import app.coolweather.com.myapplication.model.util.BaseFragment;
import app.coolweather.com.myapplication.model.adapter.HomeFragmentAdapter;
import app.coolweather.com.myapplication.model.util.ResultBaseData;
import app.coolweather.com.myapplication.model.util.StringConstant;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;

/**
 * Created by Administrator on 2017/10/25.
 */

public class HomeBaseFragment extends BaseFragment {

    @BindView(R.id.rv_home)
    RecyclerView rvHome;
    Unbinder unbinder;
    private HomeFragmentAdapter adapter;
    private ResultBaseData.ResultBean result;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.home_fragment, null);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        //联网请求
        OkHttpUtils
                .get()
                .url(StringConstant.HOME_URL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("HomeBaseFragment","initData() onError"+e.toString()+"  id:"+id);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        processData(response);
                    }


                });
    }

    private void processData(String json) {
        ResultBaseData resultBaseData = JSON.parseObject(json, ResultBaseData.class);
        result = resultBaseData.getResult();
        if (result != null) {
            //有数据，设置适配器
            Log.e("HomeBaseFragment","有数据");

            adapter = new HomeFragmentAdapter(mContext, result);

            rvHome.setAdapter(adapter);
            //设置布局管理器
            rvHome.setLayoutManager(new GridLayoutManager(mContext,1));
        } else {
            //没有数据
            Log.e("HomeBaseFragment","没有数据");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
