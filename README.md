# LeanbackCards

Leanback cards is a library for us with Android TV applications that provides an extended set of
customisable content cards. This includes:

## Loading Card View

<p align="center">
    <img src="images/loading.gif" alt="Loading Card"/>
</p>

You can add a loading card in several ways:

- By creating a new instance and setting it's properties programatically:

```LoadingCardView(Context context)```

It's background color can be set using:

```loadingCardView.setCardBackgroundColor(R.color.primary)```

You can check it is loading and set it's loading state like so:

```
loadingCardView.setLoading(true);
boolean isLoading = loadingCardView.isLoading();
```

- By creating a new instance and passing in a style:

```LoadingCardView(Context context, AttributeSet attrs)```

```
<style name="LoadingCardStyle">
        <item name="loadingBackgroundColor">@color/primary</item>
    </style>
```

## Tag Card View

<p align="center">
    <img src="images/tag_card.png" alt="Tag Card"/>
</p>

## Icon Card View

<p align="center">
    <img src="images/icon_card.png" alt="Icon Card"/>
</p>

You can add an icon card in several ways:

- By creating a new instance and setting it's properties programatically:

```IconCardView(Context context)```

```
iconCardView.setHeaderBackgroundColor(R.color.primary);
iconCardView.setDetailBackgroundColor(R.color.primary_dark);
iconCardView.setTitleText(getString(R.string.your_string));
iconCardView.setDetailText(getString(R.string.your_string));
iconCardView.setTitleTextColor(R.color.white);
iconCardView.setDetailTextColor(R.color.white);
iconCardView.setIcon(R.drawable.ic_icon);
```

- By creating a new instance and passing in a style:

```IconCardView(Context context, AttributeSet attrs)```

```
<style name="IconCardStyle">
    <item name="titleBackgroundColor">@color/primary</item>
    <item name="detailBackgroundColor">@color/primary_dark</item>
    <item name="titleTextColor">@color/white</item>
    <item name="detailTextColor">@color/white</item>
    <item name="headerIcon">@drawable/ic_icon</item>
</style>
```

