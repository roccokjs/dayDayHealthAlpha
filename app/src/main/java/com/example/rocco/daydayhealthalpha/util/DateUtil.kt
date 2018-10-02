package com.example.rocco.daydayhealthalpha.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    private var minCalendar: Calendar = Calendar.getInstance()

    init {
        minCalendar.set(Calendar.YEAR, 1978)
        minCalendar.set(Calendar.MONTH, 0)
        minCalendar.set(Calendar.DAY_OF_MONTH, 1)
        minCalendar.set(Calendar.HOUR_OF_DAY, 0)
        minCalendar.set(Calendar.MINUTE, 0)
        minCalendar.set(Calendar.SECOND, 0)
        minCalendar.set(Calendar.MILLISECOND, 0)
    }

    /* */

    fun getWeekIndexFrom(calendar: Calendar): Int {
        return getDiffDayCount(minCalendar, calendar) / 7
    }

    fun getDiffDayCount(fromDate: Calendar, toDate: Calendar): Int {
        val fromDateNew = fromDate.clone() as Calendar
        fromDateNew.set(Calendar.HOUR_OF_DAY, 0)
        fromDateNew.set(Calendar.MINUTE, 0)
        fromDateNew.set(Calendar.SECOND, 0)
        fromDateNew.set(Calendar.MILLISECOND, 0)

        val toDateNew = toDate.clone() as Calendar
        toDateNew.set(Calendar.HOUR_OF_DAY, 0)
        toDateNew.set(Calendar.MINUTE, 0)
        toDateNew.set(Calendar.SECOND, 0)
        toDateNew.set(Calendar.MILLISECOND, 0)

        val fromTimeMillis = fromDateNew.timeInMillis
        val toTimeMillis = toDateNew.timeInMillis

        return ((toTimeMillis - fromTimeMillis) / (24 * 60 * 60 * 1000)).toInt()
    }

    fun getCalendarFromWeekIndex(weekIndex: Int): Calendar {
        val calendar = minCalendar.clone() as Calendar
        calendar.add(Calendar.DAY_OF_YEAR, weekIndex * 7)
        return calendar
    }

    /**
     * Parse Date ( should return Date )
     */

    fun parseDate(date_yyyyMMdd: String): Date {
        try {
            val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
            return dateFormat.parse(date_yyyyMMdd)
        } catch (parseException: ParseException) {
            return Date()
        }

    }

    fun parseDate(dateTime_yyyyMMdd: Int): Date {
        return parseDate(dateTime_yyyyMMdd.toString())
    }

    /* */

    private val dateFormat_yyyyMMdd = "yyyyMMdd"

    fun formatDateToInt_yyyyMMdd(date: Date): Int {
        val dateFormat = SimpleDateFormat(dateFormat_yyyyMMdd, Locale.getDefault())
        return Integer.parseInt(dateFormat.format(date))
    }

    fun getIntDateFromIntDate(dateInt: Int, diff: Int): Int {
        return formatDateToInt_yyyyMMdd(getDateFromIntDate(dateInt, diff))
    }

    fun getDateFromIntDate(dateInt: Int, diff: Int): Date {
        return getDateFromDate(parseDate(dateInt), diff)
    }

    private val calendar_getDateFrom = Calendar.getInstance()

    fun getDateFromDate(date: Date, diff: Int): Date {
        synchronized(calendar_getDateFrom) {
            calendar_getDateFrom.time = date
            calendar_getDateFrom.add(GregorianCalendar.DAY_OF_YEAR, diff)

            return calendar_getDateFrom.time
        }
    }

    fun formatIntDateToString_format(date_yyyyMMdd: Int, format: String): String {
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(parseDate(date_yyyyMMdd))
    }

    fun formatDateToString(date: Date, format: String): String {
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(date)
    }

    val todayDate_byReal: Date
        get() = Calendar.getInstance().time

    val todayInt_byReal_yyyyMMdd: Int
        get() = formatDateToInt_yyyyMMdd(todayDate_byReal)

}