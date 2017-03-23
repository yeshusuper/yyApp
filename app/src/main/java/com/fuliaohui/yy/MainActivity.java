package com.fuliaohui.yy;

import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuliaohui.yy.fragments.CaigouListFragment;
import com.fuliaohui.yy.fragments.ClassSelecterFragment;
import com.fuliaohui.yy.fragments.NewProductFragment;
import com.fuliaohui.yy.widget.TitleBar;

public class MainActivity extends AppCompatActivity {

    private Fragment classSelecterFragment;
    private Fragment classSelecterFragment2;
    private Fragment newProductFragment;
    private Fragment caigouListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View titleBar = findViewById(R.id.title_bar);


        final CheckBox cbMianLiao = (CheckBox) findViewById(R.id.cb_mianliao);
        final CheckBox cbFuLiao = (CheckBox) findViewById(R.id.cb_fuliao);
        final CheckBox cbNew = (CheckBox) findViewById(R.id.cb_new);

        classSelecterFragment = new ClassSelecterFragment();
        classSelecterFragment2 = new ClassSelecterFragment();
        newProductFragment = new NewProductFragment();
        caigouListFragment = new CaigouListFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_fragment, newProductFragment)
                .add(R.id.fl_fragment, classSelecterFragment)
                .add(R.id.fl_fragment, classSelecterFragment2)
                .add(R.id.fl_fragment, caigouListFragment)
                .hide(newProductFragment)
                .hide(classSelecterFragment)
                .hide(classSelecterFragment2)
                .hide(caigouListFragment)
                .commit();
        final CompoundButton.OnCheckedChangeListener topCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CompoundButton checkBox = compoundButton;
                if(b){
                    setCheckBoxChecked(cbMianLiao, classSelecterFragment, checkBox == cbMianLiao,
                            R.style.MainTopNavItemCurrentLeft, R.drawable.shape_main_top_nav_left_patch);
                    setCheckBoxChecked(cbFuLiao, classSelecterFragment2, checkBox == cbFuLiao,
                            R.style.MainTopNavItemCurrent, R.color.red_e82c1d);
                    setCheckBoxChecked(cbNew, newProductFragment, checkBox == cbNew,
                            R.style.MainTopNavItemCurrentRight, R.drawable.shape_main_top_nav_right_patch);
                }
            }
        };
        cbMianLiao.setOnCheckedChangeListener(topCheckedChangeListener);
        cbFuLiao.setOnCheckedChangeListener(topCheckedChangeListener);
        cbNew.setOnCheckedChangeListener(topCheckedChangeListener);

        cbMianLiao.setChecked(true);

        final View kfTip = findViewById(R.id.rl_kf_tip);
        findViewById(R.id.tv_kf_tip_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kfTip.setVisibility(View.GONE);
            }
        });

        final View llNavHome = findViewById(R.id.ll_nav_home);
        final View llNavCaigou = findViewById(R.id.ll_nav_caigou);
        final View llNavKf = findViewById(R.id.ll_nav_kf);
        final View llNavMy = findViewById(R.id.ll_nav_my);
        final View.OnClickListener bottomNavClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(setBottomNavChecked(view, llNavHome, R.id.iv_nav_home, R.id.tv_nav_home, R.drawable.main_bottom_nav_home_nor, R.drawable.main_bottom_nav_home_cur)){
                    topCheckedChangeListener.onCheckedChanged(cbMianLiao, true);
                    titleBar.setVisibility(View.VISIBLE);
                }
                boolean caigouChecked = setBottomNavChecked(view, llNavCaigou, R.id.iv_nav_caigou, R.id.tv_nav_caigou, R.drawable.main_bottom_nav_caigou_nor, R.drawable.main_bottom_nav_caigou_cur);
                if(caigouChecked) {
                    titleBar.setVisibility(View.GONE);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .show(caigouListFragment)
                            .commit();
                }
            }
        };
        llNavHome.setOnClickListener(bottomNavClickListener);
        llNavCaigou.setOnClickListener(bottomNavClickListener);
    }

    private boolean setBottomNavChecked(View clickView, View view, int imgId, int textId, int norId, int curId) {
        ImageView iv = (ImageView) view.findViewById(imgId);
        TextView tv = (TextView) view.findViewById(textId);
        if(clickView == view){
            iv.setImageResource(curId);
            tv.setTextColor(getResources().getColor(R.color.red_e82c1d));
            return true;
        }else{
            iv.setImageResource(norId);
            tv.setTextColor(getResources().getColor(R.color.gray_999999));
            return false;
        }
    }

    private void setCheckBoxChecked(CheckBox checkBox, Fragment fragment, boolean isChecked, @StyleRes int currentStyleId, int bgId){
        if(isChecked) {
            FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .hide(caigouListFragment)
                .show(fragment);

            if(fragment != classSelecterFragment)
                ft.hide(classSelecterFragment);
            if(fragment != classSelecterFragment2)
                ft.hide(classSelecterFragment2);
            if(fragment != newProductFragment)
                ft.hide(newProductFragment);

            ft.commit();
        }
        checkBox.setChecked(isChecked);
        checkBox.setTextAppearance(this, isChecked ? currentStyleId : R.style.MainTopNavItem);
        checkBox.setBackgroundResource(isChecked ? bgId : R.color.transparent);
    }
}
