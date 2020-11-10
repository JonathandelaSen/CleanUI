package devjdelasen.com.cleanui.chat.utils

import android.content.Context
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.utils.UtilsDate
import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ChatDateUtils {

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

    companion object {

        private const val DATE_CHAT_MESSAGE_FORMAT = "d MMM"
        private const val TIME_CHAT_MESSAGE_FORMAT = "HH:mm"

        /** e.g. 20 April  */
        fun getDateChatMessage(date: Date, context: Context): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = date.time
            if (UtilsDate.isToday(calendar)) {
                return context.resources.getString(R.string.clean_ui_today)
            }
            return if (UtilsDate.isYesterday(calendar)) {
                context.resources.getString(R.string.clean_ui_yesterday)
            } else
                UtilsDate.format(date, DATE_CHAT_MESSAGE_FORMAT)
        }

        /** e.g. 18.16 **/
        fun getTimeChatMessage(date: Date): String {
            var time = date.time
            //if (UtilsDate.hasTimeZone(stringDate)) {
                val timezoneOffset = TimeZone.getDefault().getOffset(date.time).toLong()
                time = date.time + timezoneOffset
           // }

            return try {
                SimpleDateFormat(UtilsDate.DEFAULT_TIME_FORMAT).format(Date(time))
            } catch (e: ParseException) {
                ""
            }

        }



    }
}