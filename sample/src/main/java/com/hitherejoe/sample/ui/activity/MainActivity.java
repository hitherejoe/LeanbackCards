package com.hitherejoe.sample.ui.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.hitherejoe.sample.R;
import com.hitherejoe.sample.ui.fragment.MainFragment;

public class MainActivity extends Activity {

    FrameLayout mFragmentContainer;

    private Fragment mBrowseFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentContainer = (FrameLayout) findViewById(R.id.frame_container);

        mBrowseFragment = new MainFragment();

        getFragmentManager().beginTransaction()
                .replace(mFragmentContainer.getId(), mBrowseFragment).commit();
    }

    public boolean isFragmentActive() {
        return mBrowseFragment instanceof MainFragment &&
                mBrowseFragment.isAdded() &&
                !mBrowseFragment.isDetached() &&
                !mBrowseFragment.isRemoving() &&
                !((MainFragment) mBrowseFragment).isStopping();
    }

}