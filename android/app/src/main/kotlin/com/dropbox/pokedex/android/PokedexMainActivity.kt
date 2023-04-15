package com.dropbox.pokedex.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.ComposeView
import app.cash.redwood.treehouse.TreehouseView
import com.dropbox.pokedex.android.common.pig.PokedexTheme
import com.dropbox.pokedex.android.common.pig.color.systemThemeColors
import com.dropbox.pokedex.android.ui.PokedexScaffold
import com.dropbox.pokedex.android.wiring.AppDependencies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class PokedexMainActivity : ComponentActivity() {

    private val scope: CoroutineScope = CoroutineScope(Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = this

        scope.launch {
            val view = ComposeView(activity)
            val app = getApp()
            app.build()
            val widgets = getWidgets()

            view.setContent {
                PokedexTheme(colors = systemThemeColors()) {
                    PokedexScaffold(
                        app = app,
                        widgets = widgets
                    )
                }
            }

            setContentView(view)
        }
    }

    private suspend fun getApp(): PokedexApp = application as PokedexApp
    private suspend fun getWidgets(): TreehouseView.WidgetSystem = (getApp().component as AppDependencies).widgets

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}

