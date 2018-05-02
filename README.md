# OnBoardingEasy
 An Android library that allows you to easily create applications with OnBoarding/Intro pages. You may use it in your Android apps provided that you cite this project and include the license in your app. Thanks!



![Alt Text](https://github.com/vasu-bhardwaj/OnBoardingEasy/blob/master/preview/ImgPreview.gif)


## Features
- Easily add new slides
- Beautiful 
- Supports Gradient Background
- Add images to background slide or static colors

## Usage
### Step 1:
#### Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```gradle

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}	
```	

 ### Step 2:
#### Add the dependency

```gradle

	dependencies {
	        implementation 'com.github.vasu-bhardwaj:OnBoardingEasy:v1.6'
	}
```
	
 ### Step 3:
#### Create a new Activity that extends EasyOnBoarding
	public class MyIntroActivity extends EasyOnBoarding 

 ### Step 4:
#### Add Intro pages
```java
	public class MyIntroActivity extends EasyOnBoarding {

  	// Note here that we DO NOT use setContentView();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	
	// Create your slide fragments here.
     IntroCards card1 = new IntroCards("Intelligent",
                "First Wallpaper with Artificial Intelligence Capabilities");
		
	// set background for your intro page
	// background can be a color or a image 
	
	card1.setBackground(R.color.Red);
	
	IntroCards card2 = new IntroCards("Hankpicked Images", "Every Image is carefully selected");
	
	card2.setBackground(R.color.Blue);
	

	IntroCards card3 = new IntroCards("Automatic Wallpaper",
                				"Wallpaper are changed automatically");
	card3.setBackground(R.color.Green);
	
	// add pages . Don't forget to add pages , other wise the page will not be shown

	addPage(card1);
	addPage(card2);
	addPage(card3);
	
	// final step call setIntro();
	setupIntro();

     }


}
```
 ### Step 5:
#### Add activity to manifest with defined theme:


``` xml

        <activity
            android:name=".MyIntroActivity"
            android:theme="@style/AppTheme" />
```
	    
 ### Step 6:
#### Customize Intro Activity:

#### Skip Button
Add custom code to skip button. 
This button allows user to skip all the intro page and show him the Main Activity of application.
Note-> don't forget to add 
``` java 
startActivty(new Intent(MyIntroActivity.this, your.class)));
```
Override setupSkipButton();
``` java 
@Override
    public void setupSkipButton() {
        super.setupSkipButton();
        Toast.makeText(this,"Skip",Toast.LENGTH_SHORT).show();
	startActivty(new Intent(MyIntroActivity.this, your.class)));

    }
```

  #### Finish Button
  Add custom code to finsih button.
  This button is only shown when user is on last page. 
  So don't forget to add 
  	``` java
		startActivty(new Intent(MyIntroActivity.this, your.class)));
  	```.
	
  Override setupFinishButton();
  
  ``` java
    @Override
    public void setupFinishButton() {
        super.setupFinishButton();
        Toast.makeText(this,"Start",Toast.LENGTH_SHORT).show();
	startActivty(new Intent(MyIntroActivity.this, your.class)));

    }
```

#### Custom slides
  ``` java
IntroCards card1 = new IntroCards("Intelligent",
                "First Wallpaper with Artificial Intelligence Capabilities");
```
##### Background:
To set Color as background for your slide 
  ``` java

	card1.setBackground(R.color.Red);
```
To set Image as background for your slide 
  ``` java

      card1setBackground(R.drawable.myBackgroundImage)
```
##### Title Color:
  ``` java

card1.setTitleColor(R.color.colorPrimary);
```
##### Description Color:
  ``` java

card1.setDescriptionColor(R.color.colorAccent);
```


## Gradient Flow Background Slides

![Alt Text](https://github.com/vasu-bhardwaj/OnBoardingEasy/blob/master/preview/GradientPreview.gif)



### Step 1:
In your drawable folderr create an drawable resources xml file 
and add custom color.
for example we will let file name be gradient_background1.xml. (you can name whatever name you want)
``` xml
<?xml version="1.0" encoding="utf-8"?>

    <shape xmlns:android="http://schemas.android.com/apk/res/android"
           android:shape="rectangle">
	
<-- Change color or angle according to your wish -->
        <gradient
            android:angle="225"
            android:endColor="#1a2980"
            android:startColor="#26d0ce" />

    </shape>
```

### Step 2:
Create Multiple drawable resources xml file (recommended minimum 4 files).
Add diffrent color for each drawable resources xml file

### Step 3:

Create a new  drawable resources xml file. Let us suppose the file name be gradient_flow_list.xml
and add your drawable resources xml file we made before.
``` xml
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android">

	<-- add your drawable resources xml file -->
	< -- Give Animation Duration -->
	
    <item
        android:drawable="@drawable/gradient_backround1"
        android:duration="5000"/>

    <item
        android:drawable="@drawable/gradient_background2"
        android:duration="5000"/>

    <item
        android:drawable="@drawable/gradient_background3"
        android:duration="5000"/>

    <item
        android:drawable="@drawable/gradient_background4"
        android:duration="5000"/>
	
</animation-list>
```
### Step 4:
Go to the class which extends IntroV.
Where we have made our slides
Note-> When using Gradient background make sure to make the intro slides background Transparent

``` java 
	
setGradient(true, R.drawable.gradient_flow_list,2500,5000);

```
##### Note :
When using Gradient background make sure to make the intro slides background Transparent.
Else gradient  will not be visible.

``` java 
        card1.setBackground(android.R.color.transparent);
```


## Getting Help

To report a specific problem or feature request,, please let by opening a new Issue.(https://github.com/vasu-bhardwaj/OnBoardingEasy/issues/new)

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
