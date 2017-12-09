package app.coolweather.com.myapplication.model.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import app.coolweather.com.myapplication.R;
import app.coolweather.com.myapplication.model.util.CartStorage;
import app.coolweather.com.myapplication.model.util.GoodsBeanInfo;
import app.coolweather.com.myapplication.model.util.StringConstant;

import static app.coolweather.com.myapplication.R.id.tv_shopping_cart_item_goods_post;


/**
 * Created by Administrator on 2017/11/20.
 */

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder>{

    private int value = 1;
    private int minValue = 1;
    private int maxValue = 99;
    //总价
    private TextView tvCountMoney;
    //总选择框
    private CheckBox checkBoxAll;
    private View itemView;
    private List<GoodsBeanInfo.ResultBean.GoodsBean> data;
    private Context mContext;
    private double price;
    private RelativeLayout rlTitleBar;
    private TextView shoppingCartDel;

    public ShoppingCartAdapter(Context mContext, List<GoodsBeanInfo.ResultBean.GoodsBean> allData, CheckBox cbSelectAll, TextView tvCountMoney, TextView shoppingCartDel) {
        this.mContext = mContext;
        this.data = allData;
        this.checkBoxAll = cbSelectAll;
        this.tvCountMoney = tvCountMoney;
        this.shoppingCartDel = shoppingCartDel;
        for(int i=0;i<data.size();i++){
            data.get(i).setCheck(false);
        }
        setListener();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = View.inflate(mContext, R.layout.shopping_cart_item, null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final GoodsBeanInfo.ResultBean.GoodsBean goodsBean = data.get(position);

        //图片
        String s = StringConstant.BANNNER_IMAGE + goodsBean.getFigure().split("/")[0];
        Glide.with(mContext).load(s).into(holder.ivShoppingCart);
        //名称
        String name = goodsBean.getName();
        holder.tvShoppingCartItemGoodsTitle.setText(name);
        //价格
        String cover_price = goodsBean.getCover_price();
        holder.tvShoppingCartItemGoodsPrice.setText("￥" + cover_price);
        //设置选择状态
        boolean isCheck = goodsBean.isCheck();
        holder.checkBox.setChecked(isCheck);
        //产品id
        String channel_id = goodsBean.getChannel_id();
        holder.tvShoppingCartItemGoodsModel.setText(channel_id);
        holder.tvShoppingCartItemGoodsModel1.setText(channel_id);
        //商品数量
        value = Integer.valueOf(goodsBean.getBrief());
        setValue(holder,goodsBean);

        //修改商品数量
        holder.tvShoppingCartItemGoodsPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.relativeLayout.setVisibility(View.GONE);
                holder.layout.setVisibility(View.VISIBLE);
            }
        });
        //减少
        holder.ivShoppingCartItemGoodsSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (value > minValue) {
                    value--;
                }
                if (value < 1) {
                    CartStorage.getInstance().delelDate(goodsBean);
                }
                setValue(holder,goodsBean);
                showTotalPrice();
                checkAll();
            }
        });
        //增加
        holder.ivShoppingCartItemGoodsAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (value < maxValue) {
                    value++;
                }
                setValue(holder,goodsBean);
                showTotalPrice();
                checkAll();
            }
        });
        //完成
        holder.btShoppingCartItemGoodsFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.layout.setVisibility(View.GONE);
                holder.relativeLayout.setVisibility(View.VISIBLE);
                setValue(holder,goodsBean);
            }
        });
        //选择
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goodsBean.setCheck(holder.checkBox.isChecked());
                showTotalPrice();
                checkAll();
            }
        });
    }


    private void showTotalPrice() {
        double totalPrices = 0;
        String cover_price = "￥0.0";
        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                GoodsBeanInfo.ResultBean.GoodsBean goodsBean = data.get(i);
                if (goodsBean.isCheck()) {
                    cover_price = goodsBean.getCover_price();
                    price = Double.valueOf(cover_price) * Double.valueOf(goodsBean.getBrief());
                    totalPrices = totalPrices + price;
                }
            }
        }
        tvCountMoney.setText("￥" + totalPrices);
    }

    public void deleteData() {
        for(int i=0;i<data.size();i++ ){
            if(data.get(i).isCheck()){
                CartStorage.getInstance().delelDate(data.get(i));
                data.remove(i);
                notifyItemRemoved(i);
                i--;
                showTotalPrice();
                checkAll();
            }
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private RelativeLayout relativeLayout;
        private LinearLayout linearLayout;
        private RelativeLayout layout;
        private ImageView ivShoppingCart;
        private TextView tvShoppingCartItemGoodsTitle;
        private TextView tvShoppingCartItemGoodsModel;
        private TextView tvShoppingCartItemGoodsPrice;
        private ImageView tvShoppingCartItemGoodsPost;
        private TextView tvShoppingCartItemGoodsNumber;
        private ImageView ivShoppingCartItemGoodsSub;
        private TextView tvShoppingCartItemGoodsNumber1;
        private ImageView ivShoppingCartItemGoodsAdd;
        private TextView tvShoppingCartItemGoodsModel1;
        private Button btShoppingCartItemGoodsFinish;

        public ViewHolder(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.rl_shopping_cart);
            linearLayout = itemView.findViewById(R.id.ll_shopping_cart);
            layout = itemView.findViewById(R.id.rl_shopping_cart_modification);
            ivShoppingCart = itemView.findViewById(R.id.iv_shopping_cart);
            tvShoppingCartItemGoodsTitle = itemView.findViewById(R.id.tv_shopping_cart_item_goods_title);
            tvShoppingCartItemGoodsModel = itemView.findViewById(R.id.tv_shopping_cart_item_goods_model);
            tvShoppingCartItemGoodsPrice = itemView.findViewById(R.id.tv_shopping_cart_item_goods_price);
            tvShoppingCartItemGoodsPost = itemView.findViewById(tv_shopping_cart_item_goods_post);
            tvShoppingCartItemGoodsNumber = itemView.findViewById(R.id.tv_shopping_cart_item_goods_number);
            ivShoppingCartItemGoodsSub = itemView.findViewById(R.id.iv_shopping_cart_item_goods_sub);
            tvShoppingCartItemGoodsNumber1 = itemView.findViewById(R.id.tv_shopping_cart_item_goods_number_1);
            ivShoppingCartItemGoodsAdd = itemView.findViewById(R.id.iv_shopping_cart_item_goods_add);
            tvShoppingCartItemGoodsModel1 = itemView.findViewById(R.id.tv_shopping_cart_item_goods_model_1);
            btShoppingCartItemGoodsFinish = itemView.findViewById(R.id.bt_shopping_cart_item_goods_finish);
            checkBox = itemView.findViewById(R.id.cb_shopping_cart);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(getLayoutPosition());
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(int position);
    }

    private OnItemClickListener onItemClickListener;

    private void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void setListener() {
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                GoodsBeanInfo.ResultBean.GoodsBean goodsBean = data.get(position);
                goodsBean.getName();
                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
            }
        });
        //全选
        checkBoxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = checkBoxAll.isChecked();
                if (data != null && data.size() > 0) {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setCheck(checked);
                        notifyItemChanged(i);
                    }
                    showTotalPrice();
                    checkAll();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

