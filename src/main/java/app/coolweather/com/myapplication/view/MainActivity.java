package app.coolweather.com.myapplication.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import app.coolweather.com.myapplication.R;
import app.coolweather.com.myapplication.model.util.BaseFragment;
import app.coolweather.com.myapplication.presenter.CartBaseFragment;
import app.coolweather.com.myapplication.presenter.HomeBaseFragment;
import app.coolweather.com.myapplication.presenter.MessageBaseFragment;
import app.coolweather.com.myapplication.presenter.UserBaseFragment;
import app.coolweather.com.myapplication.presenter.WeiTaoBaseFragment;

public class MainActivity extends FragmentActivity {

    private List<BaseFragment> fragment ;

    private Fragment mContent;

    private int pos;

    private RadioGroup mRadioGroup;

//    @BindView(R.id.rg_main)
//    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        radioGroup();
    }


    private void init() {
        mRadioGroup = findViewById(R.id.rg_main);

        fragment = new ArrayList<>();
        fragment.add(new HomeBaseFragment());
        fragment.add(new WeiTaoBaseFragment());
        fragment.add(new MessageBaseFragment());
        fragment.add(new CartBaseFragment());
        fragment.add(new UserBaseFragment());


    }

    public void radioGroup() {

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.rb_home:
                        pos = 0;
                        break;
                    case R.id.rb_weiTao:
                        pos = 1;
                        break;
                    case R.id.rb_message:
                        pos = 2;
                        break;
                    case R.id.rb_cart:
                        pos = 3;

                        break;
                    case R.id.rb_user:
                        pos = 4;
                        break;
                    default:
                        pos = 0;
                        break;
                }
                BaseFragment to = fragment.get(pos);

                switchframent(mContent,to);

            }
        });
        mRadioGroup.check(R.id.rb_home);
    }

    private void switchframent(Fragment from,Fragment to ) {

        if(from!=to){
            mContent = to;
            FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
            if(to.isAdded()){
                if(from !=null){
                    fm.hide(from);
                }
                fm.show(to);
            }else{
                if(from != null){
                    fm.hide(from);
                }
                fm.add(R.id.fl,to);
            }

            fm.commit();
        }
    }
}

