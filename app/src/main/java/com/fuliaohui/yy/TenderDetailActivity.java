package com.fuliaohui.yy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fuliaohui.yy.widget.TitleBar;

/**
 * Created by wulf on 2017/3/25.
 */

public class TenderDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_detail);

        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("竞标详情");
        titleBar.setActivity(this);

        findViewById(R.id.ll_talk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/3/25 跳转到聊天
            }
        });
        findViewById(R.id.ll_place).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TenderDetailActivity.this, PlaceActivity.class));
            }
        });
    }
}
