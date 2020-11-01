package devjdelasen.com.cleanui.utils

import android.content.Context
import devjdelasen.com.cleanui.R
import devjdelasen.com.cleanui.extensions.capitalize
import devjdelasen.com.cleanui.extensions.getDayOfMonthNumber
import java.text.DateFormat
import java.text.DateFormatSymbols
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


internal class UtilsDate {

    companion object {

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

        const val DEFAULT_TIME_FORMAT = "HH:mm aa"


        private const val DEFAULT_TIME_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS"

        /* TIME */
        fun getHour24Format(): Int {
            val rightNow = Calendar.getInstance()
            return rightNow[Calendar.HOUR_OF_DAY]
        }

        fun getHour24Format(startTime: String?): Int {
            return try {
                val cal = Calendar.getInstance()
                cal.time =
                    getTime(
                        startTime
                    )
                cal[Calendar.HOUR_OF_DAY]
            } catch (e: ParseException) {
                e.printStackTrace()
                0
            }
        }

        fun getDifferenceTimes(startTime: String?, endTime: String?): String {
            val dateStart: Date
            val dateEnd: Date
            try {
                dateStart =
                    getTime(
                        startTime
                    )
                dateEnd =
                    getTime(
                        endTime
                    )
            } catch (e: ParseException) {
                e.printStackTrace()
                return ""
            }
            val difference = dateEnd.time - dateStart.time
            val days = (difference / (1000 * 60 * 60 * 24)).toInt()
            val hours = ((difference - 1000 * 60 * 60 * 24 * days) / (1000 * 60 * 60)).toInt()
            val min =
                (difference - 1000 * 60 * 60 * 24 * days - 1000 * 60 * 60 * hours).toInt() / (1000 * 60)
            return "$hours:$min"
        }

        fun getDifferenceInMinutesTimes(startTime: String?, endTime: String?): Int {
            val dateStart: Date
            val dateEnd: Date
            try {
                dateStart =
                    getTime(
                        startTime
                    )
                dateEnd =
                    getTime(
                        endTime
                    )
            } catch (e: ParseException) {
                e.printStackTrace()
                return 0
            }
            val difference = dateEnd.time - dateStart.time
            val days = (difference / (1000 * 60 * 60 * 24)).toInt()
            val hours = ((difference - 1000 * 60 * 60 * 24 * days) / (1000 * 60 * 60)).toInt()
            val min =
                (difference - 1000 * 60 * 60 * 24 * days - 1000 * 60 * 60 * hours).toInt() / (1000 * 60)
            return (days * 24 + hours) * 60 + min
        }

        fun getMinutes(startTime: String?): Int {
            return try {
                val cal = Calendar.getInstance()
                cal.time =
                    getTime(
                        startTime
                    )
                cal[Calendar.MINUTE]
            } catch (e: ParseException) {
                e.printStackTrace()
                0
            }
        }

        fun getTime(date: Date, outFormat: String): String {
            val simpleDateFormat = SimpleDateFormat(outFormat, Locale.getDefault())
            return simpleDateFormat.format(date)
        }


        /* TIME */
        /** e.g. 20 April  */
        fun getFormatDateDayMonthLong(
            stringDate: String?,
            context: Context
        ): String {
            return try {
                getFormatDateDayMonthLongMillis(
                    getDate(
                        stringDate
                    ).time.toString(), context
                )
            } catch (e: ParseException) {
                e.printStackTrace()
                ""
            }
        }

        /** e.g. 20 April  */
        fun getFormatDateDayMonthLong(day: Int, month: Int): String {
            return day.toString() + " " + getMonthOfYearName(
                month
            )
        }

        /** e.g. 20 April 2017  */
        fun getFormatDateDayMonthYearLong(
            stringDate: String?,
            context: Context
        ): String {
            return try {
                getFormatDateDayMonthYearLongMillis(
                    getDate(
                        stringDate
                    ).time.toString(), context
                )
            } catch (e: ParseException) {
                e.printStackTrace()
                ""
            }
        }

        val millis: String
            get() = Calendar.getInstance().timeInMillis.toString()

        @Throws(ParseException::class)
        fun getSeconds(day: String, month: String, year: String): String {
            val formatter: DateFormat = SimpleDateFormat("dd-MM-yyyy-HH:mm:ss")
            val date =
                formatter.parse("$day-$month-$year-12:$currentMinute:$currentSecond") as Date //Añadimos el 12 porque por defecto pone las 00:00 y con alguna mierda de la franja horario al hacer +1 0 menos -1 me estaba poniendo el día anterior
            return (date.time / 1000).toString()
        }

        private val currentMinute: String
            private get() {
                val now = Calendar.getInstance()
                val minute = now[Calendar.MINUTE]
                return if (minute < 10) {
                    "0$minute"
                } else minute.toString()
            }

        private val currentSecond: String
            private get() {
                val now = Calendar.getInstance()
                val second = now[Calendar.SECOND]
                return if (second < 10) {
                    "0$second"
                } else second.toString()
            }

        @Throws(ParseException::class)
        fun getMillis(day: String, month: String, year: String): String {
            val formatter: DateFormat = SimpleDateFormat("dd-MM-yyyy")
            val date = formatter.parse("$day-$month-$year") as Date
            return date.time.toString()
        }

        fun isSameDay(stringDate1: String?, stringDate2: String?): Boolean {
            return try {
                val date1 =
                    getDate(
                        stringDate1
                    )
                val calendar1 = Calendar.getInstance()
                calendar1.time = date1
                val date2 =
                    getDate(
                        stringDate2
                    )
                val calendar2 = Calendar.getInstance()
                calendar2.time = date2
                calendar1[Calendar.DAY_OF_MONTH] == calendar2[Calendar.DAY_OF_MONTH] && calendar1[Calendar.MONTH] == calendar2[Calendar.MONTH] && calendar1[Calendar.YEAR] == calendar2[Calendar.YEAR]
            } catch (e: ParseException) {
                false
            }
        }

        fun isLessDifferenceThanXsecs(
            stringDate1: String?,
            stringDate2: String?,
            seconds: Int
        ): Boolean {
            return try {
                val date1 =
                    getDate(
                        stringDate1
                    )
                val date2 =
                    getDate(
                        stringDate2
                    )
                val seconds1 = date1.time / 1000
                val seconds2 = date2.time / 1000
                Math.abs(seconds1 - seconds2) < seconds
            } catch (e: ParseException) {
                false
            }
        }

        val dayOfWeek: Int
            get() = getDayOfWeek(
                Calendar.getInstance()
            )

        /** Mon = 1  */
        private fun getDayOfWeek(year: Int, month: Int, day: Int): Int {
            val calendar = Calendar.getInstance()
            calendar[year, month] = day
            return getDayOfWeek(
                calendar
            )
        }

        private fun getDayOfWeek(calendar: Calendar): Int {
            val day = calendar[Calendar.DAY_OF_WEEK] - 1
            return if (day == 0) {
                7 //cuando entra es porque es domingo que lo considera como el día 1
            } else day
        }

        val defaultFormatDate: String
            get() {
                val simpleDateFormat = SimpleDateFormat(
                    DEFAULT_TIME_DATE_FORMAT,
                    Locale.getDefault()
                )
                return simpleDateFormat.format(Date())
            }

        fun getDayOfMonthNumber(): Int {
            return Calendar.getInstance().getDayOfMonthNumber()
        }

        fun getDayOfMonthNumber(dateSeconds: Long): Int {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = dateSeconds * 1000
            return calendar.getDayOfMonthNumber()
        }

        fun getMonthOfYearNumber(): Int {
            return getMonthOfYearNumber(
                Calendar.getInstance()
            )
        }

        fun getMonthOfYearNumber(dateSeconds: Long): Int {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = dateSeconds * 1000
            return getMonthOfYearNumber(
                calendar
            )
        }


        fun getYearNumber(dateSeconds: Long): Int {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = dateSeconds * 1000
            return getYearNumber(
                calendar
            )
        }

        fun getYearNumber(): Int {
            return getYearNumber(
                Calendar.getInstance()
            )
        }

        fun getDayNameShort(yearNumber: Int, monthNumber: Int, dayNumber: Int, context: Context): String {
            val calendar = Calendar.getInstance()
            calendar[Calendar.YEAR] = yearNumber
            calendar[Calendar.MONTH] = monthNumber
            calendar[Calendar.DAY_OF_MONTH] = dayNumber
            return getShortDayName(
                getDayOfWeek(
                    calendar
                ),
                context
            )
        }

        fun getDayNameInitialLetrer(yearNumber: Int, monthNumber: Int, dayNumber: Int, context: Context): String {
            val calendar = Calendar.getInstance()
            calendar[Calendar.YEAR] = yearNumber
            calendar[Calendar.MONTH] = monthNumber
            calendar[Calendar.DAY_OF_MONTH] = dayNumber
            return getDayName(
                getDayOfWeek(
                    calendar
                ),
                context
            ).first().toString()
        }

        fun getDayName(yearNumber: Int, monthNumber: Int, dayNumber: Int, context: Context): String {
            val calendar = Calendar.getInstance()
            calendar[Calendar.YEAR] = yearNumber
            calendar[Calendar.MONTH] = monthNumber
            calendar[Calendar.DAY_OF_MONTH] = dayNumber
            return getDayName(
                getDayOfWeek(
                    calendar
                ),
                context
            )
        }

        fun getMonthOfYearName(monthNumber: Int): String {
            val dfs = DateFormatSymbols()
            val months = dfs.months
            if (monthNumber in 0..11) {
                return months[monthNumber].capitalize()
            }
            return if (monthNumber == 12) {
                months[0].capitalize()
            } else ""
        }

        fun getFirstWeekDayNumber(monthNumber: Int, yearNumber: Int): Int {
            return getDayOfWeek(
                yearNumber,
                monthNumber,
                1
            )
        }

        fun getNDaysMonth(monthNumber: Int, yearNumber: Int): Int {
            return GregorianCalendar(yearNumber, monthNumber, 1).getActualMaximum(Calendar.DAY_OF_MONTH)
        }






        /** e.g. 20 April  */
        private fun getFormatDateDayMonthLongMillis(
            stringDate: String,
            context: Context
        ): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = java.lang.Long.valueOf(stringDate)
            if (isToday(
                    calendar
                )
            ) {
                return context.resources.getString(R.string.clean_ui_today)
            }
            return if (isYesterday(
                    calendar
                )
            ) {
                context.resources.getString(R.string.clean_ui_yesterday)
            } else calendar[Calendar.DAY_OF_MONTH].toString() + " " +
                    calendar.getDisplayName(
                        Calendar.MONTH,
                        Calendar.SHORT,
                        Locale.getDefault()
                    )
        }

