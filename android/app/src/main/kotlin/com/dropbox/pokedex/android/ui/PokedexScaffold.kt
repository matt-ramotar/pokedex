package com.dropbox.pokedex.android.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.dropbox.pokedex.android.navigation.Routing

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