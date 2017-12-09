package app.coolweather.com.myapplication.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.coolweather.com.myapplication.R;
import app.coolweather.com.myapplication.model.util.CartStorage;
import app.coolweather.com.myapplication.model.util.GlideImageLoader;
import app.coolweather.com.myapplication.model.util.GoodsBeanInfo;
import app.coolweather.com.myapplication.model.util.MyAdapter;
import app.coolweather.com.myapplication.model.util.MyScrollView;
import app.coolweather.com.myapplication.model.util.StringConstant;
import butterknife.ButterKnife;

import static app.coolweather.com.myapplication.R.id.rb_goods_info_item_1;
import static app.coolweather.com.myapplication.R.mipmap.goods2;

public class GoodsInfoActivity extends Activity implements View.OnClickListener, MyScrollView.ScrollViewListener {

    private Context mContext;
    private MyScrollView myScrollViewOne;
    private MyScrollView myScrollViewTwo;
    private Banner banner;
    private TextView tvGoodsTitle;
    private Button btGoodsTitle;
    private TextView tvGoodsPrice;
    private TextView tvGoodsTitleExpress;
    private TextView tvGoodsTitleSales;
    private TextView tvGoodsTitleLocation;
    private LinearLayout llGoodsPledge;
    private LinearLayout llGoodsSelect;
    private LinearLayout llGoodsParameter;
    private LinearLayout goodsEstimatePingjia;
    private TextView tvGoodsEstimatePingjiashu;
    private TextView tvGoodsEstimateUser;
    private TextView tvGoodsEstimatePingjia;
    private TextView tvGoodsEstimateTime;
    private RelativeLayout goodsEstimateMendian;
    private TextView tvGoodsEstimateMendianName;
    private TextView tvGoodsEstimateMendianJuli;
    private TextView tvGoodsEstimateMendianDizhi;
    private RelativeLayout goodsEstimateWenti;
    private TextView textView5;
    private TextView goodsEstimateWenti1;
    private TextView goodsEstimateWenti11;
    private TextView goodsEstimateWenti2;
    private TextView goodsEstimateWenti21;
    private LinearLayout goodsEstimateLogo;
    private ImageView ivGoodsEstimateLogo;
    private TextView goodsEstimateLogoName;
    private LinearLayout goodsEstimateShangpin;
    private ImageView ivGoodsEstimateLogeFenlei;
    private ImageView ivGoodsEstimateLogeJindian;
    private LinearLayout goodsTitle;
    private ImageView ibGoodsTitle;
    private RadioButton rbGoodsInfoItem1;
    private RadioButton rbGoodsInfoItem2;
    private RadioButton rbGoodsInfoItem3;
    private RadioButton rbGoodsInfoItem4;
    private ImageButton ibGoods1;
    private ImageButton ibGoods2;
    private ImageButton ibGoods3;
    private RadioGroup radioGroup;
    private RadioButton rbGoodsDianpu;
    private RadioButton rbGoodsKefu;
    private RadioButton rbGoodsShoucang;
    private RadioButton rbGoodsCar;
    private RadioButton rbGoodsBuy;
    private LinearLayout linearLayout;
    private TextView tvGoodsMessage;
    private TextView tvGoodsHome;
    private TextView tvGoodsHelp;
    private TextView tvGoodsFeedback;
    private TextView tvGoodsShare;
    private RadioGroup rgGoodsTitle;
    private LinearLayout goodsImage;
    private LruCache<String, Bitmap> mMemoryCache;
    private Intent intent;
    private PopupWindow popupWindow;
    private ListView listView;
    private List<Map<String, Object>> listData;
    private GoodsBeanInfo.ResultBean.GoodsBean goodsBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        ButterKnife.bind(this);


