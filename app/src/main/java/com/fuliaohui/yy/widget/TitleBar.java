package com.fuliaohui.yy.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.fuliaohui.yy.R;

/**
 * Created by lam on 2017/3/19.
 */

public class TitleBar extends FrameLayout {
    private TextView tvTitle;
    private Activity activity;
    private View llBack;

    public TitleBar(Context context) {
        super(context);
        init(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        View view = inflate(context, R.layout.widget_title_bar, this);
        tvTitle = (TextView) view.findViewById(R.id.tv_text);
        llBack = view.findViewById(R.id.ll_back);
        llBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(activity != null)
                    activity.finish();
            }
        });
    }

    public void setTitle(CharSequence title){
        tvTitle.setText(title);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        llBack.setVisibility(activity == null ? GONE : VISIBLE);
    }
}
