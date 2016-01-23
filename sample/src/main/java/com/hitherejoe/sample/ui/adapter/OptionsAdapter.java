package com.hitherejoe.sample.ui.adapter;

import android.content.Context;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;

import com.hitherejoe.sample.ui.data.model.IconItem;
import com.hitherejoe.sample.ui.presenter.IconItemPresenter;

public class OptionsAdapter extends ArrayObjectAdapter {

    private IconItemPresenter mOptionsItemPresenter;

    public OptionsAdapter(Context context) {
        mOptionsItemPresenter = new IconItemPresenter();
        setPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object item) {
                return mOptionsItemPresenter;
            }
        });
    }

    public void addOption(IconItem option) {
        add(option);
    }

}