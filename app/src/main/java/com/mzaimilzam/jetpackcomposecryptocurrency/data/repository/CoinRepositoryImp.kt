package com.mzaimilzam.jetpackcomposecryptocurrency.data.repository

import com.mzaimilzam.jetpackcomposecryptocurrency.common.Resource
import com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.CoinPaprikaApi
import com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.dto.coinById.toCoinDetail
import com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.dto.toCoin
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.model.Coin
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.model.CoinDetail
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
class CoinRepositoryImp @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override fun getCoins(): Flow<Resource<List<Coin>>> {
        return flow {
            try {
                val response = api.getCoins()
                val dataArray = response.map { it.toCoin() }
                if (dataArray.isNotEmpty()) {
                    emit(Resource.Success(dataArray))
                }
            } catch (e: Exception) {
//                emit(Resource.Error(e.toString()))
            }
        }
    }

    override fun getCoinDetail(coinId: String): Flow<Resource<CoinDetail>> {
        return flow {
            try {
                val response = api.getCoinById(coinId = coinId)
                val data = response.toCoinDetail()
                emit(Resource.Success(data))
            } catch (e: Exception) {
//                emit(Resource.Error(e.toString()))
            }
        }

    }

}