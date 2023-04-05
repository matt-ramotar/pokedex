package com.dropbox.pokedex.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.ComposeView
import app.cash.redwood.treehouse.TreehouseContentSource
import com.dropbox.pokedex.android.common.treehouse.PokedexTreehouseContent
import com.dropbox.pokedex.android.wiring.AppComponent
import com.dropbox.pokedex.android.wiring.AppDependencies
import com.dropbox.pokedex.treehouse.zipline.HybridUpgradePagePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.cancel

class PokedexMainActivity : ComponentActivity() {

    private val scope: CoroutineScope = CoroutineScope(Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val treehouseContentSource = TreehouseContentSource(HybridUpgradePagePresenter::launch)


        val view = ComposeView(this)
        view.setContent {
//            PokedexTheme(colors = systemThemeColors()) {
//                PokedexScaffold(appDependencies.app, appDependencies.widgets)
//            }

            PokedexTreehouseContent<HybridUpgradePagePresenter>(
                appDependencies.app.hybridUpgrade,
                appDependencies.widgets,
                contentSource = treehouseContentSource
            )
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
