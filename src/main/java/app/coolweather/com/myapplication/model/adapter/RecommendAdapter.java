package app.coolweather.com.myapplication.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.coolweather.com.myapplication.R;
import app.coolweather.com.myapplication.model.util.ResultBaseData;
import app.coolweather.com.myapplication.model.util.StringConstant;

/**
 * Created by Administrator on 2017/11/2.
 */

public class RecommendAdapter extends BaseAdapter {


    private final Context mContext;
    private final List<ResultBaseData.ResultBean.RecommendInfoBean> data;

    public RecommendAdapter(Context mContext, List<ResultBaseData.ResultBean.RecommendInfoBean> data) {

        this.mContext = mContext;

        this.data = data ;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null ){
            view = new View(mContext);
            view = View.inflate(mContext,R.layout.recommend_item,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_recommend_item = view.findViewById(R.id.iv_recommend_item);
            viewHolder.tv_recommend_item = view.findViewById(R.id.tv_recommend_item);
            viewHolder.tv_recommend_item_price = view.findViewById(R.id.tv_recommend_item_price);
            viewHolder.tv_recommend_item_buy = view.findViewById(R.id.tv_recommend_item_buy);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        ResultBaseData.ResultBean.RecommendInfoBean recommendInfoBean = data.get(i);
        String figure = StringConstant.BANNNER_IMAGE_URL + recommendInfoBean.getFigure();
        //填充图片
        viewHolder.iv_recommend_item.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(mContext).load(figure).into(viewHolder.iv_recommend_item);
        viewHolder.tv_recommend_item.setText(recommendInfoBean.getName());
        viewHolder.tv_recommend_item_price.setText(recommendInfoBean.getCover_price());
        viewHolder.tv_recommend_item_buy.setText(recommendInfoBean.getProduct_id()+"人已购买");

        return view;
    }

    class ViewHolder {
        private ImageView iv_recommend_item;
        private TextView tv_recommend_item;
        private TextView tv_recommend_item_price;
        private TextView tv_recommend_item_buy;
    }
}
