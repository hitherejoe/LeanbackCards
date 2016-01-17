package com.hitherejoe.sample.ui.adapter;

import android.content.Context;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;

import com.hitherejoe.sample.ui.presenter.IconItemPresenter;
import com.hitherejoe.sample.ui.presenter.LoadingPresenter;
import com.hitherejoe.sample.ui.presenter.TagItemPresenter;
import com.hitherejoe.sample.IconCardView;
import com.hitherejoe.sample.LoadingCardView;
import com.hitherejoe.sample.TagCardView;


public class CardAdapter extends ArrayObjectAdapter {

    private LoadingPresenter mLoadingPresenter;
    private IconItemPresenter mIconItemPresenter;
    private TagItemPresenter mTagItemPresenter;

    public CardAdapter(Context context) {
        mLoadingPresenter = new LoadingPresenter();
        mIconItemPresenter = new IconItemPresenter();
        mTagItemPresenter = new TagItemPresenter();
        setPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object item) {
                if (item instanceof LoadingCardView) {
                    return mLoadingPresenter;
                } else if (item instanceof IconCardView) {
                    return mIconItemPresenter;
                } else if (item instanceof TagCardView) {
                    return mTagItemPresenter;
                }
                return null;
            }
        });
    }

}