package app.coolweather.com.myapplication.model.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import app.coolweather.com.myapplication.R;
import app.coolweather.com.myapplication.model.util.GlideImageLoader;
import app.coolweather.com.myapplication.model.util.GoodsBeanInfo;
import app.coolweather.com.myapplication.model.util.MarqueeView;
import app.coolweather.com.myapplication.model.util.ResultBaseData;
import app.coolweather.com.myapplication.model.util.StringConstant;
import app.coolweather.com.myapplication.model.GoodsInfoActivity;
import okhttp3.Call;

/**
 * Created by Administrator on 2017/10/26.
 */

public class HomeFragmentAdapter extends RecyclerView.Adapter {

    //
    private static final int BANNER = 0;
    //
    private static final int CHANNEL = 1;
    //
    private static final int SECK = 2;
    //
    private static final int AAA = 3;
    //
    private static final int ACT = 4;
    //
    private static final int SECKILL = 5;
    //
    private static final int RECOMMEND = 6;
    //
    private static final String GOODS_BEAN = "goods_bean";
    //
    private int currentType = 0;

    public Context mContext;

    public ResultBaseData.ResultBean resultBean;

    public Banner banner;

    private final LayoutInflater mLayoutInflater;

    private long dt = 0;
    private GoodsBeanInfo.ResultBean.GoodsBean goodsBean;


