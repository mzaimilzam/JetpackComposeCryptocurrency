package com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.model.Coin

data class CoinDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String
)


fun CoinDto.toCoin(): Coin {
    return Coin(
        id, isActive, isNew, name, rank, symbol, type
    )
}