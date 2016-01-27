# LeanbackCards

<p align="center">
    <img src="images/title_image.png" alt="Live Card"/>
</p>

Leanback cards is a Widget library for use with Android TV applications. It provides an extended set of
customisable content cards to enhance your User Interfaces. The cards currently include:

## Live Card

<p align="center">
    <img src="images/live_card.gif" alt="Live Card"/>
</p>

A live card allows you to show a looping video when the card view becomes focused, allowing your
browsing experience to feel more dynamic. You can add a live card in several ways:

- By creating a new instance and setting it's properties programatically:

```java
LiveCardView liveCardView = new LiveCardView(Context context);
```

```java
liveCardView.setVideoUrl(videoUrl);
liveCardView.startVideo();
liveCardView.stopVideo();
liveCardView.setCardBackgroundColor(R.color.primary);
liveCardView.setTitleText(getString(R.string.title));
liveCardView.setTextColor(R.color.white);
```

- By creating a new instance and passing in a style:

```java
LiveCardView liveCardView = new LiveCardView(Context context, AttributeSet attrs);
```

```xml
<style name="LiveCardStyle">
    <item name="live_background_color">@color/primary</item>
    <item name="live_text_color">@color/white</item>
</style>
```

## Loading Card

<p align="center">
    <img src="images/loading.gif" alt="Loading Card"/>
</p>

A loading card allows you to show a simple progress bar to make the user aware that content is being
loaded. You can add a loading card in several ways:

- By creating a new instance and setting it's properties programatically:

```java
LoadingCardView loadingCardView = new LoadingCardView(Context context)
```

It's background color can be set using:

```java
loadingCardView.setCardBackgroundColor(R.color.primary)
```

and you can check it is loading and set it's loading state like so:

```java
loadingCardView.setLoading(true);
loadingCardView.setCardBackgroundColor(R.color.primary);
loadingCardView.setProgressColor(R.color.white);
boolean isLoading = loadingCardView.isLoading();
```

- By creating a new instance and passing in a style:

```java
LoadingCardView loadingCardView = new LoadingCardView(Context context, AttributeSet attrs)
```

```xml
<style name="LoadingCardStyle">
    <item name="loading_background_color">@color/primary</item>
    <item name="loading_progress_color">@color/white</item>
</style>
```

## Tag Card

<p align="center">
    <img src="images/tag_card.png" alt="Tag Card"/>
</p>

A tag card allows you to show an icon/text pair. You can add a tag card in several ways:

- By creating a new instance and setting it's properties programatically:

```java
TagCardView tagCardView = new TagCardView(Context context)
```

```java
tagCardView.setCardBackgroundColor(R.color.primary)
tagCardView.setCardText(R.color.primary)
tagCardView.setCardTextColor(R.color.primary)
tagCardView.setCardIcon(R.drawable.ic_tag)
```

- By creating a new instance and passing in a style:

```java
TagCardView tagCardView = new TagCardView(Context context, AttributeSet attrs)
```

```xml
<style name="TagCardStyle">
    <item name="tag_card_background_color">@color/primary</item>
    <item name="tag_text_color">@color/white</item>
    <item name="tag_icon">@drawable/ic_tag</item>
</style>
```

## Icon Card

<p align="center">
    <img src="images/icon_card.png" alt="Icon Card"/>
</p>

An icon card allows you to display a title/detail pair with an icon for visual representation. You
can add an icon card in several ways:

- By creating a new instance and setting it's properties programatically:

```java
IconCardView iconCardView = new IconCardView(Context context)
```

```java
iconCardView.setCardBackgroundColor(R.color.primary);
iconCardView.setDetailBackgroundColor(R.color.primary_dark);
iconCardView.setTitleText(getString(R.string.your_string));
iconCardView.setDetailText(getString(R.string.your_string));
iconCardView.setTitleTextColor(R.color.white);
iconCardView.setDetailTextColor(R.color.white);
iconCardView.setIcon(R.drawable.ic_icon);
```

- By creating a new instance and passing in a style:

```java
IconCardView iconCardView = new IconCardView(Context context, AttributeSet attrs)
```

```xml
<style name="IconCardStyle">
    <item name="icon_card_background_color">@color/primary</item>
    <item name="icon_detail_background_color">@color/primary_dark</item>
    <item name="icon_title_text_color">@color/white</item>
    <item name="icon_detail_text_color">@color/white</item>
    <item name="icon_header_icon">@drawable/ic_icon</item>
</style>
```
