package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Project: Inventory
 * From: com.example.inventory.data
 * Created by: Contr
 * On: 18/12/2025 at 14:19
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query ("SELECT * FROM items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query ("SELECT * FROM items ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
}