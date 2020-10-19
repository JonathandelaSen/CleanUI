package devjdelasen.com.cleanui.settingsRow

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.TextStyle
import devjdelasen.com.cleanui.extensions.set
import kotlinx.android.synthetic.main.title_section_clean_ui.view.*


abstract class SettingsRow: LinearLayout {





    private val TITLE_TEXT_SIZE_DEFAULT_PD = 14f

    private var title: String? = ""
    private var titleColor: Int = -1
    private var titleTextSize: Float = TITLE_TEXT_SIZE_DEFAULT_PD
    private var titleTextStyle: Int = TextStyle.NORMAL.value



    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.SettingsRow, 0, 0)
        try {
            title = ta.getString(R.styleable.SettingsRow_settings_row_title)
            titleColor = ta.getColor(R.styleable.SettingsRow_settings_row_title_color, ContextCompat.getColor(context, R.color.clean_ui_title_default))
            titleTextStyle = ta.getInt(R.styleable.SettingsRow_settings_row_title_size, TextStyle.NORMAL.value)
            titleTextSize = ta.getFloat(R.styleable.SettingsRow_settings_row_title_style, TITLE_TEXT_SIZE_DEFAULT_PD)
        } finally {
            ta.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)


    fun setTitle(title: String, titleColor: Int? = ContextCompat.getColor(context, R.color.clean_ui_title_default),
                 titleTextSize: Float? = TITLE_TEXT_SIZE_DEFAULT_PD, titleTextStyle: TextStyle? = TextStyle.NORMAL) {
        this.title = title
        this.titleColor = titleColor!!
        this.titleTextSize = titleTextSize!!
        this.titleTextStyle = titleTextStyle!!.value

        init()
    }

    fun getTitleTextView(): TextView {
        return clean_ui_tvTitle
    }

    //It must to be called after the view has been set in the children
    open fun init() {
        clean_ui_tvTitle?.set(title, titleColor, titleTextSize, titleTextStyle)
    }





}