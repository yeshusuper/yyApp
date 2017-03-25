package com.fuliaohui.yy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fuliaohui.yy.R;

/**
 * Created by wulf on 2017/3/25.
 */

public class RightColorSelecterDialogFragment extends DialogFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.DialogTheme);
        setCancelable(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right_color_selecter, null);
        view.findViewById(R.id.fl_bg)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dismiss();
                    }
                });
        int[] cbIds = new int[] { R.id.cb_1, R.id.cb_2, R.id.cb_3, R.id.cb_4, R.id.cb_5, R.id.cb_6, R.id.cb_7 };
        int[] tvIds = new int[] { R.id.tv_1, R.id.tv_2, R.id.tv_3, R.id.tv_4, R.id.tv_5, R.id.tv_6, R.id.tv_7 };
        bindCheckBox(view, cbIds, tvIds);
        return view;
    }

    private void bindCheckBox(final View view, int[] cbIds, int[] tvIds){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Object[] tags = (Object[]) v.getTag();
                TextView textView = (TextView) view.findViewById((Integer) tags[0]);
                boolean checked = (boolean) tags[1];
                if(!checked){
                    v.setBackgroundResource(R.drawable.shape_right_class_select_cur);
                    textView.setTextColor(getResources().getColor(R.color.red_e82c1d));
                    tags[1] = true;
                }else{
                    v.setBackgroundResource(R.drawable.shape_right_class_select_nor);
                    textView.setTextColor(getResources().getColor(R.color.black_555555));
                    tags[1] = false;
                }
                v.setTag(tags);
            }
        };

        for (int i = 0; i < cbIds.length; i++) {
            View cbView = view.findViewById(cbIds[i]);
            cbView.setTag(new Object[]{ tvIds[i], false });
            cbView.setOnClickListener(listener);
        }
    }

    public void show(FragmentManager fragmentManager){
        show(fragmentManager, RightClassSelecterDialogFragment.class.getName());
    }
}
