package com.example.rocco.daydayhealthalpha.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rocco.daydayhealthalpha.R

class DailyFragment : Fragment() {

    var date: Int = 20180918

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_daily, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     */

    fun setDailyIndex(position: Int, diffToday: Int, today: Boolean) {

    }

}