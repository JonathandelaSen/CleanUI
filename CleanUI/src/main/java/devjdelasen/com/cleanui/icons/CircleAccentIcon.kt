package devjdelasen.com.cleanui.icons

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.graphics.ColorUtils
import androidx.core.widget.ImageViewCompat
import devjdelasen.com.cleanui.R
import kotlinx.android.synthetic.main.clean_ui_circle_icon.view.*

class CircleAccentIcon : FrameLayout {

    //TODO: Expose views

    private var ALPHA = 20
    private var iconAccentColor: Int? = -1
    private var icon: Drawable? = null


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CircleAccentIcon, 0, 0)
        try {
            icon = ta.getDrawable(R.styleable.CircleAccentIcon_circle_accent_icon_icon)
            iconAccentColor = ta.getColor(R.styleable.CircleAccentIcon_circle_accent_icon_accent_tint_icon_color, -1)
        } finally {
            ta.recycle()
        }
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.clean_ui_circle_icon, this)
        setView()
    }

    private fun setView() {
        setIcon()
        if (iconAccentColor != -1) ImageViewCompat.setImageTintList(clean_ui_IvIcon, ColorStateList.valueOf(iconAccentColor!!))
        if (iconAccentColor != -1) {
            clean_ui_flBgIcon.background.setTint(ColorUtils.setAlphaComponent(iconAccentColor!!, ALPHA))
        }
    }

    private fun setIcon() {
        icon?.let {
            clean_ui_IvIcon.setImageDrawable(it)
        }
    }


}
