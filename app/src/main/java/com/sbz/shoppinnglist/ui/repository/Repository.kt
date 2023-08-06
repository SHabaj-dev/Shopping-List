package com.sbz.shoppinnglist.ui.repository

import com.sbz.shoppinnglist.data.room.dao.ItemDao
import com.sbz.shoppinnglist.data.room.dao.ListDao
import com.sbz.shoppinnglist.data.room.dao.StoreDao
import com.sbz.shoppinnglist.data.room.model.Item
import com.sbz.shoppinnglist.data.room.model.ShoppingList
import com.sbz.shoppinnglist.data.room.model.Stores

class Repository(
    private val listDao: ListDao,
    private val itemDao: ItemDao,
    private val storeDao: StoreDao
) {

    val stores = storeDao.getAllStores()

    val getItemsWithListAndStores = listDao.getItemsWithStoreAndList()

    fun getItemWithListAndStores(id: Int) = listDao.getItemsWithStoreAndListFilterById(id)

    fun getItemFilteredById(id: Int) = listDao.getItemsWithStoreAndListFilterById(id)

    suspend fun insertList(shoppingList: ShoppingList){
        listDao.insertShoppingList(shoppingList)
    }

    suspend fun insertStore(store: Stores) {
        storeDao.insertStore(store)
    }

    suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item)
    }

    suspend fun updateItem(item: Item) {
        itemDao.updateItem(item)
    }

}