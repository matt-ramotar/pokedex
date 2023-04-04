package com.dropbox.pokedex.android.wiring

import androidx.compose.runtime.Composable
import app.cash.redwood.layout.composeui.ComposeUiRedwoodLayoutWidgetFactory
import app.cash.redwood.protocol.widget.ProtocolMismatchHandler
import app.cash.redwood.treehouse.TreehouseView
import app.cash.redwood.treehouse.lazylayout.composeui.ComposeUiRedwoodTreehouseLazyLayoutWidgetFactory
import com.dropbox.pokedex.android.PokedexApp
import com.dropbox.pokedex.android.common.scoping.AppScope
import com.dropbox.pokedex.android.common.scoping.SingleIn
import com.dropbox.pokedex.android.common.treehouse.AndroidPokedexWidgetFactory
import com.dropbox.pokedex.treehouse.schema.widget.PokedexDiffConsumingNodeFactory
import com.dropbox.pokedex.treehouse.schema.widget.PokedexWidgetFactories
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json

@Module
@ContributesTo(AppScope::class)
object AppModule {

    @SingleIn(AppScope::class)
    @Provides
    fun provideWidgets(app: PokedexApp): TreehouseView.WidgetSystem = object : TreehouseView.WidgetSystem {
        override fun widgetFactory(
            json: Json,
            protocolMismatchHandler: ProtocolMismatchHandler,
        ) = PokedexDiffConsumingNodeFactory<@Composable () -> Unit>(
            provider = PokedexWidgetFactories(
                Pokedex = AndroidPokedexWidgetFactory(app.graphTreehouseApp),
                RedwoodLayout = ComposeUiRedwoodLayoutWidgetFactory(),
                RedwoodTreehouseLazyLayout = ComposeUiRedwoodTreehouseLazyLayoutWidgetFactory(
                    app.graphTreehouseApp,
                    this
                ),
            ),
            json = json,
            mismatchHandler = protocolMismatchHandler,
        )
    }
}