package com.hitherejoe.leanbackcards;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.support.v17.leanback.widget.BaseCardView;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class LoadingCardView extends BaseCardView {

    private RelativeLayout mLoadingLayout;
    private ProgressBar mProgressBar;

    public LoadingCardView(Context context) {
        this(context, null);
    }

    public LoadingCardView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.imageCardViewStyle);
    }

    public LoadingCardView(Context context, int styleResId) {
        super(new ContextThemeWrapper(context, styleResId), null, 0);
        buildLoadingCardView(styleResId);
    }

    public LoadingCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(getStyledContext(context, attrs, defStyleAttr), attrs, defStyleAttr);
        buildLoadingCardView(getLoadingCardViewStyle(context, attrs, defStyleAttr));
    }

    @Override
    public boolean hasOverlappingRendering() {
        return false;
    }

    private void buildLoadingCardView(int styleResId) {
        setFocusable(false);
        setFocusableInTouchMode(false);
        setCardType(CARD_TYPE_MAIN_ONLY);

        Context context = getContext();

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.view_loading_card, this);
        TypedArray cardAttrs = context.obtainStyledAttributes(styleResId, R.styleable.TagCardView);

        mLoadingLayout = (RelativeLayout) findViewById(R.id.layout_loading);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_indicator);

        int backgroundColor =
                cardAttrs.getInt(R.styleable.LoadingCardView_loading_background_color,
                        ContextCompat.getColor(context, R.color.default_header));

        int progressColor =
                cardAttrs.getInt(R.styleable.LoadingCardView_loading_progress_color,
                        ContextCompat.getColor(context, R.color.white));

        setCardBackgroundColor(backgroundColor);
        setProgressColor(progressColor);

        cardAttrs.recycle();
    }

    public void setCardBackgroundColor(int colorResource) {
        setBackgroundColor(colorResource);
    }

    public void setProgressColor(int color) {
        mProgressBar.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    public boolean isLoading() {
        return mProgressBar.getVisibility() == View.VISIBLE;
    }

    public void setLoading(boolean isLoading) {
        mProgressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

    private static Context getStyledContext(Context context, AttributeSet attrs, int defStyleAttr) {
        int style = getLoadingCardViewStyle(context, attrs, defStyleAttr);
        return new ContextThemeWrapper(context, style);
    }

    private static int getLoadingCardViewStyle(Context context,
                                               AttributeSet attrs,
                                               int defStyleAttr) {
        int style = null == attrs ? 0 : attrs.getStyleAttribute();
        if (0 == style) {
            TypedArray styledAttrs =
                    context.obtainStyledAttributes(R.styleable.LoadingCardView);
            style = styledAttrs.getResourceId(R.styleable.LoadingCardView_loading_theme, 0);
            styledAttrs.recycle();
        }
        return style;
    }


}