        /** e.g. 20 April 2017  */
        private fun getFormatDateDayMonthYearLongMillis(
            stringDate: String,
            context: Context
        ): String {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = java.lang.Long.valueOf(stringDate)
            if (isToday(
                    calendar
                )
            ) {
                return context.resources.getString(R.string.clean_ui_today)
            }
            return if (isYesterday(
                    calendar
                )
            ) {
                context.resources.getString(R.string.clean_ui_yesterday)
            } else calendar[Calendar.DAY_OF_MONTH].toString() + " " +
                    calendar.getDisplayName(
                        Calendar.MONTH,
                        Calendar.LONG,
                        Locale.getDefault()
                    ) + " " +
                    calendar[Calendar.YEAR]
        }

        private fun isSameDay(cal1: Calendar, cal2: Calendar): Boolean {
            return cal1[Calendar.DAY_OF_MONTH] == cal2[Calendar.DAY_OF_MONTH] && cal1[Calendar.MONTH] == cal2[Calendar.MONTH] && cal1[Calendar.YEAR] == cal2[Calendar.YEAR]
        }

        @Throws(ParseException::class)
        private fun getDate(stringDate: String?): Date {
            if (stringDate == null) {
                throw ParseException("", 0)
            }
            val simpleDateFormat = SimpleDateFormat(
                DEFAULT_TIME_DATE_FORMAT,
                Locale.getDefault()
            )
            return simpleDateFormat.parse(stringDate)
        }

