package devjdelasen.com.cleanui.utils

import android.content.res.Resources
import android.util.TypedValue




internal class Utils {

    companion object {

        fun dpsToPxs(resources: Resources, dps: Float): Float {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dps, resources.displayMetrics)
        }

    }
}