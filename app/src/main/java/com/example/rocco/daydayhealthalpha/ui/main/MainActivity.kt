package com.example.rocco.daydayhealthalpha.ui.main

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import com.example.base.BaseActivity
import com.example.rocco.daydayhealthalpha.R
import com.example.rocco.daydayhealthalpha.util.DateUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.properties.Delegates

class MainActivity : BaseActivity() {

    private val viewModel by lazy { ViewModel() }

    private val weeklyAdapter by lazy { WeeklyAdapter() }
    private val dailyAdapter by lazy { DailyAdapter(supportFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initData()
        bindView()
    }

    /**
     */

    private fun initView() {
        /* */
        viewPager_weekly.offscreenPageLimit = 2
        viewPager_weekly.adapter = weeklyAdapter

        /* */
        viewPager_daily.offscreenPageLimit = 2
        viewPager_daily.adapter = dailyAdapter

    }

    private fun initData() {
        /* 하단 리스트에 대한 날짜 */
        viewModel.calendar = Calendar.getInstance()
    }

    private fun bindView() {
        viewPager_weekly.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                viewModel.calendar = DateUtil.getCalendarFromWeekIndex(position)
            }

        })
    }

    /**
     */

    inner class ViewModel {

        var calendar: Calendar by Delegates.observable(Calendar.getInstance()) { _, _, value ->
            val weekIndex = DateUtil.getWeekIndexFrom(value)

            val oldIndex = viewPager_weekly.currentItem
            val diff = Math.abs(weekIndex - oldIndex)

            /* */
            viewPager_weekly.setCurrentItem(weekIndex, 7 > diff)

            /* */
            value.add(Calendar.DAY_OF_YEAR, 1)
            textView_month.text = DateUtil.formatDateToString(value!!.time, "yyyy.MM.")
        }

    }

}
