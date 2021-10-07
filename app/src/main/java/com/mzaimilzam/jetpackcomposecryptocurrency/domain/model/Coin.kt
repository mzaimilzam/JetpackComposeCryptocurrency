package com.mzaimilzam.jetpackcomposecryptocurrency.domain.model

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
data class Coin(
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)