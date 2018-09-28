package com.example.rocco.daydayhealthalpha.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rocco.daydayhealthalpha.R
import kotlinx.android.synthetic.main.goal_setting_fragment.*

class GoalSettingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.goal_setting_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*

        저장 onClick ->
        exerciseSwitch.isChecked 값을 프리퍼런스에 저장

        or

          exerciseSwitch.onChange
         */

        exerciseSwitch.setOnCheckedChangeListener { compoundButton, isChecked ->
            Log.wtf("TAG", "isChecked : $isChecked")

            /* 저장 */
        }
    }
}