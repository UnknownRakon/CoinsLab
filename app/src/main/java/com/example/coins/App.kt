package com.example.coins

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.coins.navigation.BottomNav
import com.example.coins.ui.theme.CoinsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    CoinsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BottomNav()
        }
    }
}