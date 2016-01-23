package com.hitherejoe.leanbackcards;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v17.leanback.widget.BaseCardView;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TagCardView extends BaseCardView {

    private TextView mTagText;
    private ImageView mTagIcon;

    public TagCardView(Context context) {
        this(context, null);
    }

    public TagCardView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.imageCardViewStyle);
    }

    public TagCardView(Context context, int styleResId) {
        super(new ContextThemeWrapper(context, styleResId), null, 0);
        buildLoadingCardView(styleResId);
    }

    public TagCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(getStyledContext(context, attrs, defStyleAttr), attrs, defStyleAttr);
        buildLoadingCardView(getTagCardViewStyle(context, attrs, defStyleAttr));
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
        inflater.inflate(R.layout.view_tag_card, this);
        TypedArray cardAttrs = context.obtainStyledAttributes(styleResId, R.styleable.TagCardView);

        int backgroundColor =
                cardAttrs.getInt(R.styleable.TagCardView_tagCardColor,
                        ContextCompat.getColor(context, R.color.default_header));
        int textColor =
                cardAttrs.getInt(R.styleable.TagCardView_tagTextColor,
                        ContextCompat.getColor(context, R.color.white));

        int drawableResource = cardAttrs.getInt(R.styleable.TagCardView_tagIcon, R.drawable.ic_tag);

        RelativeLayout tagLayout = (RelativeLayout) findViewById(R.id.layout_tag);
        mTagIcon = (ImageView) findViewById(R.id.image_icon);
        mTagText = (TextView) findViewById(R.id.text_tag);

        tagLayout.setBackgroundColor(backgroundColor);
        mTagText.setTextColor(textColor);
        mTagIcon.setImageResource(drawableResource);

        cardAttrs.recycle();
    }

    public void setCardBackgroundColor(int colorResource) {
        setBackgroundColor(ContextCompat.getColor(getContext(), colorResource));
    }

    public void setCardText(String string) {
        mTagText.setText(string);
    }

    public String getCardText() {
        return mTagText.getText().toString();
    }

    public void setCardIcon(int resource) {
        mTagIcon.setImageResource(resource);
    }

    private static Context getStyledContext(Context context, AttributeSet attrs, int defStyleAttr) {
        int style = getTagCardViewStyle(context, attrs, defStyleAttr);
        return new ContextThemeWrapper(context, style);
    }

    private static int getTagCardViewStyle(Context context, AttributeSet attrs, int defStyleAttr) {
        int style = null == attrs ? 0 : attrs.getStyleAttribute();
        if (0 == style) {
            TypedArray styledAttrs =
                    context.obtainStyledAttributes(R.styleable.TagCardView);
            style = styledAttrs.getResourceId(R.styleable.TagCardView_tagCardTheme, 0);
            styledAttrs.recycle();
        }
        return style;
    }



}