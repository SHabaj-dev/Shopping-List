package com.sbz.shoppinnglist.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stores")
data class Stores(

    @PrimaryKey(autoGenerate = true)
    val storeId: Int = 0,
    val listIdFk: Int
)