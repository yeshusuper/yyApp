package com.fuliaohui.yy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fuliaohui.yy.fragments.PaySelectDialogFragment;
import com.fuliaohui.yy.widget.TitleBar;

/**
 * Created by lam on 2017/3/25.
 */

public class PayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("支付");
        titleBar.setActivity(this);

        findViewById(R.id.ll_talk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatActivity.launchChat(PayActivity.this);
            }
        });
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaySelectDialogFragment fragment = new PaySelectDialogFragment();
                fragment.show(getSupportFragmentManager());
            }
        });
    }
}
