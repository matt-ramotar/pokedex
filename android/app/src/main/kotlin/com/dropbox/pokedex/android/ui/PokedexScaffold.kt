package com.dropbox.pokedex.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dropbox.pokedex.android.navigation.Routing
import com.dropbox.pokedex.android.theme.color.PigColors

@Composable
fun PokedexScaffold() {

    val navController = rememberNavController()
    Scaffold(
        bottomBar = { PokedexBottomBar(navController = navController) }
    ) { innerPadding ->
        Routing(
            navController = navController,
            innerPadding = innerPadding
        )
    }
}