        private fun isToday(cal: Calendar): Boolean {
            return isSameDay(
                cal,
                Calendar.getInstance()
            )
        }

        private fun isYesterday(cal: Calendar): Boolean {
            val cal1 = Calendar.getInstance()
            return cal1[Calendar.YEAR] == cal[Calendar.YEAR] && cal1[Calendar.DAY_OF_YEAR] - 1 == cal[Calendar.DAY_OF_YEAR]
        }


        private fun getMonthOfYearNumber(calendar: Calendar): Int {
            return calendar[Calendar.MONTH] + 1
        }

        private fun getYearNumber(calendar: Calendar): Int {
            return calendar[Calendar.YEAR]
        }

        private fun getShortDayName(dayWeekPosition: Int, context: Context): String {
            when (dayWeekPosition) {
                1 -> return context.getString(R.string.clean_ui_mon_label)
                2 -> return context.getString(R.string.clean_ui_tue_label)
                3 -> return context.getString(R.string.clean_ui_wed_label)
                4 -> return context.getString(R.string.clean_ui_thu_label)
                5 -> return context.getString(R.string.clean_ui_fri_label)
                6 -> return context.getString(R.string.clean_ui_sat_label)
                7 -> return context.getString(R.string.clean_ui_sun_label)
            }
            return ""
        }

        private fun getDayName(dayWeekPosition: Int, context: Context): String {
            when (dayWeekPosition) {
                1 -> return context.getString(R.string.clean_ui_monday_label)
                2 -> return context.getString(R.string.clean_ui_tuesday_label)
                3 -> return context.getString(R.string.clean_ui_wednesday_label)
                4 -> return context.getString(R.string.clean_ui_thursday_label)
                5 -> return context.getString(R.string.clean_ui_friday_label)
                6 -> return context.getString(R.string.clean_ui_saturday_label)
                7 -> return context.getString(R.string.clean_ui_sunday_label)
            }
            return ""
        }

        @Throws(ParseException::class)
        private fun getTime(stringTime: String?): Date {
            if (stringTime == null) {
                throw ParseException("", 0)
            }
            val simpleDateFormat =
                SimpleDateFormat(DEFAULT_TIME_FORMAT, Locale.getDefault())
            return simpleDateFormat.parse(stringTime)
        }

    }
}
