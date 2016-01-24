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

You can add a live card in several ways:

- By creating a new instance and setting it's properties programatically:

```java
LiveCardView liveCardView = new LiveCardView(Context context);
```

```java
liveCardView.setVideoUrl(videoUrl);
liveCardView.startVideo();
liveCardView.stopVideo();
liveCardView.setInfoAreaBackgroundColor(R.color.primary);
liveCardView.setTitleText(getString(R.string.title));
liveCardView.setTitleTextColor(R.color.white);
liveCardView.stopVideo();
```

- By creating a new instance and passing in a style:

```java
LiveCardView liveCardView = new LiveCardView(Context context, AttributeSet attrs);
```

```xml
<style name="LiveCardStyle">
    <item name="liveCardColor">@color/primary</item>
    <item name="liveTextColor">@color/white</item>
</style>
```

## Loading Card

<p align="center">
    <img src="images/loading.gif" alt="Loading Card"/>
</p>

You can add a loading card in several ways:

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
boolean isLoading = loadingCardView.isLoading();
```

- By creating a new instance and passing in a style:

```java
LoadingCardView loadingCardView = new LoadingCardView(Context context, AttributeSet attrs)
```

```xml
<style name="LoadingCardStyle">
    <item name="loadingBackgroundColor">@color/primary</item>
</style>
```

## Tag Card

<p align="center">
    <img src="images/tag_card.png" alt="Tag Card"/>
</p>

You can add a tag card in several ways:

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
    <item name="tagCardColor">@color/primary</item>
    <item name="tagTextColor">@color/white</item>
    <item name="tagIcon">@drawable/ic_tag</item>
</style>
```

## Icon Card

<p align="center">
    <img src="images/icon_card.png" alt="Icon Card"/>
</p>

You can add an icon card in several ways:

- By creating a new instance and setting it's properties programatically:

```java
IconCardView iconCardView = new IconCardView(Context context)
```

```java
iconCardView.setHeaderBackgroundColor(R.color.primary);
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
    <item name="titleBackgroundColor">@color/primary</item>
    <item name="detailBackgroundColor">@color/primary_dark</item>
    <item name="titleTextColor">@color/white</item>
    <item name="detailTextColor">@color/white</item>
    <item name="headerIcon">@drawable/ic_icon</item>
</style>
```