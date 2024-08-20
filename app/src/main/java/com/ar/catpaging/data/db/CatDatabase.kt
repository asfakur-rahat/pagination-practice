package com.ar.catpaging.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ar.catpaging.domain.model.Cat

@Database(version = 1, entities = [Cat::class, RemoteKey::class])
abstract class CatDatabase : RoomDatabase() {
    abstract fun getCatDao(): CatDao
    abstract fun getKeysDao(): RemoteKeyDao
}