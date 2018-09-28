package com.example.rocco.daydayhealthalpha.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class DailyAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    var diffToday: Int = 0
    var todayDailyIndex: Int = 0

    override fun getCount(): Int {
        return 10000
    }

    override fun getItem(position: Int): Fragment {
        val dailyFragment = DailyFragment()
        dailyFragment.setDailyIndex(position, diffToday, position == todayDailyIndex)

        return dailyFragment
    }

}