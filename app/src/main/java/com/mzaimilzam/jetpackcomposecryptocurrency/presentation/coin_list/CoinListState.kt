package com.mzaimilzam.jetpackcomposecryptocurrency.presentation.coin_list

import com.mzaimilzam.jetpackcomposecryptocurrency.domain.model.Coin

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
data class CoinListState(
    val isLoading : Boolean = false,
    val coins : List<Coin> = emptyList(),
    val error : String = ""
)
