package devjdelasen.com.cleanui.extensions

import java.util.*

private const val HOUR_MS = 60*60*1000

fun Date.addHours(hours: Int) {
    time = System.currentTimeMillis() + hours * HOUR_MS
}

fun Date.getDayOfMonthNumber(): Int {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return calendar.getDayOfMonthNumber()
}