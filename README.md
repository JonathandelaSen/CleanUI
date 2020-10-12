# CleanUI

[![](https://jitpack.io/v/JonathandelaSen/CleanUI.svg)](https://jitpack.io/#JonathandelaSen/CleanUI)

Android library to create beautiful, clean and minimal UIs.
![SimpleToolbar](/Screenshots/CleanUI_settings+SimpleToolbar.jpg)


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

##### Set listeners
```Kotlin
	simpleToolbar.setLeftClickListener(View.OnClickListener { TODO("Not yet implemented") })
        simpleToolbar.setRight1ClickListener(View.OnClickListener { TODO("Not yet implemented") })
        simpleToolbar.setRight2ClickListener(View.OnClickListener { TODO("Not yet implemented") })
        simpleToolbar.setRight3ClickListener(View.OnClickListener { TODO("Not yet implemented") })
```

##### Programmatically
```Kotlin
	simpleToolbarProgrammatically.setIcons(null, null, null, null)
        simpleToolbarProgrammatically.setTitle("From the code", false)
        //simpleToolbarProgrammatically.getTitle() //Don't use it to set the text
        simpleToolbarProgrammatically.setLeftIcon(ContextCompat.getDrawable(this, R.drawable.ic_chat_gradient))
        simpleToolbarProgrammatically.setRight1Icon(ContextCompat.getDrawable(this, R.drawable.ic_options), R.color.app_colorPrimary)
```

### Settings
Combine these components to get your settings UI

| Section check box   | Section action |  Section subtext | 
| ------------- |:-------------:| :-------------:| 
| ![SimpleToolbar](/Screenshots/Settings/CleanUI_section_setings_check_box.png) | ![SimpleToolbar](/Screenshots/Settings/CleanUI_section_settings_action.png)| ![SimpleToolbar](/Screenshots/Settings/CleanUI_section_settings_subtext.png)



#### SettingsRowAction
```XML
            <devjdelasen.com.cleanui.TitleSection
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="#FFF"
                android:layout_marginTop="12dp"
                app:title_section_title="Users"
                app:title_section_title_style="normal"
                app:title_section_title_color="@color/app_colorPrimary"
                >

                <devjdelasen.com.cleanui.settingsRow.SettingsRowAction
                    android:id="@+id/settingsBlocks"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:settings_row_title="Blocks"
                    />

            </devjdelasen.com.cleanui.TitleSection>
```

#### SettingsRowCheckBox
```XML

            <devjdelasen.com.cleanui.TitleSection
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="#FFF"
                android:layout_marginTop="12dp"
                app:title_section_title="Notifications"
                app:title_section_title_style="normal"
                app:title_section_title_color="@color/app_colorPrimary"
                >


                <devjdelasen.com.cleanui.settingsRow.SettingsRowCheckBox
                    android:id="@+id/settingsDisplayNotis"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:settings_row_title="Display notifications"
                    />

                <devjdelasen.com.cleanui.settingsRow.SettingsRowCheckBox
                    android:id="@+id/settingsSound"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:settings_row_title="Sound on"
                    />

            </devjdelasen.com.cleanui.TitleSection>

```

#### SettingsRowSubtext
```XML
            <devjdelasen.com.cleanui.TitleSection
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="#FFF"
                android:layout_marginTop="12dp"
                app:title_section_title="About"
                app:title_section_title_style="normal"
                app:title_section_title_color="@color/app_colorPrimary"
                >

                <devjdelasen.com.cleanui.settingsRow.SettingsRowSubtext
                    android:id="@+id/settingsVersion"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:settings_row_title="Version"
                    app:settings_row_subtitle="v2.15.8"
                    />

                <devjdelasen.com.cleanui.settingsRow.SettingsRowAction
                    android:id="@+id/settingsTerms"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:settings_row_title="Terms and conditions"
                    />

                <devjdelasen.com.cleanui.settingsRow.SettingsRowAction
                    android:id="@+id/settingsPrivacyPolicy"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:settings_row_title="Privacy policy"
                    />

            </devjdelasen.com.cleanui.TitleSection>

```

#### Programmatically
```Kotlin
    	settingsSubtextProgrammatically.setTitle(title = "From code")
        settingsSubtextProgrammatically.setSubtext(subtext = "Subtext", subtextColor = resources.getColor(R.color.app_colorPrimary, null))
        settingsActionProgrammatically.setTitle(title = "From code", titleColor = resources.getColor(R.color.clean_ui_title_default, null))
        settingsCheckboxProgrammatically.setTitle(title = "From code", titleColor = resources.getColor(R.color.clean_ui_title_default, null), titleTextSize = 14f, titleTextStyle = TextStyle.BOLD)

```

        

### Other

#### TitleSection
