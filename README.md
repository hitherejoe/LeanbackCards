# LeanbackCards

Leanback cards is a library for us with Android TV applications that provides an extended set of
customisable content cards. This includes:

## Loading Card View

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

## Tag Card View

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

## Icon Card View

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