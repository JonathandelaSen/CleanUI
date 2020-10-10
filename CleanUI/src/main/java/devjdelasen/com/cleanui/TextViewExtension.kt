package devjdelasen.com.cleanui

import android.graphics.Typeface
import android.util.TypedValue
import android.widget.TextView
import kotlinx.android.synthetic.main.simple_toolbar.view.*


internal fun TextView.set(text: String?, titleColor: Int, textSize: Float, textStyle: Int) {
    setTextColor(titleColor)
    setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize)
    setStyle(textStyle)
    this.text = text
}


internal fun TextView.setStyle(textStyle: Int) {
    when(textStyle) {
        TextStyle.BOLD.value -> {
            setTypeface(typeface, Typeface.BOLD)
            return
        }
        TextStyle.ITALIC.value -> {
            setTypeface(typeface, Typeface.ITALIC)
            return
        }
        TextStyle.NORMAL.value -> {
            setTypeface(typeface, Typeface.NORMAL)
            return
        }
    }
}