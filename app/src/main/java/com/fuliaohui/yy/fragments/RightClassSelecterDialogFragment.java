package com.fuliaohui.yy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.fuliaohui.yy.R;

/**
 * Created by lam on 2017/3/22.
 */

public class RightClassSelecterDialogFragment extends DialogFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.DialogTheme);
        setCancelable(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_right_class_selecter, null);
        view.findViewById(R.id.fl_bg)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dismiss();
                    }
                });
        int[] ids = new int[] { R.id.cb_1, R.id.cb_2, R.id.cb_3, R.id.cb_4, R.id.cb_5, R.id.cb_6, R.id.cb_7, R.id.cb_8, R.id.cb_9, R.id.cb_10 };

        bindCheckBoxs(view, ids);

        return view;
    }

    private void bindCheckBoxs(View view, int[] ids){
        final CheckBox[] checkBoxes = new CheckBox[ids.length];
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    buttonView.setTextColor(getResources().getColor(R.color.red_e82c1d));
                    for (CheckBox checkBox : checkBoxes) {
                        if(checkBox != buttonView){
                            checkBox.setTextColor(getResources().getColor(R.color.black_555555));
                            checkBox.setChecked(false);
                        }
                    }
                }
            }
        };
        for (int i = 0; i < ids.length; i++) {
            checkBoxes[i] = (CheckBox) view.findViewById(ids[i]);
            checkBoxes[i].setOnCheckedChangeListener(listener);
        }
    }

    public void show(FragmentManager fragmentManager){
        show(fragmentManager, RightClassSelecterDialogFragment.class.getName());
    }
}
