package com.ar.catpaging.data.network

import com.ar.catpaging.domain.model.Cat
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("v1/images/search")
    suspend fun getCatImages(
        @Query("limit") size: Int,
        @Query("order") order: String = "Asc",
        @Query("page") page: Int
    ): List<Cat>
}