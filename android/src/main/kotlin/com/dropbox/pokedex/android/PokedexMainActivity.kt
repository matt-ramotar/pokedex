package com.dropbox.pokedex.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import app.cash.redwood.layout.composeui.ComposeUiRedwoodLayoutWidgetFactory
import app.cash.redwood.protocol.widget.DiffConsumingNode
import app.cash.redwood.protocol.widget.ProtocolMismatchHandler
import app.cash.redwood.treehouse.TreehouseContentSource
import app.cash.redwood.treehouse.TreehouseView
import app.cash.redwood.treehouse.lazylayout.composeui.ComposeUiRedwoodTreehouseLazyLayoutWidgetFactory
import com.dropbox.pokedex.treehouse.schema.widget.PokedexDiffConsumingNodeFactory
import com.dropbox.pokedex.treehouse.schema.widget.PokedexWidgetFactories
import com.dropbox.pokedex.treehouse.zipline.PokedexPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.cancel
import kotlinx.serialization.json.Json

class PokedexMainActivity : ComponentActivity() {

    private val scope: CoroutineScope = CoroutineScope(Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pokedexApp = PokedexApp(scope, applicationContext)
        val app = pokedexApp()
        val treehouseContentSource = TreehouseContentSource(PokedexPresenter::launch)

        val widgetSystem = object : TreehouseView.WidgetSystem {
            override fun widgetFactory(
                json: Json,
                protocolMismatchHandler: ProtocolMismatchHandler
            ): DiffConsumingNode.Factory<*> =
                PokedexDiffConsumingNodeFactory<@Composable () -> Unit>(
                    provider = PokedexWidgetFactories(
                        Pokedex = AndroidPokedexWidgetFactory(app),
                        RedwoodLayout = ComposeUiRedwoodLayoutWidgetFactory(),
                        RedwoodTreehouseLazyLayout = ComposeUiRedwoodTreehouseLazyLayoutWidgetFactory(
                            app,
                            this
                        )
                    ),
                    json = json,
                    mismatchHandler = protocolMismatchHandler
                )
        }

        val view = ComposeView(this)
        view.setContent {
            Column {
                Text("Pokedex")
                PokedexTreehouseContext(app, widgetSystem, contentSource = treehouseContentSource)
            }
        }

        setContentView(view)
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}