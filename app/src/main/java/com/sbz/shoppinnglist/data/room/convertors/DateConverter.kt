package com.sbz.shoppinnglist.data.room.convertors

import androidx.room.TypeConverter
import java.util.Date

open class DateConverter {

    @TypeConverter
    fun longToDate(date: Long?): Date?{
        return date?.let {
            Date(it)
        }
    }

    fun dateToLong(date: Date?): Long?{
        return date?.time
    }

}