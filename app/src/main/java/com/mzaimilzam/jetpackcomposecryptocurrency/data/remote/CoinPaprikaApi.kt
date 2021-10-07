package com.mzaimilzam.jetpackcomposecryptocurrency.data.remote

import com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.dto.CoinDto
import com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.dto.coinById.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

}