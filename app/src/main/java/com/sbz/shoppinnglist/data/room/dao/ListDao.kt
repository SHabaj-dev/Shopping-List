package com.sbz.shoppinnglist.data.room.dao

import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sbz.shoppinnglist.data.room.model.Item
import com.sbz.shoppinnglist.data.room.model.ShoppingList
import com.sbz.shoppinnglist.data.room.model.Stores
import kotlinx.coroutines.flow.Flow

@Dao
interface ListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(shoppingList: ShoppingList)

    @Query(
        """
        SELECT * FROM items AS I INNER JOIN shopping_list AS S
        ON I.listId = S.id INNER JOIN stores AS ST
        ON I.storeIdFk = ST.storeId
    """
    )
    fun getItemsWithStoreAndList(): Flow<List<ItemsWithStoreAndList>>

    @Query(
        """
        SELECT * FROM items AS I INNER JOIN shopping_list AS S
        ON I.listId = S.id INNER JOIN stores AS ST
        ON I.storeIdFk = ST.storeId WHERE S.id = :listId
    """
    )
    fun getItemsWithStoreAndListFilterById(listId: Int): Flow<List<ItemsWithStoreAndList>>

    @Query(
        """
        SELECT * FROM items AS I INNER JOIN shopping_list AS S
        ON I.listId = S.id INNER JOIN stores AS ST
        ON I.storeIdFk = I.itemId WHERE I.itemId = :itemId
    """
    )
    fun getItemWithStoreAndList(itemId: Int): Flow<ItemsWithStoreAndList>

}

data class ItemsWithStoreAndList(
    @Embedded val item: Item,
    @Embedded val shoppingList: ShoppingList,
    @Embedded val stores: Stores
)