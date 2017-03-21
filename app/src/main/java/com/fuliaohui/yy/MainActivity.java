package com.fuliaohui.yy;

import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.fuliaohui.yy.fragments.ClassSelecterFragment;
import com.fuliaohui.yy.fragments.NewProductFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment classSelecterFragment;
    private Fragment classSelecterFragment2;
    private Fragment newProductFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox cbMianLiao = (CheckBox) findViewById(R.id.cb_mianliao);
        final CheckBox cbFuLiao = (CheckBox) findViewById(R.id.cb_fuliao);
        final CheckBox cbNew = (CheckBox) findViewById(R.id.cb_new);

        classSelecterFragment = new ClassSelecterFragment();
        classSelecterFragment2 = new ClassSelecterFragment();
        newProductFragment = new NewProductFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_fragment, newProductFragment)
                .add(R.id.fl_fragment, classSelecterFragment)
                .add(R.id.fl_fragment, classSelecterFragment2)
                .hide(newProductFragment)
                .hide(classSelecterFragment)
                .hide(classSelecterFragment2)
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
    }

    private void setCheckBoxChecked(CheckBox checkBox, Fragment fragment, boolean isChecked, @StyleRes int currentStyleId, int bgId){
        if(isChecked) {
            FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
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
