package com.example.rocco.daydayhealthalpha.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.rocco.daydayhealthalpha.R
import com.example.rocco.daydayhealthalpha.db.User
import com.example.rocco.daydayhealthalpha.db.UsersDBHelper
import kotlinx.android.synthetic.main.activity_get_user_data.*

class GetUserDataActivity : AppCompatActivity() {

    companion object {
        var callback: ((user: User) -> Unit)? = null
    }

    private val usersDBHelper by lazy { UsersDBHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_user_data)

        buttonCommit.setOnClickListener { updateUser() }
    }

    private fun updateUser() {
        var userid = "10" /* todo : autoIncrease 기능 찾거나, User table 의 (id로 정렬해서) 마지막 값을 가지고 와서 +1 */
        var name = editTextName.text.toString()
        var age = editTextAge.text.toString().toInt()
        var height = editTextHeight.text.toString().toInt()
        var weight = editTextWeight.text.toString().toInt()
        var sex = editTextSex.text.toString().toInt()
        val user = User(userid = userid, name = name, age = age, height = height, weight = weight, sex = sex)

        var result = usersDBHelper.insertUser(user)

        callback?.invoke(user)
        finish()
    }

}
