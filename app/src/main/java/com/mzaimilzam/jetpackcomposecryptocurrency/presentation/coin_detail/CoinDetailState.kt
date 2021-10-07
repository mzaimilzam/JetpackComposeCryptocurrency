package com.mzaimilzam.jetpackcomposecryptocurrency.presentation.coin_detail

import com.mzaimilzam.jetpackcomposecryptocurrency.domain.model.CoinDetail

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
data class CoinDetailState(
    val isLoading : Boolean = false,
    val coins : CoinDetail? = null,
    val error : String = ""
)