        this.mContext = this;
        Glide.with(this);
        findViews();
        init();
        initListener();

    }

    private void init() {
        goodsTitle.setAlpha(0f);


        Intent intent = getIntent();

        goodsBean = (GoodsBeanInfo.ResultBean.GoodsBean) intent.getSerializableExtra("goods_bean");
        //轮播图片集合
        List<String> images = new ArrayList<>();
        String[] split = goodsBean.getFigure().split("/");
        String image;
        for (int i=0;i<split.length;i++){
            image = StringConstant.BANNNER_IMAGE + split[i];
            images.add(image);
        }
        Glide.with(mContext).load(images.get(0)).into(ibGoodsTitle);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置自动轮播，默认为true
        banner.isAutoPlay(false);
        //设置点击事件
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
            }
        });
        //banner的滑动监听
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        //获取屏幕宽度
        WindowManager windowManager = getWindowManager();
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;

        addImage(widthPixels);


    }

    private void initPopupWindow() {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.ll, null);
        listView = contentView.findViewById(R.id.lv_popupWindow);
        int[] id = {R.mipmap.goods_message, R.mipmap.goods_home, R.mipmap.goods_help, R.mipmap.goods_feedback, R.mipmap.goods_share};
        String[] text = {"消息", "首页", "帮助", "我要反馈", "分享"};
        listData = new ArrayList<>();
        Map<String, Object> map;
        for (int i = 0; i < 5; i++) {
            map = new HashMap<>();
            map.put("image", id[i]);
            map.put("text", text[i]);
            listData.add(map);
        }

        MyAdapter adapter = new MyAdapter(mContext, listData);
        listView.setAdapter(adapter);


        popupWindow = new PopupWindow(contentView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        popupWindow.showAsDropDown(ibGoods3, -270, 20);
    }

    //加载详情页面图片
    private void addImage(int widthPixels) {
        Bitmap bitmap;
        ImageView imageView;


        int[] id = {R.mipmap.goods1, goods2, R.mipmap.goods3, R.mipmap.goods4, R.mipmap.goods5, R.mipmap.goods6, R.mipmap.goods7};

        for (int i = 0; i < id.length; i++) {

            imageView = new ImageView(mContext);
            Glide.with(this).load(id[i]).diskCacheStrategy(DiskCacheStrategy.RESULT).into(imageView);
            goodsImage.addView(imageView);
        }

    }

    private void initListener() {
        ViewTreeObserver observer = myScrollViewOne.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                myScrollViewOne.setScrollViewListener(GoodsInfoActivity.this);

            }
        });
    }

    @Override
    public void onScrollChanged(int x, int y, int oldX, int oldY) {
        int height = banner.getHeight();
        if (y <= 0) {

        } else if (y > 0 && y <= height) {
            float scale = (float) y / height;
            float alpha = (float) (scale * 1.3);
            goodsTitle.setAlpha(alpha);

        }

    }


    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-07 11:10:39 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        goodsImage = findViewById(R.id.goods_image);
        myScrollViewOne = (MyScrollView) findViewById(R.id.my_scroll_view_one);
        myScrollViewTwo = (MyScrollView) findViewById(R.id.my_scroll_view_two);
        banner = (Banner) findViewById(R.id.goods_banner);
        tvGoodsTitle = (TextView) findViewById(R.id.tv_goods_title);
        btGoodsTitle = (Button) findViewById(R.id.bt_goods_title);
        tvGoodsPrice = (TextView) findViewById(R.id.tv_goods_price);
        tvGoodsTitleExpress = (TextView) findViewById(R.id.tv_goods_title_express);
        tvGoodsTitleSales = (TextView) findViewById(R.id.tv_goods_title_sales);
        tvGoodsTitleLocation = (TextView) findViewById(R.id.tv_goods_title_location);
        llGoodsPledge = (LinearLayout) findViewById(R.id.ll_goods_pledge);
        llGoodsSelect = (LinearLayout) findViewById(R.id.ll_goods_select);
        llGoodsParameter = (LinearLayout) findViewById(R.id.ll_goods_parameter);
        goodsEstimatePingjia = (LinearLayout) findViewById(R.id.goods_estimate_pingjia);
        tvGoodsEstimatePingjiashu = (TextView) findViewById(R.id.tv_goods_estimate_pingjiashu);
        tvGoodsEstimateUser = (TextView) findViewById(R.id.tv_goods_estimate_user);
        tvGoodsEstimatePingjia = (TextView) findViewById(R.id.tv_goods_estimate_pingjia);
        tvGoodsEstimateTime = (TextView) findViewById(R.id.tv_goods_estimate_time);
        goodsEstimateMendian = (RelativeLayout) findViewById(R.id.goods_estimate_mendian);
        tvGoodsEstimateMendianName = (TextView) findViewById(R.id.tv_goods_estimate_mendian_name);
        tvGoodsEstimateMendianJuli = (TextView) findViewById(R.id.tv_goods_estimate_mendian_juli);
        tvGoodsEstimateMendianDizhi = (TextView) findViewById(R.id.tv_goods_estimate_mendian_dizhi);
        goodsEstimateWenti = (RelativeLayout) findViewById(R.id.goods_estimate_wenti);
        textView5 = (TextView) findViewById(R.id.textView5);
        goodsEstimateWenti1 = (TextView) findViewById(R.id.goods_estimate_wenti_1);
        goodsEstimateWenti11 = (TextView) findViewById(R.id.goods_estimate_wenti_1_1);
        goodsEstimateWenti2 = (TextView) findViewById(R.id.goods_estimate_wenti_2);
        goodsEstimateWenti21 = (TextView) findViewById(R.id.goods_estimate_wenti_2_1);
        goodsEstimateLogo = (LinearLayout) findViewById(R.id.goods_estimate_logo);
        ivGoodsEstimateLogo = (ImageView) findViewById(R.id.iv_goods_estimate_logo);
        goodsEstimateLogoName = (TextView) findViewById(R.id.goods_estimate_logo_name);
        goodsEstimateShangpin = (LinearLayout) findViewById(R.id.goods_estimate_shangpin);
        ivGoodsEstimateLogeFenlei = (ImageView) findViewById(R.id.iv_goods_estimate_loge_fenlei);
        ivGoodsEstimateLogeJindian = (ImageView) findViewById(R.id.iv_goods_estimate_loge_jindian);
        goodsTitle = (LinearLayout) findViewById(R.id.goods_title);
        ibGoodsTitle =  findViewById(R.id.ib_goods_title);
        rbGoodsInfoItem1 = (RadioButton) findViewById(rb_goods_info_item_1);
        rbGoodsInfoItem2 = (RadioButton) findViewById(R.id.rb_goods_info_item_2);
        rbGoodsInfoItem3 = (RadioButton) findViewById(R.id.rb_goods_info_item_3);
        rbGoodsInfoItem4 = (RadioButton) findViewById(R.id.rb_goods_info_item_4);
        ibGoods1 = (ImageButton) findViewById(R.id.ib_goods_1);
        ibGoods2 = (ImageButton) findViewById(R.id.ib_goods_2);
        ibGoods3 = (ImageButton) findViewById(R.id.ib_goods_3);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rbGoodsDianpu = (RadioButton) findViewById(R.id.rb_goods_dianpu);
        rbGoodsKefu = (RadioButton) findViewById(R.id.rb_goods_kefu);
        rbGoodsShoucang = (RadioButton) findViewById(R.id.rb_goods_shoucang);
        rbGoodsCar = (RadioButton) findViewById(R.id.rb_goods_car);
        rbGoodsBuy = (RadioButton) findViewById(R.id.rb_goods_buy);
        rgGoodsTitle = findViewById(R.id.rg_goods_title);


        btGoodsTitle.setOnClickListener(this);
        ibGoodsTitle.setOnClickListener(this);
        rbGoodsInfoItem1.setOnClickListener(this);
        rbGoodsInfoItem2.setOnClickListener(this);
        rbGoodsInfoItem3.setOnClickListener(this);
        rbGoodsInfoItem4.setOnClickListener(this);
        ibGoods1.setOnClickListener(this);
        ibGoods2.setOnClickListener(this);
        ibGoods3.setOnClickListener(this);
        rbGoodsDianpu.setOnClickListener(this);
        rbGoodsKefu.setOnClickListener(this);
        rbGoodsShoucang.setOnClickListener(this);
        rbGoodsCar.setOnClickListener(this);
        rbGoodsBuy.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-07 11:10:39 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == btGoodsTitle) {
            // Handle clicks for btGoodsTitle
        } else if (v == ibGoodsTitle) {
            // Handle clicks for ibGoodsTitle

        } else if (v == rbGoodsInfoItem1) {
            // Handle clicks for rbGoodsInfoItem1
        } else if (v == rbGoodsInfoItem2) {
            // Handle clicks for rbGoodsInfoItem2
        } else if (v == rbGoodsInfoItem3) {
            // Handle clicks for rbGoodsInfoItem3
        } else if (v == rbGoodsInfoItem4) {
            // Handle clicks for rbGoodsInfoItem4
        } else if (v == ibGoods1) {
            // Handle clicks for ibGoods1
            //后退
            finish();
        } else if (v == ibGoods2) {
            // Handle clicks for ibGoods2
            //打开购物车

        } else if (v == ibGoods3) {
            // Handle clicks for ibGoods3
            //更多
            initPopupWindow();

        } else if (v == rbGoodsDianpu) {
            // Handle clicks for rbGoodsDianpu

        } else if (v == rbGoodsKefu) {
            // Handle clicks for rbGoodsKefu
        } else if (v == rbGoodsShoucang) {
            // Handle clicks for rbGoodsShoucang
        } else if (v == rbGoodsCar) {
            // Handle clicks for rbGoodsCar
            //加入购物车
            CartStorage.getInstance().addData(goodsBean);
            Toast.makeText(mContext,goodsBean.getName()+"已加入购物车",Toast.LENGTH_SHORT).show();
            //打开购物车
//            intent = new Intent(mContext,ShopcartActivity.class);
//            startActivity(intent);

        } else if (v == rbGoodsBuy) {
            // Handle clicks for rbGoodsBuy
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
