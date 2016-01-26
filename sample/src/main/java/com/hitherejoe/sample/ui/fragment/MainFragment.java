package com.hitherejoe.sample.ui.fragment;

import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.support.v4.content.ContextCompat;

import com.hitherejoe.leanbackcards.IconCardView;
import com.hitherejoe.leanbackcards.LiveCardView;
import com.hitherejoe.leanbackcards.LoadingCardView;
import com.hitherejoe.leanbackcards.TagCardView;
import com.hitherejoe.sample.ui.adapter.CardAdapter;
import com.hitherejoe.sample.ui.adapter.OptionsAdapter;
import com.hitherejoe.sample.ui.adapter.PostAdapter;
import com.hitherejoe.sample.ui.data.model.IconItem;
import com.hitherejoe.sample.ui.data.model.Post;
import com.hitherejoe.sample.ui.presenter.HeaderItemPresenter;
import com.hitherejoe.sample.R;

public class MainFragment extends BrowseFragment {

    private ArrayObjectAdapter mRowsAdapter;

    private boolean mIsStopping;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        setAdapter(mRowsAdapter);

        setupUIElements();
        addCardRows();
    }

    @Override
    public void onStart() {
        super.onStart();
        mIsStopping = false;
    }

    @Override
    public void onStop() {
        super.onStop();
        mIsStopping = true;
    }

    public boolean isStopping() {
        return mIsStopping;
    }

    private void setupUIElements() {
        setTitle(getString(R.string.app_name));
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(ContextCompat.getColor(getActivity(), R.color.primary));
        setSearchAffordanceColor(ContextCompat.getColor(getActivity(), R.color.accent));
        setHeaderPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object o) {
                return new HeaderItemPresenter();
            }
        });
    }

    private void addCardRows() {
        CardAdapter mLoadingCardAdapter = new CardAdapter(getActivity());
        mLoadingCardAdapter.add(new LoadingCardView(getActivity(), R.style.LoadingCardStyle));
        HeaderItem gridLoadingCardHeader =
                new HeaderItem(mRowsAdapter.size(), getString(R.string.header_text_loading_card));
        mRowsAdapter.add(new ListRow(gridLoadingCardHeader, mLoadingCardAdapter));

        OptionsAdapter mIconCardAdapter = new OptionsAdapter(getActivity());
        IconItem iconItem = new IconItem();
        iconItem.title = "auto-loop";
        iconItem.value = "enabled";
        iconItem.iconResource = R.drawable.lopp;
        mIconCardAdapter.addOption(iconItem);
        HeaderItem gridIconCardHeader =
                new HeaderItem(mRowsAdapter.size(), getString(R.string.header_text_icon_card));
        mRowsAdapter.add(new ListRow(gridIconCardHeader, mIconCardAdapter));

        CardAdapter mTagCardAdapter = new CardAdapter(getActivity());
        TagCardView tagCardView = new TagCardView(getActivity());
        tagCardView.setCardText("hitherejoe");
        mTagCardAdapter.add(tagCardView);
        HeaderItem gridTagCardHeader =
                new HeaderItem(mRowsAdapter.size(), getString(R.string.header_text_tag_card));
        mRowsAdapter.add(new ListRow(gridTagCardHeader, mTagCardAdapter));

        PostAdapter mVideoCardAdapter = new PostAdapter(getActivity());
        Post post = new Post();
        post.username = "hitherejoe";
        post.description = "Just a video!";
        post.thumbnailUrl = "https://scontent-lhr3-1.xx.fbcdn.net/hphotos-xft1/v/t1.0-9/12417967_736526203114731_7636627666986228009_n.jpg";
        post.videoUrl = "http://v.cdn.vine.co/r/videos/CF9585B3A31290758684187713536_43febf64eb6.4.0.3440879595394339929.mp4";
        mVideoCardAdapter.addOption(post);
        HeaderItem gridLiveCardHeader =
                new HeaderItem(mRowsAdapter.size(), getString(R.string.header_text_live_card));
        mRowsAdapter.add(new ListRow(gridLiveCardHeader, mVideoCardAdapter));
    }

}