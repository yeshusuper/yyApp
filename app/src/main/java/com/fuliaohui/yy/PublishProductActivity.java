package com.fuliaohui.yy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fuliaohui.yy.widget.TitleBar;

/**
 * Created by lam on 2017/3/24.
 */

public class PublishProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_product);

        TitleBar titleBar = ((TitleBar)findViewById(R.id.title_bar));
        titleBar.setTitle("发布采购需求");
        titleBar.setActivity(this);


    }
}
