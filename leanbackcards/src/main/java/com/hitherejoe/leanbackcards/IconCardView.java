package com.hitherejoe.leanbackcards;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.BaseCardView;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class IconCardView extends BaseCardView {

    private RelativeLayout mLayout;
    private RelativeLayout mHeader;
    private LinearLayout mDetail;
    private ImageView mIcon;
    private TextView mTitle;
    private TextView mValue;

    public IconCardView(Context context) {
        this(context, null);
    }

    public IconCardView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.imageCardViewStyle);
    }

    public IconCardView(Context context, int styleResId) {
        super(new ContextThemeWrapper(context, styleResId), null, 0);
        buildptionCardView(styleResId);
    }

    public IconCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(getStyledContext(context, attrs, defStyleAttr), attrs, defStyleAttr);
        buildptionCardView(getIconCardViewStyle(context, attrs, defStyleAttr));
    }

    @Override
    public boolean hasOverlappingRendering() {
        return false;
    }

    private void buildptionCardView(int styleResId) {
        setFocusable(true);
        setFocusableInTouchMode(true);
        setCardType(CARD_TYPE_MAIN_ONLY);

        Context context = getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_icon_card, this);
        TypedArray cardAttrs = context.obtainStyledAttributes(styleResId, R.styleable.IconCardView);
        int headerBackground =
                cardAttrs.getInt(R.styleable.IconCardView_icon_title_background_color,
                        ContextCompat.getColor(context, R.color.default_header));
        int detailBackground =
                cardAttrs.getInt(R.styleable.IconCardView_icon_detail_background_color,
                        ContextCompat.getColor(context, R.color.default_detail));
        int titleTextColor =
                cardAttrs.getInt(R.styleable.IconCardView_icon_title_text_color,
                        ContextCompat.getColor(context, R.color.white));
        int detailTextColor =
                cardAttrs.getInt(R.styleable.IconCardView_icon_detail_text_color,
                        ContextCompat.getColor(context, R.color.white));

        int drawableResource =
                cardAttrs.getInt(R.styleable.IconCardView_icon_header_icon, R.drawable.ic_error);

        mLayout = (RelativeLayout) view.findViewById(R.id.layout_option_card);
      //  mHeader = (RelativeLayout) view.findViewById(R.id.layout_header);
      //mDetail = (LinearLayout) view.findViewById(R.id.layout_detail);
        mIcon = (ImageView) view.findViewById(R.id.image_option);
        mTitle = (TextView) view.findViewById(R.id.text_option_title);
        mValue = (TextView) view.findViewById(R.id.text_option_value);

//        setHeaderBackgroundColor(headerBackground);
//        setDetailBackgroundColor(detailBackground);
        mTitle.setTextColor(titleTextColor);
        mValue.setTextColor(detailTextColor);
        mIcon.setImageResource(drawableResource);

        cardAttrs.recycle();
    }

    public void setMainImageDimensions(int width, int height) {
        ViewGroup.LayoutParams lp = mLayout.getLayoutParams();
        lp.width = width;
        lp.height = height;
        mLayout.setLayoutParams(lp);
    }

    public void setIcon(Drawable drawable) {
        mIcon.setImageDrawable(drawable);
    }

    public void setTitleText(String titleText) {
        mTitle.setText(titleText);
    }

    public void setDetailText(String detailText) {
        mValue.setText(detailText);
    }

    public void setTitleTextColor(int color) {
        mTitle.setTextColor(color);
    }

    public void setDetailTextColor(int color) {
        mValue.setTextColor(color);
    }

    public void setHeaderBackgroundColor(int color) {
        mHeader.setBackgroundResource(color);
    }

    public void setDetailBackgroundColor(int color) {
        mDetail.setBackgroundResource(color);
    }

    private static Context getStyledContext(Context context, AttributeSet attrs, int defStyleAttr) {
        int style = getIconCardViewStyle(context, attrs, defStyleAttr);
        return new ContextThemeWrapper(context, style);
    }

    private static int getIconCardViewStyle(Context context, AttributeSet attrs, int defStyleAttr) {
        int style = null == attrs ? 0 : attrs.getStyleAttribute();
        if (0 == style) {
            TypedArray styledAttrs =
                    context.obtainStyledAttributes(R.styleable.IconCardView);
            style = styledAttrs.getResourceId(R.styleable.IconCardView_icon_theme, 0);
            styledAttrs.recycle();
        }
        return style;
    }

}