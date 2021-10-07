package com.mzaimilzam.jetpackcomposecryptocurrency.domain.usecase.get_coin

import com.mzaimilzam.jetpackcomposecryptocurrency.common.Resource
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.model.CoinDetail
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
class GetCoinsDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coindId: String): Flow<Resource<CoinDetail>> =
        repository.getCoinDetail(coinId = coindId)

}