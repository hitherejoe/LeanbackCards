package com.hitherejoe.leanbackcards;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v17.leanback.widget.BaseCardView;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hitherejoe.leanbackcards.widget.PreviewCardView;

public class LiveCardView extends BaseCardView {

    private PreviewCardView mPreviewCard;

    private TextView mTitleView;
    private TextView mContentView;
    private boolean mAttachedToWindow;

    public LiveCardView(Context context) {
        this(context, null);
    }

    public LiveCardView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.imageCardViewStyle);
    }

    public LiveCardView(Context context, int styleResId) {
        super(new ContextThemeWrapper(context, styleResId), null, 0);
        buildImageCardView(styleResId);
    }

    public LiveCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(getStyledContext(context, attrs, defStyleAttr), attrs, defStyleAttr);
        buildImageCardView(getImageCardViewStyle(context, attrs, defStyleAttr));
    }

    @Override
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAttachedToWindow = true;
        ImageView mImageView = mPreviewCard.getImageView();
        if (mImageView.getAlpha() == 0) fadeIn();
    }

    @Override
    protected void onDetachedFromWindow() {
        ImageView mImageView = mPreviewCard.getImageView();
        mAttachedToWindow = false;
        mImageView.animate().cancel();
        mImageView.setAlpha(1f);
        super.onDetachedFromWindow();
    }

    private void buildImageCardView(int styleResId) {
        setFocusable(true);
        setFocusableInTouchMode(true);

        Context context = getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_live_card, this);

        mPreviewCard = (PreviewCardView) view.findViewById(R.id.layout_preview_card);
        mTitleView = (TextView) findViewById(R.id.title_text);
        mContentView = (TextView) findViewById(R.id.content_text);

        TypedArray cardAttrs =
                getContext().obtainStyledAttributes(styleResId, R.styleable.LiveCardView);

        int cardBackgroundColor =
                cardAttrs.getInt(R.styleable.LiveCardView_live_background_color,
                        ContextCompat.getColor(context, R.color.default_detail));
        int textColor =
                cardAttrs.getInt(R.styleable.LiveCardView_live_text_color,
                        ContextCompat.getColor(context, R.color.white));

        setTextColor(textColor);
        setCardBackgroundColor(cardBackgroundColor);

        cardAttrs.recycle();
    }

    public void setMainContainerDimensions(int width, int height) {
        ViewGroup.LayoutParams lp = mPreviewCard.getLayoutParams();
        lp.width = width;
        lp.height = height;
        mPreviewCard.setLayoutParams(lp);
    }

    public final ImageView getMainImageView() {
        return mPreviewCard.getImageView();
    }

    public void setCardBackgroundColor(int color) {
        setBackgroundColor(color);
    }

    public void setTitleText(CharSequence text) {
        mTitleView.setText(text);
    }

    public void setContentText(CharSequence text) {
        mContentView.setText(text);
    }

    public void setTextColor(int color) {
        mTitleView.setTextColor(color);
        mContentView.setTextColor(color);
    }

    public void setVideoUrl(String url) {
        mPreviewCard.setVideoUrl(url);
    }

    public void startVideo() {
        mPreviewCard.setLoading();
    }

    public void stopVideo() {
        mPreviewCard.setFinished();
    }

    private static Context getStyledContext(Context context, AttributeSet attrs, int defStyleAttr) {
        int style = getImageCardViewStyle(context, attrs, defStyleAttr);
        return new ContextThemeWrapper(context, style);
    }

    private static int getImageCardViewStyle(Context context, AttributeSet attrs, int defStyleAttr) {
        int style = null == attrs ? 0 : attrs.getStyleAttribute();
        if (0 == style) {
            TypedArray styledAttrs = context.obtainStyledAttributes(R.styleable.LiveCardView);
            style = styledAttrs.getResourceId(R.styleable.LiveCardView_live_theme, 0);
            styledAttrs.recycle();
        }
        return style;
    }

    private void fadeIn() {
        ImageView mImageView = mPreviewCard.getImageView();
        mImageView.setAlpha(0f);
        if (mAttachedToWindow) {
            int duration =
                    mImageView.getResources().getInteger(android.R.integer.config_shortAnimTime);
            mImageView.animate().alpha(1f).setDuration(duration);
        }
    }

}