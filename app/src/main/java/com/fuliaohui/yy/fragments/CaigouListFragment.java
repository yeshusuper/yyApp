package com.fuliaohui.yy.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.fuliaohui.yy.ChatActivity;
import com.fuliaohui.yy.EvaluateActivity;
import com.fuliaohui.yy.MerchantListActivity;
import com.fuliaohui.yy.OrderDetailActivity;
import com.fuliaohui.yy.PayActivity;
import com.fuliaohui.yy.ProductDetailActivity;
import com.fuliaohui.yy.PublishProductActivity;
import com.fuliaohui.yy.R;
import com.fuliaohui.yy.TenderListActivity;
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
        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), OrderDetailActivity.class));
            }
        };
        for (int i = 0; i < productIds.length; i++) {
            view.findViewById(productIds[i]).setOnClickListener(i < 4 ? listener : listener2);
        }
        View.OnClickListener listener3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), MerchantListActivity.class));
            }
        };
        int[] merchantIds = new int[] { R.id.cb_merchant_1, R.id.cb_merchant_2, R.id.cb_merchant_3 };
        for (int merchantId : merchantIds) {
            view.findViewById(merchantId).setOnClickListener(listener3);
        }
        View.OnClickListener listener4 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatActivity.launchChat(getContext());
            }
        };
        int[] talkIds = new int[] { R.id.cb_talk_1, R.id.cb_talk_2, R.id.cb_talk_3, R.id.cb_talk_4 };
        for (int talkId : talkIds) {
            view.findViewById(talkId).setOnClickListener(listener4);
        }

        view.findViewById(R.id.cb_evaluate_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), EvaluateActivity.class));
            }
        });
        view.findViewById(R.id.cb_pay_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), PayActivity.class));
            }
        });
        view.findViewById(R.id.cb_tender_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), TenderListActivity.class));
            }
        });

        return view;
    }
}
