package app.coolweather.com.myapplication.model.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import app.coolweather.com.myapplication.R;

/**
 * Created by Administrator on 2017/11/9.
 */

public class MyAdapter extends BaseAdapter {

    private List<Map<String, Object>> list;
    private Context mContext;



    public MyAdapter(Context mContext, List<Map<String, Object>> data) {
        this.list = data;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.lv_popup_window_item, null);
            holder=new ViewHolder();

            holder.text= convertView.findViewById(R.id.tv_popup_window_item);
            holder.image = convertView.findViewById(R.id.iv_popup_window_item);

            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder) convertView.getTag();
        }
        holder.text.setText((String)list.get(position).get("text"));
        holder.image.setImageResource((Integer) list.get(position).get("image"));

        return convertView;
    }


    class ViewHolder {
        private ImageView image;
        private TextView text;

    }
}
