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
 * Created by Administrator on 2017/10/28.
 */

public class ChannelAdapter extends BaseAdapter {

    private Context mContext;
    private List<ResultBaseData.ResultBean.ChannelInfoBean> channel_info;
    public ChannelAdapter(Context mContext, List<ResultBaseData.ResultBean.ChannelInfoBean> channel_info) {
        this.mContext = mContext;
        this.channel_info = channel_info ;
    }

    @Override
    public int getCount() {
        return channel_info.size();
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
        ViewHolder viewHolder ;
        if(view == null){
            view = View.inflate(mConte xt, R.layout.channel_item, null);
            viewHolder = new ViewHolder();
            viewHolder.gl_image = view.findViewById(R.id.gl_image);
            viewHolder.gl_text = view.findViewById(R.id.gl_text);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        String image = channel_info.get(i).getImage();
        Glide.with(mContext).load(StringConstant.BANNNER_IMAGE_URL+image).into(viewHolder.gl_image);
        viewHolder.gl_text.setText(channel_info.get(i).getChannel_name());
        return view;
    }

    class ViewHolder {
        private ImageView gl_image;
        private TextView gl_text;
    }
}
