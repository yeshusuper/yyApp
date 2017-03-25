package com.fuliaohui.yy.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.fuliaohui.yy.ProductDetailActivity;
import com.fuliaohui.yy.PublishProductActivity;
import com.fuliaohui.yy.R;
import com.fuliaohui.yy.widget.TitleBar;

/**
 * Created by lam on 2017/3/23.
 */

public class CaigouListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_caigou_list, null);
        ((TitleBar)view.findViewById(R.id.title_bar)).setTitle("我的采购");
        final View selectItems = view.findViewById(R.id.ll_select_items);
        selectItems.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    selectItems.setVisibility(View.GONE);
                return false;
            }
        });
        view.findViewById(R.id.ll_select_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectItems.getVisibility() == View.GONE)
                    selectItems.setVisibility(View.VISIBLE);
            }
        });

        view.findViewById(R.id.tv_pub_caigou).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PublishProductActivity.launchForCaigou(getContext());
            }
        });
        int[] productIds = new int[]{ R.id.ll_product_1,R.id.ll_product_2,R.id.ll_product_3,R.id.ll_product_4,R.id.ll_product_5,R.id.ll_product_6,R.id.ll_product_7 };
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), ProductDetailActivity.class));
            }
        };
        for (int productId : productIds) {
            view.findViewById(productId).setOnClickListener(listener);
        }

        return view;
    }
}
