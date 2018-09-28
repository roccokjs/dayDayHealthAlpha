package com.example.rocco.daydayhealthalpha.db

import android.provider.BaseColumns

object DBContract {

    /* Inner class that defines the table contents */
    class UserEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "users"
            val COLUMN_USER_ID = "userid"
            val COLUMN_NAME = "name"
            val COLUMN_AGE = "age"
            val COLUMN_HEIGHT = "height"
            val COLUMN_WEIGHT = "weight"
            val COLUMN_SEX = "sex"
        }
    }
}