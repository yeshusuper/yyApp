package com.fuliaohui.yy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.fuliaohui.yy.widget.TitleBar;

/**
 * Created by wulf on 2017/3/25.
 */

public class MerchantListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvitiy_merchant_list);

        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("主营水溶花边商家");
        titleBar.setActivity(this);

        final View selectItems = findViewById(R.id.ll_select_items);
        selectItems.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    selectItems.setVisibility(View.GONE);
                return false;
            }
        });
        findViewById(R.id.ll_select_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectItems.getVisibility() == View.GONE)
                    selectItems.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.btn_pub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PublishProductActivity.launchForCaigou(MerchantListActivity.this);
            }
        });
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MerchantListActivity.this, PlaceActivity.class));
            }
        };
        int[] placeIds = new int[]{ R.id.tv_place_1, R.id.tv_place_2, R.id.tv_place_3, R.id.tv_place_4,
            R.id.tv_place_5, R.id.tv_place_6, R.id.tv_place_7, R.id.tv_place_8 };
        for (int i = 0; i < placeIds.length; i++) {
            findViewById(placeIds[i]).setOnClickListener(listener);
        }
    }
}
