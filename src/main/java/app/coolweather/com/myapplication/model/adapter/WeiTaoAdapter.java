package app.coolweather.com.myapplication.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import app.coolweather.com.myapplication.R;

/**
 * Created by Administrator on 2017/12/5.
 */

public class WeiTaoAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private String data;

    public WeiTaoAdapter(Context mContext, String response) {
        this.mContext = mContext;
        this.data = response;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.wei_tao_item,null);
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
