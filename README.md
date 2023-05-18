# JetpackComposeMVVM
Sample Jetpack compose project with MVVM architecture. Project includes Hilt for dependecy injection and Flow for emit the data and collect on UI.

- Jetpack Compose
- MVVM architecture [ model-View-View Model]
- Hilt for DI
- Navigation compose
- Retrofit
- OkHttp logging
- Gson converter factory
- Kotlin Coroutine
- Flow for emit and collect data
- Coil for Image loading
- Swipe Refresh in Home and Detail screen
- Adaptive Icon : Theme based Icon support
- Shimmer Effect (Theme based)

## This repository show the List of Country Flags and you can select to know it's name

- Show circular loader until API response come.
- Coil lib used to load the image
- Center crop the image


| #1                                                                                                                                            | #2                                                                                                                                            | #3                                                                                                                                            | #4                                                                                                                                            |
|-----------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| <img src="https://github.com/NrupParikh/JetpackComposeMVVM/assets/108717119/bdf0a830-b7ce-4e73-9fa8-169e4d7859cb" width="100%" height="100%"> | <img src="https://github.com/NrupParikh/JetpackComposeMVVM/assets/108717119/9ad77585-3eab-4502-b044-d29393da4f43" width="100%" height="100%"> | <img src="https://github.com/NrupParikh/JetpackComposeMVVM/assets/108717119/80c4fa9e-8096-4a98-8dee-6a68dfee0cc4" width="100%" height="100%"> | <img src="https://github.com/NrupParikh/JetpackComposeMVVM/assets/108717119/67d4f10d-e6ab-417d-9e30-049b75dee68c" width="100%" height="100%"> |



## Adaptive Icon support

<img src="https://github.com/NrupParikh/JetpackComposeMVVM/assets/108717119/95ababa5-f574-4b16-aea5-555d51784415" width="60%" height="80%"> 

## Video of my work

https://github.com/NrupParikh/JetpackComposeMVVM/assets/108717119/b2d6bfc6-fd31-485e-8f7d-ed455f60747d


### To support theme based icon (Adaptive Icon) Do below configuration changes.

- compileSdk 33
- targetSdk 33
- Remove android:roundIcon="@mipmap/ic_launcher_round" from AndroidManifest.xml
- in res->drawable folder add one XML file name like adaptive_icon.xml


Add this line

~~~
<monochrome android:drawable="@drawable/adaptive_icon"/>
~~~
So, your anydpi-v26/launcher.xml looks like

~~~
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@color/ic_launcher_background"/>
    <foreground android:drawable="@drawable/ic_launcher_foreground"/>
    <monochrome android:drawable="@drawable/adaptive_icon"/>
</adaptive-icon>
~~~

And make Vector drawable of your app icon with below constraints :

- Make the canvas 108x108 px
- Make the App Icon 48x48 px
- Make sure, icon don't have shadow

- To generate App icon to SVG (png to svg) use
  https://svg2vector.com/


- To create adaptive icon, [48px x 48px]
  make your app icon black and white and make blank space as a transparent.

- Use Paint.net software for that.
Reference:  https://www.getpaint.net/download.html

Reference
https://developer.android.com/develop/ui/views/launch/icon_design_adaptive
