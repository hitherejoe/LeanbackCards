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

    public static final int CARD_TYPE_FLAG_IMAGE_ONLY = 0;
    public static final int CARD_TYPE_FLAG_TITLE = 1;
    public static final int CARD_TYPE_FLAG_CONTENT = 2;

    private PreviewCardView mPreviewCard;
    private ViewGroup mInfoArea;

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
        mInfoArea = (ViewGroup) view.findViewById(R.id.info_field);

        TypedArray cardAttrs =
                getContext().obtainStyledAttributes(styleResId, R.styleable.LiveCardView);

        int cardBackgroundColor =
                cardAttrs.getInt(R.styleable.LiveCardView_live_background_color,
                        ContextCompat.getColor(context, R.color.default_detail));
        int titleTextColor =
                cardAttrs.getInt(R.styleable.LiveCardView_live_text_color,
                        ContextCompat.getColor(context, R.color.white));

        int cardType =
                cardAttrs.getInt(
                        R.styleable.lbImageCardView_lbImageCardViewType, CARD_TYPE_FLAG_IMAGE_ONLY);
        boolean hasImageOnly = cardType == CARD_TYPE_FLAG_IMAGE_ONLY;
        boolean hasTitle = (cardType & CARD_TYPE_FLAG_TITLE) == CARD_TYPE_FLAG_TITLE;
        boolean hasContent = (cardType & CARD_TYPE_FLAG_CONTENT) == CARD_TYPE_FLAG_CONTENT;

        if (hasImageOnly) {
            removeView(mInfoArea);
            cardAttrs.recycle();
            return;
        }

        if (hasTitle) {
            mTitleView = (TextView) inflater.inflate(
                    R.layout.lb_image_card_view_themed_title, mInfoArea, false);
            mInfoArea.addView(mTitleView);
            setTitleTextColor(titleTextColor);
        }

        if (hasContent) {
            mContentView = (TextView) inflater.inflate(
                    R.layout.lb_image_card_view_themed_content, mInfoArea, false);
            mInfoArea.addView(mContentView);
        }

        setInfoAreaBackgroundColor(cardBackgroundColor);

        cardAttrs.recycle();
    }

    public void setInfoAreaBackgroundColor(int color) {
        if (mInfoArea != null) mInfoArea.setBackgroundColor(color);
    }

    public void setTitleText(CharSequence text) {
        if (mTitleView != null) mTitleView.setText(text);
    }

    public void setTitleTextColor(int color) {
        if (mTitleView != null) mTitleView.setTextColor(color);
    }

    public void setContentText(CharSequence text) {
        if (mContentView != null) mContentView.setText(text);
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