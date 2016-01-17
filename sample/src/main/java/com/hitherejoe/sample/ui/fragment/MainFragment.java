package com.hitherejoe.sample.ui.fragment;

import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v4.content.ContextCompat;

import com.hitherejoe.sample.LoadingCardView;
import com.hitherejoe.sample.TagCardView;
import com.hitherejoe.sample.ui.adapter.CardAdapter;
import com.hitherejoe.sample.ui.presenter.HeaderItemPresenter;
import com.hitherejoe.sample.R;

public class MainFragment extends BrowseFragment {

    private ArrayObjectAdapter mRowsAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        setAdapter(mRowsAdapter);

        setupUIElements();
        addCardRows();
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

        CardAdapter mIconCardAdapter = new CardAdapter(getActivity());
      //  mIconCardAdapter.add(new LoadingCardView(getActivity()));
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
    }

}