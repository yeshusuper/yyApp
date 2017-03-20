package com.fuliaohui.yy;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fuliaohui.yy.fragments.ClassSelecterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Fragment classSelecterFragment = new ClassSelecterFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_fragment, classSelecterFragment)
                .show(classSelecterFragment)
                .commit();
    }
}
