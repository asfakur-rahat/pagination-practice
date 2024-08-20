package com.ar.catpaging.data

import androidx.paging.PagingData
import com.ar.catpaging.data.db.CatDatabase
import com.ar.catpaging.data.network.CatApi
import com.ar.catpaging.domain.model.Cat
import com.ar.catpaging.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatRepositoryImpl@Inject constructor(
    private val catApi: CatApi,
    private val database: CatDatabase
) : CatRepository {
    override fun getCatsFromNetwork(): Flow<PagingData<Cat>> {
        TODO("Not yet implemented")
    }

    override fun getCatsFromDb(): Flow<PagingData<Cat>> {
        TODO("Not yet implemented")
    }

    override fun getCatsFromMediator(): Flow<PagingData<Cat>> {
        TODO("Not yet implemented")
    }

    override suspend fun fillWithDummyCats(dummyCats: List<Cat>) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDummyData() {
        TODO("Not yet implemented")
    }
}