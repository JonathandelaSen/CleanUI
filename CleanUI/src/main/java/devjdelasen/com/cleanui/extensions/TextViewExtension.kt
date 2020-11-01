package devjdelasen.com.cleanui.extensions

import android.graphics.Typeface
import android.util.TypedValue
import android.widget.TextView
import devjdelasen.com.cleanui.utils.TextStyle


internal fun TextView.set(text: String?, titleColor: Int, textSize: Float, textStyle: Int) {
    if (titleColor != -1) setTextColor(titleColor)
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