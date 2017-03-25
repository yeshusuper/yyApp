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

public class TenderListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_list);

        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("主营商家");
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

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenderListActivity.this, TenderDetailActivity.class));
            }
        };
        int[] detailIds = new int[]{ R.id.ll_detail_1, R.id.ll_detail_2, R.id.ll_detail_3, R.id.ll_detail_4 };
        for (int detailId : detailIds) {
            findViewById(detailId).setOnClickListener(listener);
        }
    }
}
