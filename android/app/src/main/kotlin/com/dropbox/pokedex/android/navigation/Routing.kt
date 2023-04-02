package com.dropbox.pokedex.android.navigation


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dropbox.pokedex.android.feat.account.AccountTab
import com.dropbox.pokedex.android.feat.home.HomeTab
import com.dropbox.pokedex.android.feat.search.SearchTab


@Composable
fun Routing(
    navController: NavHostController,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = navController, startDestination = Screen.Home.route, modifier = Modifier
            .padding(innerPadding)
    ) {
        composable(Screen.Home.route) {
            HomeTab()
        }

        composable(Screen.Search.route) {
            SearchTab()
        }

        composable(Screen.Account.route) {
            AccountTab()
        }
    }
}