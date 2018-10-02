package com.example.rocco.daydayhealthalpha.ui.main

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

class WeeklyAdapter : PagerAdapter() {

    override fun getCount(): Int {
        return 10000
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    /*
     */

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val weeklyView = WeeklyView(container.context)
        container.addView(weeklyView)

        weeklyView.setWeekIndex(position)
        return weeklyView
    }

}