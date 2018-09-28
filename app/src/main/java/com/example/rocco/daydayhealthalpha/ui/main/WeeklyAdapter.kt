package com.example.rocco.daydayhealthalpha.ui.main

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rocco.daydayhealthalpha.R

class WeeklyAdapter : PagerAdapter() {

    var onClickImage: (() -> Unit)? = null

    override fun getCount(): Int {
        return 1000
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
        val view = LayoutInflater.from(container.context).inflate(R.layout.layout_weekly_item, container, false)
        container.addView(view)
        bind(position, view)
        return view
    }

    private fun bind(position: Int, view: View) {

    }

}