package com.zckj.composeplay.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.zckj.composeplay.intents.HomeEvent
import com.zckj.composeplay.ui.theme.ComposePlayTheme
import com.zckj.composeplay.viewmodles.HomeViewModel

@Composable
fun Home(
    modifier: Modifier = Modifier,
    vm: HomeViewModel = hiltViewModel()
) {
    val state by vm.state.collectAsState()

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { vm.onEvent(HomeEvent.SetTime) }) {
            Text(text = "设置定时开关机")
        }
        Row {
            Text(text = "On: ")
            Text(text = state.onTime)
        }
        Row {
            Text(text = "Off: ")
            Text(text = state.offTime)
        }
        Column(Modifier.fillMaxSize()) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    ComposePlayTheme {
        Home(Modifier.fillMaxSize())
    }
}