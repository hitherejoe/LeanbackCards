package com.hitherejoe.sample.ui.adapter;

import android.content.Context;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;

import com.hitherejoe.sample.ui.data.model.IconItem;
import com.hitherejoe.sample.ui.data.model.Post;
import com.hitherejoe.sample.ui.presenter.IconItemPresenter;
import com.hitherejoe.sample.ui.presenter.LiveCardPresenter;

public class PostAdapter extends ArrayObjectAdapter {

    private LiveCardPresenter mOptionsItemPresenter;

    public PostAdapter(Context context) {
        mOptionsItemPresenter = new LiveCardPresenter(context);
        setPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object item) {
                return mOptionsItemPresenter;
            }
        });
    }

    public void addOption(Post post) {
        add(post);
    }

}