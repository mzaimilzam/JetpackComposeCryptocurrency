package com.mzaimilzam.jetpackcomposecryptocurrency.domain.repository

import com.mzaimilzam.jetpackcomposecryptocurrency.common.Resource
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.model.Coin
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
interface CoinRepository {

    fun getCoins(): Flow<Resource<List<Coin>>>

    fun getCoinDetail(coinId: String): Flow<Resource<CoinDetail>>
}