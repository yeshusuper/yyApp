package com.fuliaohui.yy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fuliaohui.yy.R;

/**
 * Created by lam on 2017/3/21.
 */

public class NewProductFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_product, null);
        view.findViewById(R.id.ll_select_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = RightClassSelecterDialogFragment.class.getName();
                        DialogFragment fragment = (DialogFragment) DialogFragment.instantiate(getContext(), name);
                        fragment.show(getChildFragmentManager(), name);
                    }
                });
        return view;
    }
}