    public HomeFragmentAdapter(Context mContext, ResultBaseData.ResultBean resultBean) {
        this.mContext = mContext;
        this.resultBean = resultBean;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            return new BannerViewHolder(mContext, mLayoutInflater.inflate(R.layout.banner_view_pager, null));
        } else if (viewType == CHANNEL) {
            return new ChannelViewHolder(mContext, mLayoutInflater.inflate(R.layout.gl_channel, null));
        } else if (viewType == SECK) {
            return new TouViewHolder(mContext, mLayoutInflater.inflate(R.layout.toutiao, null));
        } else if (viewType == AAA) {
            return new ACTUViewHolder(mContext, mLayoutInflater.inflate(R.layout.image_button, null));
        } else if (viewType == ACT) {
            return new ACTViewHolder(mContext, mLayoutInflater.inflate(R.layout.act_view, null));
        } else if (viewType == SECKILL) {
            return new SeckillViewHolder(mContext, mLayoutInflater.inflate(R.layout.seckill_view, null));
        } else if (viewType == RECOMMEND) {
            return new RecommendViewHolder(mContext, mLayoutInflater.inflate(R.layout.recommend_view, null));
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (currentType == BANNER) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            List<ResultBaseData.ResultBean.BannerInfoBean> banner_info = resultBean.getBanner_info();
            bannerViewHolder.setBanner(banner_info);
        } else if (currentType == CHANNEL) {
            ChannelViewHolder channelViewHolder = (ChannelViewHolder) holder;
            List<ResultBaseData.ResultBean.ChannelInfoBean> channel_info = resultBean.getChannel_info();
            channelViewHolder.setChannel(channel_info);
        } else if (currentType == SECK) {
            TouViewHolder touViewHolder = (TouViewHolder) holder;
            touViewHolder.setData(resultBean.getSeck_info().getList());
        } else if (currentType == AAA) {
            ACTUViewHolder actuViewHolder = (ACTUViewHolder) holder;
            List<ResultBaseData.ResultBean.AaaInfoBean> aaa_info = resultBean.getAaa_info();
            actuViewHolder.setData(aaa_info);
        } else if (currentType == ACT) {
            ACTViewHolder actViewHolder = (ACTViewHolder) holder;
            actViewHolder.setData(resultBean.getAct_info());
        } else if (currentType == SECKILL) {
            SeckillViewHolder seckillViewHolder = (SeckillViewHolder) holder;
            seckillViewHolder.setData(resultBean.getSeckill_info());
        } else if (currentType == RECOMMEND) {
            RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
            recommendViewHolder.setData(resultBean.getRecommend_info());
        }
    }


    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case BANNER:
                currentType = BANNER;
                break;
            case CHANNEL:
                currentType = CHANNEL;
                break;
            case ACT:
                currentType = ACT;
                break;
            case SECK:
                currentType = SECK;
                break;
            case RECOMMEND:
                currentType = RECOMMEND;
                break;
            case AAA:
                currentType = AAA;
                break;
            case SECKILL:
                currentType = SECKILL;
                break;
        }
        return currentType;
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {

        private Context context;
        private Intent intent;

        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.context = mContext;
            banner = itemView.findViewById(R.id.banner_viewpager);
        }

        public void setBanner(final List<ResultBaseData.ResultBean.BannerInfoBean> banner_info) {
            goodsBean = new GoodsBeanInfo.ResultBean.GoodsBean();
            List<String> images = new ArrayList<>();
            List<String> goodImage = new ArrayList<>();

            for (int i = 0; i < banner_info.size(); i++) {
                String image = StringConstant.BANNNER_IMAGE_URL + banner_info.get(i).getImage();
                images.add(image);
            }
            List<ResultBaseData.ResultBean.BannerGoodsInfoBean> banner_goods_info = resultBean.getBanner_goods_info();

            for (int i = 0; i < banner_goods_info.size(); i++) {
                goodImage.add(banner_goods_info.get(i).getImage());
                goodsBean.setChannel_id(banner_goods_info.get(i).getImage());
            }



            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            banner.setImages(images);
            //点击图片链接
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(final int position) {
                    //联网请求
                    OkHttpUtils
                            .get()
                            .url(StringConstant.GOODS_BEAN)
                            .build()
                            .execute(new StringCallback() {

                                @Override
                                public void onError(Call call, Exception e, int id) {
                                    Log.e("HomeBaseFragment", "initData() onError" + e.toString() + "  id:" + id);
                                }

                                @Override
                                public void onResponse(String response, int id) {
                                    getData(response);
                                }

                                private void getData(String response) {
                                    GoodsBeanInfo goodsBeanInfo = JSON.parseObject(response, GoodsBeanInfo.class);
                                    GoodsBeanInfo.ResultBean.GoodsBean goodsBean = goodsBeanInfo.getResult().getPage_data().get(position);

                                    if(goodsBean != null){
                                        intent = new Intent(mContext, GoodsInfoActivity.class);
                                        intent.putExtra(GOODS_BEAN,goodsBean);
                                        mContext.startActivity(intent);
                                    }
                                }
                            });

                }

            }).start();
            //banner设置方法全部调用完毕时最后调用
        }
    }

    class ChannelViewHolder extends RecyclerView.ViewHolder {

        private GridView gv_channel;
        private Context mContext;

        public ChannelViewHolder(final Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            gv_channel = itemView.findViewById(R.id.gv_channel);

            gv_channel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(mContext, "position" + i, Toast.LENGTH_SHORT).show();
                }
            });

        }

        public void setChannel(List<ResultBaseData.ResultBean.ChannelInfoBean> channel_info) {
            ChannelAdapter channelAdapter = new ChannelAdapter(mContext, channel_info);
            gv_channel.setAdapter(channelAdapter);
        }
    }

    class TouViewHolder extends RecyclerView.ViewHolder {
        public Context mContext;
        public View itemView;
        public MarqueeView marqueeView;

        public TouViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            this.itemView = itemView;
            marqueeView = itemView.findViewById(R.id.marqueeView);
            marqueeView.startFlipping();
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void setData(List<ResultBaseData.ResultBean.SeckInfoBean.ListBeanX> list) {
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                String name = list.get(i).getName();
                strings.add(name);
            }
//            marqueeView.startWithList(strings);
            marqueeView.startWithList(strings, R.anim.anim_bottom_in, R.anim.anim_top_out);
        }


    }

    class ACTUViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ssy;
        private final ImageView xr;
        private final ImageView dl;
        private final Context mContext;

        public ACTUViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            ssy = itemView.findViewById(R.id.ib_ssy);
            xr = itemView.findViewById(R.id.ib_xr);
            dl = itemView.findViewById(R.id.ib_dl);

        }

        public void setData(List<ResultBaseData.ResultBean.AaaInfoBean> data) {
            String string;
            ResultBaseData.ResultBean.AaaInfoBean aaaInfoBean = data.get(0);
            string = StringConstant.BANNNER_IMAGE_URL + aaaInfoBean.getIcon_url();
            Glide.with(mContext).load(string).into(ssy);

            aaaInfoBean = data.get(1);
            string = StringConstant.BANNNER_IMAGE_URL + aaaInfoBean.getIcon_url();
            Glide.with(mContext).load(string).into(xr);

            aaaInfoBean = data.get(2);
            string = StringConstant.BANNNER_IMAGE_URL + aaaInfoBean.getIcon_url();
            Glide.with(mContext).load(string).into(dl);

        }
    }

    class ACTViewHolder extends RecyclerView.ViewHolder {

        private final ViewPager vpAct;
        private Context mContext;

        public ACTViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            vpAct = itemView.findViewById(R.id.vp_act);

        }

        public void setData(final List<ResultBaseData.ResultBean.ActInfoBean> actInfoBeen) {
            vpAct.setPageMargin(20);
            vpAct.setAdapter(new PagerAdapter() {
                @Override
                public int getCount() {
                    return actInfoBeen.size();
                }

                @Override
                public boolean isViewFromObject(View view, Object object) {
                    return view == object;
                }

                @Override
                public Object instantiateItem(ViewGroup container, final int position) {
                    ImageView imageView = new ImageView(mContext);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Glide.with(mContext).load(StringConstant.BANNNER_IMAGE_URL + actInfoBeen.get(position).getIcon_url()).into(imageView);
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(mContext, " " + position, Toast.LENGTH_SHORT).show();
                        }
                    });
                    container.addView(imageView);
                    return imageView;
                }

                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    container.removeView((View) object);
                }
            });

        }
    }

    class SeckillViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTimeSeckill;
        private final TextView tvMoreSeckill;
        private final RecyclerView rvSeckill;
        private final Context mContext;

        public SeckillViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            tvTimeSeckill = itemView.findViewById(R.id.tv_time_seckill);
            tvMoreSeckill = itemView.findViewById(R.id.tv_more_seckill);
            rvSeckill = itemView.findViewById(R.id.rv_seckill);
        }

        public void setData(ResultBaseData.ResultBean.SeckillInfoBean data) {
            SeckillRecyclerViewAdapter adapter = new SeckillRecyclerViewAdapter(mContext, data.getList());
            rvSeckill.setAdapter(adapter);
            rvSeckill.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));

            adapter.SetOnSeckillRecyclerView(new SeckillRecyclerViewAdapter.OnSeckillRecyclerView() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
                }
            });


            dt = Integer.valueOf(data.getEnd_time()) - Integer.valueOf(data.getStart_time());


            CountDownTimer countDownTimer = new CountDownTimer(dt, 1000) {

                @Override
                public void onTick(long l) {
                    dt = dt - 1000;
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
//                    format.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

                    TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
                    TimeZone.setDefault(tz);

                    Date date = new Date(dt);
                    String format1 = format.format(date);
                    tvTimeSeckill.setText(format1);
                }

                @Override
                public void onFinish() {
                    tvTimeSeckill.setText("秒杀结束");
                }
            }.start();

        }
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder {
        private final Context mContext;
        private final GridView gv_recommend;
        private List<ResultBaseData.ResultBean.RecommendInfoBean> data;

        public RecommendViewHolder(Context mContext, View itemView) {
            super(itemView);

            this.mContext = mContext;
            gv_recommend = itemView.findViewById(R.id.gv_recommend);
        }

        public void setData(List<ResultBaseData.ResultBean.RecommendInfoBean> data) {

            RecommendAdapter recommendAdapter = new RecommendAdapter(mContext, data);
            gv_recommend.setAdapter(recommendAdapter);

            gv_recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(mContext, i + "pos", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}


