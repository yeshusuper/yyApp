package com.fuliaohui.yy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.fuliaohui.yy.widget.TitleBar;

import java.util.Arrays;

/**
 * Created by lam on 2017/3/25.
 */

public class EvaluateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("订单评价");
        titleBar.setActivity(this);

        int[] starGroup1 = new int[]{ R.id.iv_star_1, R.id.iv_star_2, R.id.iv_star_3, R.id.iv_star_4, R.id.iv_star_5 };
        int[] starGroup2 = new int[]{ R.id.iv_star_6, R.id.iv_star_7, R.id.iv_star_8, R.id.iv_star_9, R.id.iv_star_10 };
        int[] starGroup3 = new int[]{ R.id.iv_star_11, R.id.iv_star_12, R.id.iv_star_13, R.id.iv_star_14, R.id.iv_star_15 };

        bindStar(starGroup1);
        bindStar(starGroup2);
        bindStar(starGroup3);
    }

    private void bindStar(final int[] group){
        final ImageView[] views = new ImageView[group.length];
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                boolean match = false;
                for (int i = 0; i < group.length; i++) {
                    boolean m = match || group[i] == id;
                    if (match)
                        views[i].setImageResource(R.drawable.icon_star_nor);
                    else
                        views[i].setImageResource(R.drawable.icon_star_cur);
                    match = m;
                }
            }
        };
        for (int i = 0; i < group.length; i++) {
            views[i] = (ImageView) findViewById(group[i]);
            views[i].setOnClickListener(listener);
        }
    }
}
