package com.hitherejoe.sample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.BaseCardView;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.hitherejoe.leanbackcards.R;

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
        buildLoadingCardView(getImageCardViewStyle(context, attrs, defStyleAttr));
    }

    private void buildLoadingCardView(int styleResId) {
        setFocusable(false);
        setFocusableInTouchMode(false);
        setCardType(CARD_TYPE_MAIN_ONLY);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.view_tag_card, this);

        mTagIcon = (ImageView) findViewById(R.id.image_icon);
        mTagText = (TextView) findViewById(R.id.text_tag);

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
        setCardIcon(ContextCompat.getDrawable(getContext(), resource));
    }

    public void setCardIcon(Drawable drawable) {
        mTagIcon.setImageDrawable(drawable);
    }

    private static Context getStyledContext(Context context, AttributeSet attrs, int defStyleAttr) {
        int style = getImageCardViewStyle(context, attrs, defStyleAttr);
        return new ContextThemeWrapper(context, style);
    }

    private static int getImageCardViewStyle(Context context, AttributeSet attrs, int defStyleAttr) {
        // Read style attribute defined in XML layout.
        int style = null == attrs ? 0 : attrs.getStyleAttribute();
        if (0 == style) {
            // Not found? Read global ImageCardView style from Theme attribute.
            TypedArray styledAttrs =
                    context.obtainStyledAttributes(R.styleable.LeanbackTheme);
            style = styledAttrs.getResourceId(R.styleable.LeanbackTheme_imageCardViewStyle, 0);
            styledAttrs.recycle();
        }
        return style;
    }

    @Override
    public boolean hasOverlappingRendering() {
        return false;
    }

}