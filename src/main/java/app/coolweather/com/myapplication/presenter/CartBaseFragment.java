package app.coolweather.com.myapplication.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import app.coolweather.com.myapplication.R;
import app.coolweather.com.myapplication.model.adapter.ShoppingCartAdapter;
import app.coolweather.com.myapplication.model.util.BaseFragment;
import app.coolweather.com.myapplication.model.util.CartStorage;
import app.coolweather.com.myapplication.model.util.DividerItemDecoration;
import app.coolweather.com.myapplication.model.util.GoodsBeanInfo;

/**
 * Created by Administrator on 2017/10/25.
 */

public class CartBaseFragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private RelativeLayout rlTitleBar;
    private RelativeLayout rlShoppingCartEmpty;
    private ImageView imageView;

    private TextView textView;
    private RecyclerView recyclerView;
    private RelativeLayout rlBottomBar;
    private CheckBox cbSelectAll;
    private TextView tvPostPrice;
    private TextView tvCountMoney;
    private TextView btnSettle;
    private TextView tvTitle;
    private TextView tvEditAll;
    private LinearLayout titleBarItem;
    private List<GoodsBeanInfo.ResultBean.GoodsBean> allData;

    private boolean isCheck = false;
    private TextView shoppingCartDel;
    private RefreshLayout refreshLayout;
    private ShoppingCartAdapter adapter;


    @Override
    public View initView() {
        view = View.inflate(mContext, R.layout.shopping_cart_1, null);
        findViews();
        return view;
    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-19 11:35:14 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        rlTitleBar = view.findViewById(R.id.rlTitleBar);
        rlShoppingCartEmpty = view.findViewById(R.id.rlShoppingCartEmpty);
        imageView = view.findViewById(R.id.imageView);
        textView = view.findViewById(R.id.textView);
        recyclerView = view.findViewById(R.id.recyclerView);
        rlBottomBar = view.findViewById(R.id.rlBottomBar);
        cbSelectAll = view.findViewById(R.id.cbSelectAll);
        tvPostPrice = view.findViewById(R.id.tvPostPrice);
        tvCountMoney = view.findViewById(R.id.tvCountMoney);
        btnSettle = view.findViewById(R.id.btnSettle);
        titleBarItem = view.findViewById(R.id.title_bar_item);
        shoppingCartDel = view.findViewById(R.id.shopping_cart_del);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        tvEditAll = view.findViewById(R.id.tvEditAll);

        tvEditAll.setOnClickListener(this);


    }


    @Override
    public void initData() {

        allData = CartStorage.getInstance().getAllData();


        if (allData != null && allData.size() > 0) {
            rlShoppingCartEmpty.setVisibility(View.GONE);

            adapter = new ShoppingCartAdapter(mContext, allData, cbSelectAll, tvCountMoney, shoppingCartDel);
            //设置adapter
            recyclerView.setAdapter(adapter);
            //添加分割线
            recyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.HORIZONTAL_LIST));
            //设置布局管理器
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL, false));
        } else {
            rlShoppingCartEmpty.setVisibility(View.VISIBLE);
            titleBarItem.setVisibility(View.GONE);
            tvEditAll.setText("管理");
            isCheck = false;
        }

        refresh();

    }


    //刷新加载
    private void refresh() {

        //下拉刷新
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override

            public void onRefresh(RefreshLayout refreshlayout) {

                refreshLayout.setDragRate(1f);//显示下拉高度/手指真实下拉高度=阻尼效果
                refreshLayout.setReboundDuration(166);//回弹动画时长（毫秒）
                refreshLayout.setHeaderMaxDragRate(3);//最大显示下拉高度/Header标准高度
                refreshLayout.setHeaderHeight(100);//Header标准高度（显示下拉高度>=标准高度 触发刷新）
                refreshLayout.setEnableAutoLoadmore(true);//是否启用列表惯性滑动到底部时自动加载更多
                refreshLayout.setEnablePureScrollMode(true);//是否启用纯滚动模式
                refreshLayout.setEnableNestedScroll(false);//是否启用嵌套滚动
                refreshLayout.setEnableOverScrollBounce(false);//是否启用越界回弹
                refreshLayout.setEnableScrollContentWhenLoaded(true);//是否在加载完成时滚动列表显示新的内容
                refreshLayout.setEnableHeaderTranslationContent(true);//是否下拉Header的时候向下平移列表或者内容
                refreshLayout.setEnableLoadmoreWhenContentNotFull(false);//是否在列表不满一页时候开启上拉加载功能
                refreshLayout.setDisableContentWhenRefresh(false);//是否在刷新的时候禁止列表的操作
                refreshLayout.setRefreshHeader(new ClassicsHeader(mContext));//设置Header
                refreshlayout.finishRefresh(188);//延迟xxx 毫秒后结束刷新

                initData();

            }
        });
        //上拉加载
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override

            public void onLoadmore(RefreshLayout refreshlayout) {
                //延迟2000毫秒后结束加载
                refreshlayout.finishLoadmore(2000);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvEditAll:
                if (!isCheck) {
                    titleBarItem.setVisibility(View.VISIBLE);
                    tvEditAll.setText("完成");
                    isCheck = true;
                    shoppingCartDel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(mContext, "删除", Toast.LENGTH_SHORT).show();
                            adapter.deleteData();
                            initData();
                        }
                    });
                } else {
                    titleBarItem.setVisibility(View.GONE);
                    tvEditAll.setText("管理");
                    isCheck = false;
                }
                break;

        }
    }
}


