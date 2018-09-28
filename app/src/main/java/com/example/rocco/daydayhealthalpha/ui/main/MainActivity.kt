package com.example.rocco.daydayhealthalpha.ui.main

import android.os.Bundle
import com.example.base.BaseActivity
import com.example.rocco.daydayhealthalpha.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val weeklyAdapter by lazy { WeeklyAdapter() }
    private val dailyAdapter by lazy { DailyAdapter(supportFragmentManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
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

}
