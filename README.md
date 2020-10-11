# CleanUI

[![](https://jitpack.io/v/JonathandelaSen/CleanUI.svg)](https://jitpack.io/#JonathandelaSen/CleanUI)

Android library to create beautiful, clean and minimal UIs.



## Instalation 🛠

### Gradle

Add it in your root build.gradle at the end of repositories

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Add the dependency

	dependencies {
	        implementation 'com.github.JonathandelaSen:CleanUI:0.0.5'
	}

## Components 🧩

### Toolbar
#### SimpleToolbar
These are a few possible combinations


| Center title        | Left title, no divider & tint icon |  Changed title text styles| 
| ------------- |:-------------:| :-------------:| 
| ![SimpleToolbar](/Screenshots/SimpleToolbar/CleanUI_simple_toolbar_no_divider_and_tint_icon.png) | ![SimpleToolbar](/Screenshots/SimpleToolbar/CleanUI_simple_toolbar_no_divider_and_tint_icon.png)| ![SimpleToolbar](/Screenshots/SimpleToolbar/CleanUI_simple_toolbar_changed_title_styles.png)

| Changed divider color        | Full icons   
| ------------- |:-------------:
|![SimpleToolbar](/Screenshots/SimpleToolbar/CleanUI_simple_toolbar_chaged_divider_color.png) | ![SimpleToolbar](/Screenshots/SimpleToolbar/CleanUI_simple_toolbar_full_icons.png)



##### Center title
```XML
<devjdelasen.com.cleanui.SimpleToolbar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:simple_toolbar_title="No tint icon"
        app:simple_toolbar_title_to_left="false"
        app:simple_toolbar_left_icon="@drawable/ic_back_arrow"
        app:simple_toolbar_left_color="@color/clean_ui_title_default"
        app:simple_toolbar_right1_icon="@drawable/ic_chat_gradient"
        app:simple_toolbar_hide_divider="false"
        android:layout_marginBottom="20dp"
        />
```



##### Left title, no divider & tint icon
```XML
<devjdelasen.com.cleanui.SimpleToolbar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:simple_toolbar_hide_divider="true"
        app:simple_toolbar_title="No divider and tint icon"
        app:simple_toolbar_title_to_left="true"
        app:simple_toolbar_left_icon="@drawable/ic_back_arrow"
        app:simple_toolbar_left_color="@color/clean_ui_title_default"
        app:simple_toolbar_right1_icon="@drawable/ic_geo"
        app:simple_toolbar_right1_color="@color/clean_ui_colorPrimary"
        android:layout_marginBottom="20dp"
        />
```
  
  
  
##### Changed title text styles
```XML
<devjdelasen.com.cleanui.SimpleToolbar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:simple_toolbar_title="Changed size, text style and color"
        app:simple_toolbar_title_color="@color/clean_ui_colorPrimary"
        app:simple_toolbar_right1_icon="@drawable/ic_options"
        app:simple_toolbar_title_style="italic"
        app:simple_toolbar_text_size="16"
        android:layout_marginBottom="20dp"
        />
```
  
  
  
##### Changed divider color

```XML
<devjdelasen.com.cleanui.SimpleToolbar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:simple_toolbar_title="Changed divider color"
        app:simple_toolbar_title_color="@color/clean_ui_subtitle_dark"
        app:simple_toolbar_left_icon="@drawable/ic_chat_gradient"
        app:simple_toolbar_divider_color="@color/clean_ui_icon_light"
        android:layout_marginBottom="20dp"
        />
```
  
  
  
##### Full icons

```XML
<devjdelasen.com.cleanui.SimpleToolbar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:simple_toolbar_title="All icons"
        app:simple_toolbar_divider_color="@color/clean_ui_icon_light"
        app:simple_toolbar_left_icon="@drawable/ic_back_arrow"
        app:simple_toolbar_right1_icon="@drawable/ic_chat_gradient"
        app:simple_toolbar_right2_icon="@drawable/ic_geo"
        app:simple_toolbar_right3_icon="@drawable/ic_done"
        app:simple_toolbar_left_color="@color/clean_ui_subtitle_dark"
        app:simple_toolbar_right1_color="@color/clean_ui_subtitle_dark"
        app:simple_toolbar_right2_color="@color/clean_ui_subtitle_dark"
        app:simple_toolbar_right3_color="@color/clean_ui_subtitle_dark"
        app:simple_toolbar_title_color="@color/clean_ui_subtitle_dark"
        app:simple_toolbar_title_to_left="true"
        android:layout_marginBottom="20dp"
        />
```



### Settings

#### SettingsRowAction
#### SettingsRowCheckBox
#### SettingsRowSubtext


### Other

#### TitleSection
