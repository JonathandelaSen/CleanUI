package devjdelasen.com.cleanui.icons

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.widget.ImageViewCompat
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.icons.models.CircleIconModel
import kotlinx.android.synthetic.main.clean_ui_circle_icon.view.*

class CircleIcon : FrameLayout {

    //TODO: Expose views
    //TODO: Add circle margin as parameter

    private var iconColor: Int? = -1
    private var icon: Drawable? = null
    private var bgColor: Int? = -1


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CircleIcon, 0, 0)
        try {
            icon = ta.getDrawable(R.styleable.CircleIcon_circle_icon_icon)
            iconColor = ta.getColor(R.styleable.CircleIcon_circle_icon_tint_icon_color, -1)
            bgColor = ta.getColor(R.styleable.CircleIcon_circle_icon_tint_bg_color, context.getColor(R.color.clean_ui_icon_bg))
        } finally {
            ta.recycle()
        }
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }


    fun set(icon: CircleIconModel?) {
        this.icon = icon?.icon
        icon?.iconColor?.let {
            this.iconColor = context.getColor(it)
        }?: run {
            this.iconColor = -1
        }
        icon?.bgColor?.let {
            this.bgColor = context.getColor(it)
        }
        setView()
    }



    private fun init() {
        View.inflate(context, R.layout.clean_ui_circle_icon, this)
        setView()
    }

    private fun setView() {
        setIcon()
        if (iconColor != -1) {
            ImageViewCompat.setImageTintList(clean_ui_IvIcon, ColorStateList.valueOf(iconColor!!))
        }
        else {
            ImageViewCompat.setImageTintList(clean_ui_IvIcon, null)
        }
        clean_ui_flBgIcon.background.setTint(bgColor!!)
    }

    private fun setIcon() {
        icon?.let {
            clean_ui_IvIcon.setImageDrawable(it)
            clean_ui_IvIcon.visibility = View.VISIBLE
        } ?: run {
            clean_ui_IvIcon.visibility = View.GONE
        }
    }


}
