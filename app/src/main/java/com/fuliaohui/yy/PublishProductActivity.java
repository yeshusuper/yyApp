package com.fuliaohui.yy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.fuliaohui.yy.fragments.RightClassSelecterDialogFragment;
import com.fuliaohui.yy.fragments.RightColorSelecterDialogFragment;
import com.fuliaohui.yy.widget.TitleBar;

/**
 * Created by lam on 2017/3/24.
 */

public class PublishProductActivity extends AppCompatActivity {
    public interface OnCheckChangedListener {
        void onCheckChanged(CheckBoxItem item, boolean checked);
    }

    private class CheckBoxItem {
        public final int containerId;
        private final View containerView;
        private final ImageView checkBoxView;
        private final View.OnClickListener listener;
        private OnCheckChangedListener checkChangedListener;

        public CheckBoxItem(int containerId, int checkBoxId) {
            this.containerId = containerId;
            this.containerView = findViewById(containerId);
            this.checkBoxView = (ImageView) containerView.findViewById(checkBoxId);
            this.listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isChecked()) {
                        checkBoxView.setImageResource(R.drawable.icon_check_bor_cur);
                        v.setTag(true);
                    } else {
                        checkBoxView.setImageResource(R.drawable.icon_check_bor_nor);
                        v.setTag(false);
                    }
                    if (checkChangedListener != null)
                        checkChangedListener.onCheckChanged(CheckBoxItem.this, isChecked());
                }
            };
            this.containerView.setOnClickListener(this.listener);
        }

        public boolean isChecked() {
            Boolean checked = (Boolean) containerView.getTag();
            return checked != null && checked.booleanValue();
        }

        public void setChecked(boolean checked) {
            if (isChecked() == checked)
                return;
            listener.onClick(containerView);
        }

        public void setCheckChangedListener(OnCheckChangedListener checkChangedListener) {
            this.checkChangedListener = checkChangedListener;
        }
    }

    public static void launchForCaigou(Context context) {
        context.startActivity(new Intent(context, PublishProductActivity.class));
    }

    public static void launchForQuyang(Context context) {
        Intent intent = new Intent(context, PublishProductActivity.class);
        intent.putExtra("type", 1);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_product);

        TitleBar titleBar = ((TitleBar) findViewById(R.id.title_bar));
        titleBar.setTitle("发布采购需求");
        titleBar.setActivity(this);

        bindCheckBox(true, null,
                new CheckBoxItem(R.id.ll_quality_1, R.id.iv_quality_1),
                new CheckBoxItem(R.id.ll_quality_2, R.id.iv_quality_2),
                new CheckBoxItem(R.id.ll_quality_3, R.id.iv_quality_3)
        );

        final View llCaiggou = findViewById(R.id.ll_caigou);
        final View llQuyang = findViewById(R.id.ll_quyang);
        CheckBoxItem checkBoxItemCaigou = new CheckBoxItem(R.id.ll_type_1, R.id.iv_type_1);
        CheckBoxItem checkBoxItemQuyang = new CheckBoxItem(R.id.ll_type_2, R.id.iv_type_2);
        bindCheckBox(false, new OnCheckChangedListener() {
                    @Override
                    public void onCheckChanged(CheckBoxItem item, boolean checked) {
                        switch (item.containerId) {
                            case R.id.ll_type_1:
                                llCaiggou.setVisibility(checked ? View.VISIBLE : View.GONE);
                                break;
                            case R.id.ll_type_2:
                                llQuyang.setVisibility(checked ? View.VISIBLE : View.GONE);
                                break;
                        }
                    }
                },
                checkBoxItemCaigou, checkBoxItemQuyang
        );
        int type = getIntent().getIntExtra("type", 0);
        (type > 0 ? checkBoxItemQuyang : checkBoxItemCaigou).setChecked(true);

        final TextView tvUnit = (TextView) findViewById(R.id.tv_unit);
        final TextView tvUnit2 = (TextView) findViewById(R.id.tv_unit2);
        Spinner spinner = (Spinner) findViewById(R.id.sp_unit);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String unit = (String) parent.getSelectedItem();
                tvUnit.setText(String.format("%1$s内", unit));
                tvUnit2.setText(String.format("元/%1$s", unit));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bindCheckBoxWithEditText(R.id.et_limit, R.id.cb_limit);
        bindCheckBoxWithEditText(R.id.et_limit2, R.id.cb_limit2);
        bindCheckBoxWithEditText(R.id.et_quyang, R.id.cb_quyang);

        findViewById(R.id.rl_select_class).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RightClassSelecterDialogFragment fragment = new RightClassSelecterDialogFragment();
                fragment.show(getSupportFragmentManager());
            }
        });
        findViewById(R.id.rl_select_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RightColorSelecterDialogFragment fragment = new RightColorSelecterDialogFragment();
                fragment.show(getSupportFragmentManager());
            }
        });
        findViewById(R.id.btn_pub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void bindCheckBoxWithEditText(int editTextId, int checkBoxId) {
        final EditText editText = (EditText) findViewById(editTextId);
        ((CheckBox) findViewById(checkBoxId)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editText.setEnabled(isChecked);
            }
        });
    }

    private void bindCheckBox(boolean setFirstChecked, final OnCheckChangedListener listener, final CheckBoxItem... items) {
        OnCheckChangedListener listener2 = new OnCheckChangedListener() {
            @Override
            public void onCheckChanged(CheckBoxItem item, boolean checked) {
                if (checked) {
                    for (CheckBoxItem checkBoxItem : items) {
                        if (checkBoxItem != item)
                            checkBoxItem.setChecked(false);
                    }
                }
                if (listener != null)
                    listener.onCheckChanged(item, checked);
            }
        };
        for (CheckBoxItem item : items) {
            item.setCheckChangedListener(listener2);
        }
        if (setFirstChecked)
            items[0].setChecked(true);
    }
}
