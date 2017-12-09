package app.coolweather.com.myapplication.model.util;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 * 工具类 保存购物车商品信息
 */

public class CartStorage {

    public static final String JSON_CART = "json_cart";
    private static CartStorage instance;
    public static Context mContext;
    private static List<GoodsBeanInfo.ResultBean.GoodsBean> goodsBeanList;


    public CartStorage(Context mContext) {
        this.mContext = mContext;

        //从数据库读取数据

    }

    //得到购物车实例
    public static CartStorage getInstance() {
        if (instance == null) {
            instance = new CartStorage(MyApplication.getContext());
        }
        goodsBeanList = getAllData();
        return instance;
    }

    public static List<GoodsBeanInfo.ResultBean.GoodsBean> getAllData() {

        goodsBeanList = new ArrayList<>();
//        数据库保存 未完善
//        CartDBHelper db = new CartDBHelper();
//        SQLiteDatabase database = db.getReadableDatabase();
//        database.toString();

        //本地文件保存
        String json = CacheUtils.getString(mContext, JSON_CART);
        if (!TextUtils.isEmpty(json)) {
            goodsBeanList = (new Gson().fromJson(json, new TypeToken<List<GoodsBeanInfo.ResultBean.GoodsBean>>() {
            }.getType()));
        }

        return goodsBeanList;
    }

    public void addData(GoodsBeanInfo.ResultBean.GoodsBean goodsBean) {
        boolean noHave = true;
        for (int i = 0; i < goodsBeanList.size(); i++) {
            if (goodsBeanList.get(i).getProduct_id().equals(goodsBean.getProduct_id())) {
                noHave = false;
                int number = Integer.valueOf(goodsBeanList.get(i).getBrief());
                number++;
                goodsBean.setBrief(Integer.toString(number));
                break;
            }

        }

        if (noHave) {
            goodsBean.setBrief("1");
        }

        //同步到本地
        saveLocal(goodsBean);

    }

    public void delelDate(GoodsBeanInfo.ResultBean.GoodsBean goodsBean) {

        for (int i = 0; i < goodsBeanList.size(); i++) {
            if (goodsBeanList.get(i).getProduct_id().equals(goodsBean.getProduct_id())) {
                goodsBeanList.remove(i);
                break;
            }
        }
        //同步到本地
        String json = new Gson().toJson(goodsBeanList);
        CacheUtils.setString(mContext, JSON_CART, json);
    }

    public void upDate(GoodsBeanInfo.ResultBean.GoodsBean goodsBean) {
        //同步到本地
        saveLocal(goodsBean);
    }

    private void saveLocal(GoodsBeanInfo.ResultBean.GoodsBean goodsBean) {

        boolean noHave = true;
        if (goodsBeanList.size() == 0) {
            goodsBeanList.add(goodsBean);
        } else {
            for (int i = 0; i < goodsBeanList.size(); i++) {
                if (goodsBeanList.get(i).getProduct_id().equals(goodsBean.getProduct_id())) {
                    noHave = false;
                    goodsBeanList.remove(i);
                    goodsBeanList.add(goodsBean);
                    break;
                }
            }

            if(noHave){
                goodsBeanList.add(goodsBean);
            }
        }

        String json = new Gson().toJson(goodsBeanList);
        CacheUtils.setString(mContext, JSON_CART, json);

    }
}