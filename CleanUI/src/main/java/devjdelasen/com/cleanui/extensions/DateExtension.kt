package devjdelasen.com.cleanui.extensions

import devjdelasen.com.cleanui.UtilsDate
import java.util.*

private const val HOUR_MS = 60*60*1000

fun Date.addHours(hours: Int) {
    time = System.currentTimeMillis() + hours * HOUR_MS
}