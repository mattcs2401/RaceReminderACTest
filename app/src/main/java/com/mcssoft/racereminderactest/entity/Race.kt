package com.mcssoft.racereminderactest.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Race(@ColumnInfo(name = "RaceName") val raceName: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id") var id: Long? = null    // value inserted by Room.

}