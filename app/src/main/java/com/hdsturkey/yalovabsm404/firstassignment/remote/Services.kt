package com.hdsturkey.yalovabsm404.firstassignment.remote

import com.hdsturkey.yalovabsm404.firstassignment.remote.response.OrderDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {
    @GET("orders")
    suspend fun getOrderList(
        @Query("results") resultCount: Int
    ): OrderDetailResponse
}