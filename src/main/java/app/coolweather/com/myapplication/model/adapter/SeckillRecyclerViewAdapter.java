package app.coolweather.com.myapplication.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.coolweather.com.myapplication.R;
import app.coolweather.com.myapplication.model.util.ResultBaseData;
import app.coolweather.com.myapplication.model.util.StringConstant;

/**
 * Created by Administrator on 2017/11/1.
 */

public class SeckillRecyclerViewAdapter extends RecyclerView.Adapter<SeckillRecyclerViewAdapter.ViewHolder> {

    private final List<ResultBaseData.ResultBean.SeckillInfoBean.ListBean> list;

    private Context mContext;

    private LayoutInflater mLayoutInflater;




    public SeckillRecyclerViewAdapter(Context mContext, List<ResultBaseData.ResultBean.SeckillInfoBean.ListBean> list) {
        this.mContext = mContext ;
        this.list = list ;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext,R.layout.seckill_item,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //获取对应位置数据
        ResultBaseData.ResultBean.SeckillInfoBean.ListBean listBean = list.get(position);
        //绑定数据
        Glide.with(mContext).load(StringConstant.BANNNER_IMAGE_URL+listBean.getFigure()).into(holder.iv_seckill_item);
        holder.tv_origin_price.setText(listBean.getOrigin_price());
        holder.tv_seckill_item.setText(listBean.getCover_price());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView iv_seckill_item;

        private TextView  tv_seckill_item;

        private TextView tv_origin_price;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_seckill_item = itemView.findViewById(R.id.iv_seckill_item);
            tv_seckill_item = itemView.findViewById(R.id.tv_seckill_item);
            tv_origin_price = itemView.findViewById(R.id.tv_origin_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onSeckillRecyclerView !=null){
                        onSeckillRecyclerView.onItemClick(getLayoutPosition());
                    }
                }
            });
        }

    }

    public interface OnSeckillRecyclerView {

        public void onItemClick (int position);
    }

    public OnSeckillRecyclerView onSeckillRecyclerView;

    public void SetOnSeckillRecyclerView (OnSeckillRecyclerView onSeckillRecyclerView){

        this.onSeckillRecyclerView = onSeckillRecyclerView ;
    }

}








