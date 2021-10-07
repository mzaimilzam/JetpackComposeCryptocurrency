package com.mzaimilzam.jetpackcomposecryptocurrency.domain.model

import com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.dto.coinById.Team

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val teamMember: List<Team>,

    )
