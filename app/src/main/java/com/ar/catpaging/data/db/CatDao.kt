package com.ar.catpaging.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ar.catpaging.domain.model.Cat

@Dao
interface CatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cats: List<Cat>)

    @Query("SELECT * FROM cats")
    fun getAll(): PagingSource<Int, Cat>

    @Query("DELETE FROM cats")
    suspend fun deleteAll()
}