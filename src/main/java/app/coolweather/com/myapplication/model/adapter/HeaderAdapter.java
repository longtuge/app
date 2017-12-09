package app.coolweather.com.myapplication.model.adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import app.coolweather.com.myapplication.model.util.ItemArticle;

/**
 * Created by Administrator on 2017/10/23.
 */

public class HeaderAdapter extends PagerAdapter {

    private static final String LOG="NEWS_LONG";

    private Activity context;
    private List<ItemArticle> articles;
    private List<SimpleDraweeView> images = new ArrayList<SimpleDraweeView>();

    public HeaderAdapter(Activity context, List<ItemArticle> articles) {
        this.context = context;
        if(articles == null || articles.size() == 0){
            articles = new ArrayList<>();
        }else{
            this.articles = articles;
        }

        for(int i = 0 ;i < articles.size() ; i++){
            SimpleDraweeView image = new SimpleDraweeView(context);
            Uri uri = Uri.parse(articles.get(i).getImageUrl());
            image.setImageURI(uri);
            images.add(image);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(images.get(position));
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }



}
