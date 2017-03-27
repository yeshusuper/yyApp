package com.fuliaohui.yy.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fuliaohui.yy.MerchantListActivity;
import com.fuliaohui.yy.R;

/**
 * Created by lam on 2017/3/20.
 */

public class ClassSelecterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class_selecter, null);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(new Intent(getContext(), MerchantListActivity.class));
            }
        };

        int[] classIds = new int[]{ R.id.ll_class_1, R.id.ll_class_2, R.id.ll_class_3, R.id.ll_class_4, R.id.ll_class_5, R.id.ll_class_6, R.id.ll_class_7, R.id.ll_class_8, R.id.ll_class_9 };
        for (int i = 0; i < classIds.length; i++) {
            view.findViewById(classIds[i]).setOnClickListener(listener);
        }

        return view;
    }
}
