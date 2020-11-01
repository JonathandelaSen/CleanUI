# CleanUI

[![](https://jitpack.io/v/JonathandelaSen/CleanUI.svg)](https://jitpack.io/#JonathandelaSen/CleanUI)

Android library to create beautiful, clean and minimal UIs.  

![ActionDialog](/Screenshots/Dialog/clean_ui_action_dialog.gif)
![Tasks with calendar](/Screenshots/Tasks/SimpleTask/clean_ui_tasks_simple_task.gif)


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
	        implementation 'com.github.JonathandelaSen:CleanUI:1.0.1'
	}



## Features ✅

- [x] Toolbars
- [x] Settings views
- [x] Title sections
- [x] Action dialog
- [x] Calendars
- [x] Tasks to combine or not with calendars



## Next 🚀
- [ ] Chat

I will be glad to hear your suggestions 🙏

## ☝️ Tasks

Recycler view with two different type of tasks 

![Simple tasks with calendar](/Screenshots/Tasks/SimpleTask/clean_ui_tasks_simple_task.gif)

![Minimal tasks with calendar](/Screenshots/Tasks/MinimalTask/clean_ui_tasks_minimal_task.gif)


![Simple tasks with calendar](/Screenshots/Tasks/SimpleTask/clean_ui_tasks_simple_task.png)

![Minimal tasks with calendar](/Screenshots/Tasks/MinimalTask/clean_ui_tasks_minimal_task.png)
```Kotlin
	MinimalTask(
                title = "Everyone loves the pepperiness of onion curry rinsed with clammy thyme.",
                date = dateStart1,
                startTime = dateStart1,
                endTime = dateEnd1,
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.streamline_interface_setting_menu_horizontal,
                        null
                    ), null
                )
            )
```

```Kotlin
	SimpleTask(
                title = "It is the only guarantee of life.",
                description = "Cum deus assimilant, omnes brabeutaes attrahendam talis, flavum adiuratores.",
                date = dateStart4,
                category = CategoryTaskModel(
                    "1",
                    CircleIconModel(
                        ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.streamline_interface_religion_cross_1,
                            null
                        ), null, null
                    )
                ),
                topRightIcon = SimpleIconModel(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_options,
                        null
                    ), null
                ),
                accentButton = AccentButtonModel(
                    text = "#Daily",
                    textSize = 12f,
                    textStyle = TextStyle.NORMAL,
                    tintColor = R.color.app_colorAccent
                )
            )
```

```Kotlin
private fun setList(list: List<TaskAbstract>) {
        if (rvAdapter == null) {
            rvAdapter = RvAdapterTasks(list, object : RvAdapterTasks.TaskInteractionListener {
                override fun onItemClickListener() {
                    Toast.makeText(this@CalendarActivity,"On item click", Toast.LENGTH_SHORT).show()
                }

                override fun onTopRightIconListener() {
                    Toast.makeText(this@CalendarActivity,"On top right icon click", Toast.LENGTH_SHORT).show()
                }

                override fun onCategoryListener() {
                    Toast.makeText(this@CalendarActivity,"On category click", Toast.LENGTH_SHORT).show()
                }

                override fun onActionButtonListener() {
                    Toast.makeText(this@CalendarActivity,"On action button click", Toast.LENGTH_SHORT).show()
                }

            })
            val llManager = LinearLayoutManager(this)
            rv.layoutManager = llManager
            rv.adapter = rvAdapter
            return
        }
        rvAdapter?.updateTasks(list)
    }
```

## ☝️ Calendars
![TopHorizontalCalendarWithHeader](/Screenshots/Calendar/clean_ui_calendar.gif)

```Kotlin
<devjdelasen.com.cleanui.calendar.top.TopHorizontalCalendarWithHeader
        android:id="@+id/topHorizontalCalendar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="12dp"
        android:background="@color/clean_ui_white"
        app:top_calendar_accent_color="@color/app_red"
        app:top_calendar_divider_color="@color/app_colorSeconday"
        app:top_calendar_hide_divider="false"
        app:top_calendar_hide_toolbar="false"
        app:top_calendar_main_text_color="@color/clean_ui_title_default"
        app:top_calendar_subtext_color="@color/clean_ui_icon_light"
        app:top_calendar_title_color="@color/app_colorSeconday"
        app:top_calendar_type="both"
        />
```

### Combine calendar with tasks
```Kotlin
topHorizontalCalendar?.init(object :
            TopHorizontalCalendarWithHeader.TopHorizontalCalendarInteractionListener {
            override fun onDaySelected(daySelected: Int, monthSelected: Int, yearSelected: Int, tasks: List<TaskAbstract>) {
                Toast.makeText(
                    this@CalendarActivity,
                    "$daySelected - ${monthSelected + 1} - $yearSelected",
                    Toast.LENGTH_SHORT
                ).show()
                setList(tasks)
            }

            override fun getTasks(
                monthSelected: Int,
                yearSelected: Int
            ): List<TaskAbstract> {
                return getRandomTasks(monthSelected)
            }
        })
```


## ☝️ ActionDialog
![SimpleToolbar](/Screenshots/Dialog/clean_ui_action_dialog.gif)
![SimpleToolbar](/Screenshots/Dialog/clean_ui_action_dialog.jpg)

```Kotlin
val dialog = ActionDialog(title = "Sed ut perspiciatis",
                subtitle = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                buttonText = "Button",
                buttonColor = R.color.app_colorAccent,
                buttonSecondaryColor = R.color.app_colorSeconday,
                gradientOrientation = GradientDrawable.Orientation.TL_BR,
                cancelable = true,
                context = this)
            dialog.setListeners(onButtonClickListener = View.OnClickListener {
                dialog.dismiss()
            })
            dialog.showDialog()
```


## ☝️ Toolbar
### SimpleToolbar
These are a few possible combinations


| Center title        | Left title, no divider & tint icon |  Changed title text styles| 
| ------------- |:-------------:| :-------------:| 
| ![SimpleToolbar](/Screenshots/SimpleToolbar/CleanUI_simple_toolbar_no_divider_and_tint_icon.png) | ![SimpleToolbar](/Screenshots/SimpleToolbar/CleanUI_simple_toolbar_no_divider_and_tint_icon.png)| ![SimpleToolbar](/Screenshots/SimpleToolbar/CleanUI_simple_toolbar_changed_title_styles.png)

| Changed divider color        | Full icons   
| ------------- |:-------------:
|![SimpleToolbar](/Screenshots/SimpleToolbar/CleanUI_simple_toolbar_chaged_divider_color.png) | ![SimpleToolbar](/Screenshots/SimpleToolbar/CleanUI_simple_toolbar_full_icons.png)



#### Center title
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



#### Left title, no divider & tint icon
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
  
  
  
#### Changed title text styles
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
  
  
  
#### Changed divider color

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
  
  
  
#### Full icons

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

#### Set listeners
```Kotlin
	simpleToolbar.setLeftClickListener(View.OnClickListener { TODO("Not yet implemented") })
        simpleToolbar.setRight1ClickListener(View.OnClickListener { TODO("Not yet implemented") })
        simpleToolbar.setRight2ClickListener(View.OnClickListener { TODO("Not yet implemented") })
        simpleToolbar.setRight3ClickListener(View.OnClickListener { TODO("Not yet implemented") })
```

#### Programmatically
```Kotlin
	simpleToolbarProgrammatically.setIcons(null, null, null, null)
        simpleToolbarProgrammatically.setTitle("From the code", false)
        //simpleToolbarProgrammatically.getTitle() //Don't use it to set the text
        simpleToolbarProgrammatically.setLeftIcon(ContextCompat.getDrawable(this, R.drawable.ic_chat_gradient))
        simpleToolbarProgrammatically.setRight1Icon(ContextCompat.getDrawable(this, R.drawable.ic_options), R.color.app_colorPrimary)
```


## ☝️ Settings
Combine these components to get your settings UI

| Section check box   | Section action |  Section subtext | 
| ------------- |:-------------:| :-------------:| 
| ![SimpleToolbar](/Screenshots/Settings/CleanUI_section_setings_check_box.png) | ![SimpleToolbar](/Screenshots/Settings/CleanUI_section_settings_action.png)| ![SimpleToolbar](/Screenshots/Settings/CleanUI_section_settings_subtext.png)



### SettingsRowAction
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

### SettingsRowCheckBox
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

### SettingsRowSubtext
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

### Programmatically
```Kotlin
    	settingsSubtextProgrammatically.setTitle(title = "From code")
        settingsSubtextProgrammatically.setSubtext(subtext = "Subtext", subtextColor = resources.getColor(R.color.app_colorPrimary, null))
        settingsActionProgrammatically.setTitle(title = "From code", titleColor = resources.getColor(R.color.clean_ui_title_default, null))
        settingsCheckboxProgrammatically.setTitle(title = "From code", titleColor = resources.getColor(R.color.clean_ui_title_default, null), titleTextSize = 14f, titleTextStyle = TextStyle.BOLD)

```

        

## ☝️ Other

### TitleSection
```XML
            <devjdelasen.com.cleanui.TitleSection
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="#FFF"
                android:layout_marginTop="12dp"
                android:layout_marginBottom="12dp"
                app:title_section_title="Title section"
                app:title_section_title_style="bold"
                app:title_section_title_color="@color/app_colorPrimary"
                >

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="Just a long text inside a TitleSection view. You can add here any view you like."
                    android:layout_marginStart="16dp"
                    android:layout_marginEnd="16dp"
                    android:layout_marginBottom="12dp"
                    />

            </devjdelasen.com.cleanui.TitleSection>
```



## Author
👨🏻‍💻  [Jonnie](https://www.instagram.com/devjdelasen/)