//        } else if (v == shoppingCartDel) {
//            if (data != null && data.size() > 0) {
//                for (int i = 0; i < data.size(); i++) {
//                    GoodsBeanInfo.ResultBean.GoodsBean goodsBean = data.get(i);
//                }
//            }
//        }
//    }

//
//    public int getValue() {
//        String valueStr = tvShoppingCartItemGoodsNumber1.getText().toString().trim();
//        if (!TextUtils.isEmpty(valueStr)) {
//            value = Integer.parseInt(valueStr);
//        }
//        return value;
//    }
//
    public void setValue(ViewHolder holder, GoodsBeanInfo.ResultBean.GoodsBean goodsBean) {
        if (value > 1) {
            holder.tvShoppingCartItemGoodsNumber.setTextColor(Color.parseColor("#111111"));
        }
        holder.tvShoppingCartItemGoodsNumber1.setText(value + "");
        holder.tvShoppingCartItemGoodsNumber.setText("x" + value);
        goodsBean.setBrief(Integer.toString(value));
        CartStorage.getInstance().upDate(goodsBean);
    }

    public void checkAll() {
        if (data != null && data.size() > 0) {
            int number = 0;
            for (GoodsBeanInfo.ResultBean.GoodsBean goodsBean : data) {
                if (goodsBean.isCheck()) {
                    number++;
                } else {
                    checkBoxAll.setChecked(false);
                    return;
                }
            }
            if (number == data.size()) {
                checkBoxAll.setChecked(true);
            }
        }else{
            checkBoxAll.setChecked(false);
        }
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

}

