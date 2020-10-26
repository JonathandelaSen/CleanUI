package devjdelasen.com.cleanui.buttons

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.widget.ImageViewCompat
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.TextStyle
import devjdelasen.com.cleanui.extensions.set
import kotlinx.android.synthetic.main.clean_ui_circle_icon.view.*
import kotlinx.android.synthetic.main.clean_ui_accent_button.view.*
import kotlinx.android.synthetic.main.clean_ui_simple_toolbar_clean_ui.view.*

class AccentButton : FrameLayout {


    private var ALPHA = 20
    private val TEXT_SIZE_DEFAULT_PD = 12f

    private var accentColor: Int = -1
    private var text: String = ""
    private var textSize: Float = TEXT_SIZE_DEFAULT_PD
    private var textStyle: Int = TextStyle.BOLD.value


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.AccentButton, 0, 0)
        try {
            text = ta.getString(R.styleable.AccentButton_circle_accent_button_text) ?: ""
            accentColor = ta.getColor(R.styleable.AccentButton_circle_accent_button_tint_color, ContextCompat.getColor(context, R.color.clean_ui_colorPrimary))
            textSize = ta.getFloat(R.styleable.AccentButton_circle_accent_button_text_size, TEXT_SIZE_DEFAULT_PD)
            textStyle = ta.getInt(R.styleable.AccentButton_circle_accent_button_text_style, TextStyle.NORMAL.value)
        } finally {
            ta.recycle()
        }
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.clean_ui_accent_button, this)
        setView()
    }

    private fun setView() {
        clean_ui_accent_button_tv.set(text, accentColor, textSize, textStyle)
        clean_ui_accent_button_flRoot.background.setTint(ColorUtils.setAlphaComponent(accentColor, ALPHA))
    }


}
