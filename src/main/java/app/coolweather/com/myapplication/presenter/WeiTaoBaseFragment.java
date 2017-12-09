package app.coolweather.com.myapplication.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import app.coolweather.com.myapplication.R;
import app.coolweather.com.myapplication.model.adapter.WeiTaoAdapter;
import app.coolweather.com.myapplication.model.util.BaseFragment;
import app.coolweather.com.myapplication.model.util.StringConstant;
import okhttp3.Call;

/**
 * Created by Administrator on 2017/10/25.
 */

public class WeiTaoBaseFragment extends BaseFragment {

    private LinearLayout weiTaoTitle;
    private ImageView weiTaoCheck;
    private RecyclerView weiTaoRecyclerView;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.wei_tao,null);
        weiTaoTitle = (LinearLayout)view.findViewById( R.id.wei_tao_title );
        weiTaoCheck = (ImageView)view.findViewById( R.id.wei_tao_check );
        weiTaoRecyclerView = (RecyclerView)view.findViewById( R.id.wei_tao_recycler_view );
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

    private void processData(String response) {
        WeiTaoAdapter adapter = new WeiTaoAdapter(mContext,response);
        weiTaoRecyclerView.setAdapter(adapter);
        weiTaoRecyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    }


}
