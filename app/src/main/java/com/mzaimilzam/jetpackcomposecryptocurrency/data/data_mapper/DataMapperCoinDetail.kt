package com.mzaimilzam.jetpackcomposecryptocurrency.data.data_mapper

import com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.dto.coinById.CoinDetailDto
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.model.CoinDetail

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperCoinDetail {
    fun mapDtotoDomain(input: List<CoinDetailDto>): List<CoinDetail> =
        input.map { data ->
            CoinDetail(
                coinId = data.id,
                name = data.name,
                description = data.description,
                symbol = data.symbol,
                rank = data.rank,
                isActive = data.isActive,
                tags = data.tags.map { it.name },
                teamMember = data.team
            )
        }

}