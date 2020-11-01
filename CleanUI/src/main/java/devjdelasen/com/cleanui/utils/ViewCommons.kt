package devjdelasen.com.cleanui.utils

import android.os.Build
import android.view.View


internal enum class DividerType(val value: Int) {
    NONE(0),
    LINE(1),
    SHADOW(2)
}

internal fun setDividerType(dividerType: Int, viewDivider: View, viewToAddShadow: View, elevationPX: Int, shadowColor: Int = -1, dividerColor: Int = -1) {
    if (dividerType == DividerType.NONE.value) {
        viewDivider.visibility = View.GONE
        viewToAddShadow.elevation = 0f
        return
    }
    if (dividerType == DividerType.SHADOW.value) {
        viewDivider.visibility = View.GONE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            viewToAddShadow.outlineAmbientShadowColor = shadowColor
            viewToAddShadow.outlineSpotShadowColor = shadowColor
        }
        viewToAddShadow.elevation = elevationPX.toFloat()
        return
    }
    viewDivider.visibility = View.VISIBLE
    viewToAddShadow.elevation = 0f
    if (dividerColor != -1) viewDivider.setBackgroundColor(dividerColor)
}