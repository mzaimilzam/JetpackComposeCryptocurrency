package com.mzaimilzam.jetpackcomposecryptocurrency.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mzaimilzam.jetpackcomposecryptocurrency.common.Constant
import com.mzaimilzam.jetpackcomposecryptocurrency.common.Resource
import com.mzaimilzam.jetpackcomposecryptocurrency.domain.usecase.get_coin.GetCoinsDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 06/10/2021.
 * linkedin : Muhammad Zaim Milzam
 */
@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoilDetailUsecase: GetCoinsDetailUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constant.PARAM_COIN_ID)?.let { coinId ->
            getCoins(coinId)
        }
    }

    private fun getCoins(coinId: String) {
        getCoilDetailUsecase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coins = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        CoinDetailState(error = result.message ?: "An Expected error occured.")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}