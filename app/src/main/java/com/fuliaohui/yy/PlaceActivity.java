package com.fuliaohui.yy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fuliaohui.yy.widget.TitleBar;

/**
 * Created by wulf on 2017/3/25.
 */

public class PlaceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvitiy_place);

        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("炳和生商家导航");
        titleBar.setActivity(this);

        final View place1 = findViewById(R.id.iv_place_1);
        final View place2 = findViewById(R.id.iv_place_2);

        findViewById(R.id.fl_next_place).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place1.setVisibility(View.GONE);
                place2.setVisibility(View.VISIBLE);
            }
        });
    }
}
