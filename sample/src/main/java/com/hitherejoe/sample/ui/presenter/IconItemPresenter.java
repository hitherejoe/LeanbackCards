package com.hitherejoe.sample.ui.presenter;

import android.content.Context;
import android.support.v17.leanback.widget.Presenter;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;

import com.hitherejoe.sample.R;
import com.hitherejoe.sample.ui.data.model.IconItem;
import com.hitherejoe.leanbackcards.IconCardView;

public class IconItemPresenter extends Presenter {

    private static int GRID_ITEM_WIDTH = 350;
    private static int GRID_ITEM_HEIGHT = 400;

    public IconItemPresenter() { }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent) {
        final IconCardView iconCardView = new IconCardView(parent.getContext(), R.style.IconCardStyle);
        return new ViewHolder(iconCardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        if (item instanceof IconItem) {
            IconItem iconItem = (IconItem) item;
            IconCardView optionView = (IconCardView) viewHolder.view;
            optionView.setMainImageDimensions(GRID_ITEM_WIDTH, GRID_ITEM_HEIGHT);
            optionView.setTitleText(iconItem.title);
            String value = iconItem.value;
            if (value != null) optionView.setDetailText(iconItem.value);
            Context context = viewHolder.view.getContext();
            optionView.setIcon(ContextCompat.getDrawable(context, iconItem.iconResource));
        }
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) { }
}