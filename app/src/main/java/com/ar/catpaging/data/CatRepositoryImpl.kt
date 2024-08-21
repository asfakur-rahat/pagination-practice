package com.ar.catpaging.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ar.catpaging.data.db.CatDatabase
import com.ar.catpaging.data.network.CatApi
import com.ar.catpaging.data.network.CatPagingSource
import com.ar.catpaging.data.network.CatRemoteMediator
import com.ar.catpaging.domain.model.Cat
import com.ar.catpaging.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val PAGE_SIZE = 30

class CatRepositoryImpl@Inject constructor(
    private val catApi: CatApi,
    private val database: CatDatabase
) : CatRepository {
    override fun getCatsFromNetwork(): Flow<PagingData<Cat>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                maxSize = (PAGE_SIZE * 1.5).toInt(),
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CatPagingSource(catApi) }
        ).flow
    }

    override fun getCatsFromDb(): Flow<PagingData<Cat>> {
        val pagingSourceFactory = { database.getCatDao().getAll() }

        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                maxSize = (PAGE_SIZE * 1.5).toInt(),
                enablePlaceholders = false
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getCatsFromMediator(): Flow<PagingData<Cat>> {
        val pagingSourceFactory = { database.getCatDao().getAll() }

        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                maxSize = (PAGE_SIZE * 1.5).toInt(),
                enablePlaceholders = false,
            ),
            remoteMediator = CatRemoteMediator(
                catApi,
                database
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override suspend fun fillWithDummyCats(dummyCats: List<Cat>) {
        database.getCatDao().deleteAll()
        database.getCatDao().insertAll(dummyCats)
    }

    override suspend fun deleteDummyData() {
        database.getCatDao().deleteAll()
    }
}