package com.sbz.shoppinnglist.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sbz.shoppinnglist.data.room.model.Stores
import kotlinx.coroutines.flow.Flow

@Dao
interface StoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStore(stores: Stores)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateStore(stores: Stores)

    @Delete
    suspend fun deleteStore(stores: Stores)

    @Query("SELECT * FROM stores")
    fun getAllStores(): Flow<List<Stores>>

    @Query("SELECT * FROM stores WHERE storeId = :storeId")
    fun getStore(storeId: Int): Flow<Stores>

}