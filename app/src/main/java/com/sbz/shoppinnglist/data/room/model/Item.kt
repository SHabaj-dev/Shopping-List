package com.sbz.shoppinnglist.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(

    @PrimaryKey(autoGenerate = true)
    val itemId: Int = 0,
    val itemName: String,
    val itemQnt: String,
    val listId: Int,
    val storeIdFk: Int,
    val date: Long,
    val isChecked: Boolean
)