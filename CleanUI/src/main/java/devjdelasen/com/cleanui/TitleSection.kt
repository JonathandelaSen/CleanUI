package devjdelasen.com.cleanui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.title_section_clean_ui.view.*


class TitleSection : LinearLayout {

    private val TITLE_TEXT_SIZE_DEFAULT_PD = 19f

    private var title: String? = ""
    private var titleColor: Int = -1
    private var titleTextSize: Float = TITLE_TEXT_SIZE_DEFAULT_PD
    private var titleTextStyle: Int = TextStyle.BOLD.value



    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.TitleSection, 0, 0)
        try {
            title = ta.getString(R.styleable.TitleSection_title_section_title)
            titleColor = ta.getColor(R.styleable.TitleSection_title_section_title_color, ContextCompat.getColor(context, R.color.clean_ui_title_default))
            titleTextStyle = ta.getInt(R.styleable.TitleSection_title_section_title_style, TextStyle.BOLD.value)
            titleTextSize = ta.getFloat(R.styleable.TitleSection_title_section_title_size, TITLE_TEXT_SIZE_DEFAULT_PD)
        } finally {
            ta.recycle()
        }
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        View.inflate(context, R.layout.title_section_clean_ui, this)
        setView()
    }


    fun setTitle(title: String) {
        this.title = title
        setTitle()
    }

    fun getTitleTextView(): TextView {
        return clean_ui_tvTitle
    }


    private fun setView() {
        orientation = VERTICAL
        setTitle()
    }

    private fun setTitle() {
        clean_ui_tvTitle.set(title, titleColor, titleTextSize, titleTextStyle)
    }
}
