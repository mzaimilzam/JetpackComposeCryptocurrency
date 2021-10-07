package com.mzaimilzam.jetpackcomposecryptocurrency.data.remote.dto.coinById


import com.google.gson.annotations.SerializedName

data class Whitepaper(
    @SerializedName("link")
    val link: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)