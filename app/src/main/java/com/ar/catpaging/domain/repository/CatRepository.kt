package com.ar.catpaging.domain.repository

import androidx.paging.PagingData
import com.ar.catpaging.domain.model.Cat
import kotlinx.coroutines.flow.Flow

interface CatRepository {
    fun getCatsFromNetwork(): Flow<PagingData<Cat>>
    fun getCatsFromDb(): Flow<PagingData<Cat>>
    fun getCatsFromMediator(): Flow<PagingData<Cat>>

    suspend fun fillWithDummyCats(dummyCats: List<Cat>)
    suspend fun deleteDummyData()
}