package com.dropbox.pokedex.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.ComposeView
import com.dropbox.pokedex.android.common.pig.PokedexTheme
import com.dropbox.pokedex.android.common.pig.color.systemThemeColors
import com.dropbox.pokedex.android.ui.PokedexScaffold
import com.dropbox.pokedex.android.wiring.AppComponent
import com.dropbox.pokedex.android.wiring.AppDependencies
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.cancel

class PokedexMainActivity : ComponentActivity() {

    private val scope: CoroutineScope = CoroutineScope(Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ComposeView(this)
        view.setContent {
            PokedexTheme(colors = systemThemeColors()) {
                PokedexScaffold(appDependencies.app, appDependencies.widgets)
            }
        }

        setContentView(view)
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }

    private val appComponent: AppComponent by lazy { (application as PokedexApp).component }
    private val appDependencies: AppDependencies by lazy { appComponent as AppDependencies }
}
