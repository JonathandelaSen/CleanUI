package devjdelasen.com.cleanui.settingsRow

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.TextStyle
import devjdelasen.com.cleanui.set
import kotlinx.android.synthetic.main.settings_row_subtext.view.*


class SettingsRowSubtext: SettingsRow {


    private val SUBTEXT_TEXT_SIZE_DEFAULT_PD = 14f

    private var subtext: String? = ""
    private var subtextColor: Int = -1
    private var subtextSize: Float = SUBTEXT_TEXT_SIZE_DEFAULT_PD
    private var subtextTextStyle: Int = TextStyle.NORMAL.value



    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.SettingsRow, 0, 0)
        try {
            subtext = ta.getString(R.styleable.SettingsRow_settings_row_subtitle)
            subtextColor = ta.getColor(R.styleable.SettingsRow_settings_row_subtitle_color, ContextCompat.getColor(context, R.color.clean_ui_subtitle_dark))
            subtextTextStyle = ta.getInt(R.styleable.SettingsRow_settings_row_subtitle_size, TextStyle.NORMAL.value)
            subtextSize = ta.getFloat(R.styleable.SettingsRow_settings_row_subtitle_style, SUBTEXT_TEXT_SIZE_DEFAULT_PD)
        } finally {
            ta.recycle()
        }
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    override fun init() {
        setView()

        super.init()
    }


    fun setListener(listener: OnClickListener) {
        clean_ui_tvSubtext.setOnClickListener(listener)
    }

    private fun setView() {
        View.inflate(context, R.layout.settings_row_subtext, this)
        clean_ui_tvSubtext?.set(subtext, subtextColor, subtextSize, subtextTextStyle)
    }


}