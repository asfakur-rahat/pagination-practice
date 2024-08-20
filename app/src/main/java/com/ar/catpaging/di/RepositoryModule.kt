package com.ar.catpaging.di

import com.ar.catpaging.data.CatRepositoryImpl
import com.ar.catpaging.domain.repository.CatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCatRepository(catRepositoryImpl: CatRepositoryImpl): CatRepository
}