package com.dropbox.pokedex.android.navigation


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dropbox.pokedex.android.common.pig.PIG


@Composable
fun Routing(
    navController: NavHostController,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = navController, startDestination = Screen.Home.route, modifier = Modifier
            .padding(innerPadding)
            .padding(8.dp)
    ) {
        composable(Screen.Home.route) {

            Text("Home", color = PIG.Colors.standard.text)
        }

        composable(Screen.Search.route) {

            Text("Search", color = PIG.Colors.standard.text)
        }

        composable(Screen.Account.route) {

            Text("Account", color = PIG.Colors.standard.text)
        }

    }
}