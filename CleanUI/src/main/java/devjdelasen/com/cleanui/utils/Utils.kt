package devjdelasen.com.cleanui.utils

import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue
import androidx.annotation.FloatRange
import java.net.URI
import kotlin.math.roundToInt


internal class Utils {

    companion object {

        fun dpsToPxs(resources: Resources, dps: Float): Float {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dps, resources.displayMetrics)
        }

        fun darker(color: Int, @FloatRange(from = 0.0, to = 1.0) factor: Float): Int {
            val a: Int = Color.alpha(color)
            val r = (Color.red(color) * factor).roundToInt()
            val g = (Color.green(color) * factor).roundToInt()
            val b = (Color.blue(color) * factor).roundToInt()
            return Color.argb(
                a,
                r.coerceAtMost(255),
                g.coerceAtMost(255),
                b.coerceAtMost(255)
            )
        }

        fun getLastSegmentPath(fileUrl: String): String {
            val path = URI(fileUrl).path
            return path.substring(path.lastIndexOf('/') + 1)
        }

    }
}