package devjdelasen.com.cleanui.icons

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.widget.ImageViewCompat
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.icons.models.SimpleIconModel
import kotlinx.android.synthetic.main.clean_ui_simple_icon.view.*

class SimpleIcon : FrameLayout {

    //TODO: Expose views

    private var iconColor: Int? = -1
    private var icon: Drawable? = null


    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CircleIcon, 0, 0)
        try {
            icon = ta.getDrawable(R.styleable.CircleIcon_circle_icon_icon)
            iconColor = ta.getColor(R.styleable.CircleIcon_circle_icon_tint_icon_color, -1)
        } finally {
            ta.recycle()
        }
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }


    fun set(icon: SimpleIconModel?) {
        this.icon = icon?.icon
        icon?.iconColor?.let {
            this.iconColor = context.getColor(it)
        }?: run {
            this.iconColor = -1
        }
        setView()
    }



    private fun init() {
        View.inflate(context, R.layout.clean_ui_simple_icon, this)
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
