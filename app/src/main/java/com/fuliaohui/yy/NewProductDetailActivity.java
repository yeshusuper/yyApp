package com.fuliaohui.yy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fuliaohui.yy.widget.TitleBar;

/**
 * Created by lam on 2017/3/22.
 */

public class NewProductDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product_detail);

        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("新品详细");
        titleBar.setActivity(this);
        
        findViewById(R.id.ll_talk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatActivity.launchChat(NewProductDetailActivity.this);
            }
        });
        findViewById(R.id.btn_quyang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PublishProductActivity.launchForQuyang(NewProductDetailActivity.this);
            }
        });
    }
}
