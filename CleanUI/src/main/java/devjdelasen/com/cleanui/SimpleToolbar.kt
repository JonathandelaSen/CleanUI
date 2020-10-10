package devjdelasen.com.cleanui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import kotlinx.android.synthetic.main.simple_toolbar.view.*
import kotlinx.android.synthetic.main.simple_toolbar.view.tvTitle
import kotlinx.android.synthetic.main.title_section.view.*


class SimpleToolbar : LinearLayout {




    private val TITLE_TEXT_SIZE_DEFAULT_PD = 19f

    private val PADDING_START_ALIGN_LEFT_DP = 44f
    private val MIN_PADDING_ALIGN_CENTER_DP = 40f
    private val PADDING_INCREASE_PER_ICON_DP = 22f


    private var title: String? = null
    private var leftIcon: Drawable? = null
    private var right1Icon: Drawable? = null
    private var right2Icon: Drawable? = null
    private var right3Icon: Drawable? = null
    private var hideDivider = false
    private var titleToLeft: Boolean = false
    private var bgColor: Int = -1
    private var dividerColor: Int = -1
    private var leftIconColor: Int = -1
    private var right1IconColor: Int = -1
    private var right2IconColor: Int = -1
    private var right3IconColor: Int = -1
    private var titleColor: Int = -1
    private var titleTextSize: Float = TITLE_TEXT_SIZE_DEFAULT_PD
    private var titleTextStyle: Int = TextStyle.BOLD.value




    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.SimpleToolbar, 0, 0)
        try {
            title = ta.getString(R.styleable.SimpleToolbar_simple_toolbar_title)
            leftIcon = ta.getDrawable(R.styleable.SimpleToolbar_simple_toolbar_left_icon)
            right1Icon = ta.getDrawable(R.styleable.SimpleToolbar_simple_toolbar_right1_icon)
            right2Icon = ta.getDrawable(R.styleable.SimpleToolbar_simple_toolbar_right2_icon)
            right3Icon = ta.getDrawable(R.styleable.SimpleToolbar_simple_toolbar_right3_icon)
            hideDivider = ta.getBoolean(R.styleable.SimpleToolbar_simple_toolbar_hide_divider, false)
            titleToLeft = ta.getBoolean(R.styleable.SimpleToolbar_simple_toolbar_title_to_left, false)
            dividerColor = ta.getColor(R.styleable.SimpleToolbar_simple_toolbar_divider_color, ContextCompat.getColor(context, R.color.divider))
            bgColor = ta.getColor(R.styleable.SimpleToolbar_simple_toolbar_bg_color, ContextCompat.getColor(context, R.color.white))
            titleColor = ta.getColor(R.styleable.SimpleToolbar_simple_toolbar_title_color, ContextCompat.getColor(context, R.color.title_default))
            leftIconColor = ta.getColor(R.styleable.SimpleToolbar_simple_toolbar_left_color, -1)
            right1IconColor = ta.getColor(R.styleable.SimpleToolbar_simple_toolbar_right1_color, -1)
            right2IconColor = ta.getColor(R.styleable.SimpleToolbar_simple_toolbar_right2_color, -1)
            right3IconColor = ta.getColor(R.styleable.SimpleToolbar_simple_toolbar_right3_color, -1)
            titleTextSize = ta.getFloat(R.styleable.SimpleToolbar_simple_toolbar_text_size, TITLE_TEXT_SIZE_DEFAULT_PD)
            titleTextStyle = ta.getInt(R.styleable.SimpleToolbar_simple_toolbar_title_style, TextStyle.BOLD.value)
        } finally {
            ta.recycle()
        }
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.simple_toolbar, this)
        setView()
        setListeners()
    }


    fun setRight1ClickListener(onClickListener: OnClickListener) {
        ivRight1Icon.setOnClickListener(onClickListener)
    }

    fun setRight2ClickListener(onClickListener: OnClickListener) {
        ivRight2Icon.setOnClickListener(onClickListener)
    }

    fun setRight3ClickListener(onClickListener: OnClickListener) {
        ivRight3Icon.setOnClickListener(onClickListener)
    }

    fun setLeftClickListener(onClickListener: OnClickListener) {
        ivLeftIcon.setOnClickListener(onClickListener)
    }




    private fun setView() {
        setBg()
        setTitle()
        setIcons()
        setDivider()
    }

    private fun setBg() {
        setBackgroundColor(bgColor)
    }

    private fun setDivider() {
        if (!hideDivider) vDivider.setBackgroundColor(dividerColor)
        vDivider.visibility = if (hideDivider) View.GONE else View.VISIBLE
    }

    private fun setIcons() {
        leftIcon?.let {
            if (leftIconColor != -1) ImageViewCompat.setImageTintList(ivLeftIcon, ColorStateList.valueOf(leftIconColor))
            ivLeftIcon.visibility = View.VISIBLE
            ivLeftIcon.setImageDrawable(it)
        } ?: run {
            ivLeftIcon.visibility = View.GONE
        }
        right1Icon?.let {
            if (right1IconColor != -1) ImageViewCompat.setImageTintList(ivRight1Icon, ColorStateList.valueOf(right1IconColor))
            ivRight1Icon.visibility = View.VISIBLE
            ivRight1Icon.setImageDrawable(it)
        } ?: run {
            ivRight1Icon.visibility = View.GONE
        }
        right2Icon?.let {
            if (right2IconColor != -1) ImageViewCompat.setImageTintList(ivRight2Icon, ColorStateList.valueOf(right2IconColor))
            ivRight2Icon.visibility = View.VISIBLE
            ivRight2Icon.setImageDrawable(it)
        } ?: run {
            ivRight2Icon.visibility = View.GONE
        }
        right3Icon?.let {
            if (right3IconColor != -1) ImageViewCompat.setImageTintList(ivRight3Icon, ColorStateList.valueOf(right3IconColor))
            ivRight3Icon.visibility = View.VISIBLE
            ivRight3Icon.setImageDrawable(it)
        } ?: run {
            ivRight3Icon.visibility = View.GONE
        }
    }

    private fun setTitle() {
        tvTitle.set(title, titleColor, titleTextSize, titleTextStyle)
        if (titleToLeft) alignTitleToLeft() else alignTitleCenter()
    }


    private fun setListeners() {
    }


    private fun alignTitleToLeft() {
        val layoutParams =
            tvTitle.layoutParams as RelativeLayout.LayoutParams
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE)
        layoutParams.removeRule(RelativeLayout.CENTER_IN_PARENT)
        val paddingLeftPx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            PADDING_START_ALIGN_LEFT_DP,
            context.resources.displayMetrics
        ).toInt()
        tvTitle.setPadding(paddingLeftPx, 0, getPaddingEndAlignStart(), 0)
        tvTitle.layoutParams = layoutParams
    }

    private fun getPaddingEndAlignStart(): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, getRightPaddingPerIconsDp(),
            context.resources.displayMetrics
        ).toInt()
    }

    private fun alignTitleCenter() {
        val layoutParams =
            tvTitle.layoutParams as RelativeLayout.LayoutParams
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_START)
        val paddingSidePx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, getRightPaddingPerIconsDp(),
            context.resources.displayMetrics
        ).toInt()
        tvTitle.setPadding(paddingSidePx, 0, paddingSidePx, 0)
        tvTitle.layoutParams = layoutParams
    }

    private fun getRightPaddingPerIconsDp(): Float {
        var paddingSideDp: Float = MIN_PADDING_ALIGN_CENTER_DP
        if (right1Icon != null) {
            paddingSideDp += PADDING_INCREASE_PER_ICON_DP
        }
        if (right2Icon != null) {
            paddingSideDp += PADDING_INCREASE_PER_ICON_DP
        }
        if (right3Icon != null) {
            paddingSideDp += PADDING_INCREASE_PER_ICON_DP
        }
        return paddingSideDp
    }



}
