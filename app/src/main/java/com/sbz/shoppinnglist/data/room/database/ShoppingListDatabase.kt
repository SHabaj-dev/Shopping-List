package com.sbz.shoppinnglist.data.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sbz.shoppinnglist.data.room.convertors.DateConverter
import com.sbz.shoppinnglist.data.room.dao.ItemDao
import com.sbz.shoppinnglist.data.room.dao.ListDao
import com.sbz.shoppinnglist.data.room.dao.StoreDao
import com.sbz.shoppinnglist.data.room.model.Item
import com.sbz.shoppinnglist.data.room.model.ShoppingList
import com.sbz.shoppinnglist.data.room.model.Stores


@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [ShoppingList::class, Item::class, Stores::class],
    version = 1,
    exportSchema = false
)
abstract class ShoppingListDatabase : RoomDatabase() {

    abstract fun listDao(): ListDao
    abstract fun itemDao(): ItemDao
    abstract fun storeDao(): StoreDao


    companion object{
        @Volatile
        var INSTANCE: ShoppingListDatabase? = null
        fun getDatabase(context: Context): ShoppingListDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    ShoppingListDatabase::class.java,
                    "shopping_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}