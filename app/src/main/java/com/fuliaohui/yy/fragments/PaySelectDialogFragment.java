package com.fuliaohui.yy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fuliaohui.yy.R;

/**
 * Created by lam on 2017/3/25.
 */

public class PaySelectDialogFragment extends DialogFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.DialogTheme);
        setCancelable(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay_select, null);

        view.findViewById(R.id.fl_bg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        view.findViewById(R.id.tv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        final View wxContainer = view.findViewById(R.id.iv_wx_pay_container);
        final View aliContainer = view.findViewById(R.id.iv_ali_pay_container);
        final ImageView wxCheckBox = (ImageView) view.findViewById(R.id.iv_wx_pay_check);
        final ImageView aliCheckBox = (ImageView) view.findViewById(R.id.iv_ali_pay_check);
        wxContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wxCheckBox.setImageResource(R.drawable.icon_check_bor_cur);
                aliCheckBox.setImageResource(R.drawable.icon_check_bor_nor);
            }
        });
        aliContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wxCheckBox.setImageResource(R.drawable.icon_check_bor_nor);
                aliCheckBox.setImageResource(R.drawable.icon_check_bor_cur);
            }
        });

        return view;
    }

    public void show(FragmentManager manager){
        show(manager, PaySelectDialogFragment.class.getName());
    }
}
