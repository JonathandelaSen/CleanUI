package devjdelasen.com.cleanui.tasks.models

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import devjdelasen.com.cleanui.TextStyle


/**
 * Accent button model
 *
 * @property text
 * @property textSize
 * @property textStyle
 * @property tintColor
 * @constructor Create empty Accent button model
 */
data class AccentButtonModel(val text: String, val textSize: Float, val textStyle: TextStyle, @ColorRes val tintColor: Int)