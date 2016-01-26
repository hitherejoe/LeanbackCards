package com.hitherejoe.sample.ui.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.Presenter;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.hitherejoe.leanbackcards.LiveCardView;
import com.hitherejoe.sample.R;
import com.hitherejoe.sample.ui.activity.MainActivity;
import com.hitherejoe.sample.ui.data.model.Post;

public class LiveCardPresenter extends Presenter {

    private static final int CARD_WIDTH = 300;
    private static final int CARD_HEIGHT = 300;
    private static int sSelectedBackgroundColor;
    private static int sDefaultBackgroundColor;
    private Drawable mDefaultCardImage;
    private Context mContext;

    public LiveCardPresenter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        final Context context = parent.getContext();
        sDefaultBackgroundColor = ContextCompat.getColor(context, R.color.primary);
        sSelectedBackgroundColor = ContextCompat.getColor(context, R.color.primary_dark);
       // mDefaultCardImage = ContextCompat.getDrawable(context, R.drawable.ic_card_default);

        final LiveCardView cardView = new LiveCardView(parent.getContext());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardView.stopVideo();
            }
        });

        cardView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    cardView.startVideo();
                } else {
                    if (mContext instanceof MainActivity) {
                        if (((MainActivity) mContext).isFragmentActive()) {
                            cardView.stopVideo();
                        }
                    } else {
                        cardView.stopVideo();
                    }
                }
            }
        });

        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        updateCardBackgroundColor(cardView, false);
        return new ViewHolder(cardView);
    }

    private static void updateCardBackgroundColor(LiveCardView view, boolean selected) {
        int color = selected ? sSelectedBackgroundColor : sDefaultBackgroundColor;
        // Both background colors should be set because the view's background is temporarily visible
        // during animations.
        view.setBackgroundColor(color);
        view.findViewById(R.id.info_field).setBackgroundColor(color);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        if (item instanceof Post) {
            Post post = (Post) item;

            final LiveCardView cardView = (LiveCardView) viewHolder.view;
            if (post.videoUrl != null) {
                cardView.setTitleText(post.description);
                cardView.setContentText(post.username);
                cardView.setMainContainerDimensions(CARD_WIDTH, CARD_HEIGHT);
                cardView.setVideoUrl(post.videoUrl);

                Glide.with(cardView.getContext())
                        .load(post.thumbnailUrl)
                        .centerCrop()
                        .error(mDefaultCardImage)
                        .into(cardView.getMainImageView());
            }
        }
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) { }
}