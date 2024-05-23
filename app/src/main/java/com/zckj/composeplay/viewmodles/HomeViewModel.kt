package com.zckj.composeplay.viewmodles

import androidx.lifecycle.ViewModel
import com.zckj.composeplay.intents.HomeEvent
import com.zckj.composeplay.intents.HomeState
import com.zckj.composeplay.models.repo.ZcApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val zcApiRepository: ZcApiRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()
//    val state: StateFlow<HomeState>
//        internal field = MutableStateFlow(HomeState())

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.SetTime -> _state.update {
                val (on, off) = zcApiRepository.setOnOff()
                it.copy(onTime = on, offTime = off)
            }
        }
    }
}