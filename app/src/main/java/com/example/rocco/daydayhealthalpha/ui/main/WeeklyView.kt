package com.example.rocco.daydayhealthalpha.ui.main

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.rocco.daydayhealthalpha.R
import com.example.rocco.daydayhealthalpha.util.DateUtil
import kotlinx.android.synthetic.main.layout_weekly_item.view.*
import java.util.*
import kotlin.properties.Delegates

class WeeklyView constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    val viewModel by lazy { ViewModel() }

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_weekly_item, this, true)
        initView()
    }

    private fun initView() {
    }

    /* Public */

    fun setWeekIndex(weekIndex: Int) {
        val calendar = DateUtil.getCalendarFromWeekIndex(weekIndex)
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val startDate_yyyyMMdd = DateUtil.formatDateToInt_yyyyMMdd(calendar.time)

        this.viewModel.startDate_yyyyMMdd = startDate_yyyyMMdd
    }

    /**
     */

    inner class ViewModel {

        var startDate_yyyyMMdd by Delegates.observable(0) { _, _, value ->
            val todayIntDate = DateUtil.todayInt_byReal_yyyyMMdd

            /* */
            textViewMonDate.text = DateUtil.formatIntDateToString_format(value, "dd")

            /* */
            val tueIntDate = DateUtil.getIntDateFromIntDate(value, 1)
            textViewTueDate.text = DateUtil.formatIntDateToString_format(tueIntDate, "dd")
            if (todayIntDate == tueIntDate) {
                textViewTueDate.setBackgroundResource(R.drawable.cc_re_tr)
            }

            textViewWedDate.text = DateUtil.formatIntDateToString_format(DateUtil.getIntDateFromIntDate(value, 2), "dd")
            textViewThuDate.text = DateUtil.formatIntDateToString_format(DateUtil.getIntDateFromIntDate(value, 3), "dd")
            textViewFriDate.text = DateUtil.formatIntDateToString_format(DateUtil.getIntDateFromIntDate(value, 4), "dd")
            textViewSatDate.text = DateUtil.formatIntDateToString_format(DateUtil.getIntDateFromIntDate(value, 5), "dd")
            textViewSunDate.text = DateUtil.formatIntDateToString_format(DateUtil.getIntDateFromIntDate(value, 6), "dd")
        }

    }

}
