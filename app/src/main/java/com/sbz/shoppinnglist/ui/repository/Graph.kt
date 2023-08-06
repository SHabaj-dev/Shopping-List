package com.sbz.shoppinnglist.ui.repository

import android.content.Context
import com.sbz.shoppinnglist.data.room.database.ShoppingListDatabase

object Graph {
    lateinit var db: ShoppingListDatabase
        private set

    val repository by lazy {
        Repository(
            listDao = db.listDao(),
            storeDao = db.storeDao(),
            itemDao = db.itemDao()
        )
    }

    fun provide(context: Context){
        db = ShoppingListDatabase.getDatabase(context)
    }
}