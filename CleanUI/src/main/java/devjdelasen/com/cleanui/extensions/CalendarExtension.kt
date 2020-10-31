package devjdelasen.com.cleanui.extensions

import java.util.*


/**
 * RULES
 *
 * - INPUT MONTHS STARTS WITH 0
 * - OUTPUT MONTHS STARTS WITH 1
 *
 * - INPUT DAYS NUMBER STARTS WITH 1
 * - OUTPUT DAYS NUMBER STARTS WITH 1
 *
 * - OUTPUT WEEK DAY NUMBERS STARTS WITH 1 (MON = 1)
 *
 */


fun Calendar.getDayOfMonthNumber(): Int {
    return this[Calendar.DAY_OF_MONTH]
}