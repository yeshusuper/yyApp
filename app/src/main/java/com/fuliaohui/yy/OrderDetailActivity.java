package com.fuliaohui.yy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fuliaohui.yy.widget.TitleBar;

/**
 * Created by wulf on 2017/3/25.
 */

public class OrderDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("订单详情");
        titleBar.setActivity(this);

        titleBar.setRigthText("沟通一下", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatActivity.launchChat(OrderDetailActivity.this);
            }
        });
    }
}
