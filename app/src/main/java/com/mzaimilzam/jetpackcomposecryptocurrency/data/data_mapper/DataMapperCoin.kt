package com.mzaimilzam.jetpackcomposecryptocurrency.data.data_mapper

import com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.dto.ListCoinDtoItem
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.model.Coin

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperCoin {

    fun mapDtotoDomain(input: List<ListCoinDtoItem?>): List<Coin> {
        val coinList = ArrayList<Coin>()
        input.map {
            val coins = Coin(
                id = it?.id!!,
                isActive = it.isActive!!,
                isNew = it.isNew!!,
                name = it.name!!,
                rank = it.rank!!,
                symbol = it.symbol!!,
                type = it.type!!,
            )
            coinList.add(coins)
        }
        return coinList
    }
}