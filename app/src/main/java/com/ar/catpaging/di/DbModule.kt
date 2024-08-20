package com.ar.catpaging.di

import android.content.Context
import androidx.room.Room
import com.ar.catpaging.data.db.CatDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    @Provides
    @Singleton
    fun provideDb(
        @ApplicationContext appContext: Context
    ): CatDatabase {
        return Room.databaseBuilder(
            appContext, CatDatabase::class.java,
            "Cats.db"
        ).build()
    }
}