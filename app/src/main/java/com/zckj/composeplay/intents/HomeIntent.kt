package com.zckj.composeplay.intents

sealed interface HomeEvent {
    data object SetTime : HomeEvent
}

data class HomeState(
    val onTime: String = "",
    val offTime: String = ""
)