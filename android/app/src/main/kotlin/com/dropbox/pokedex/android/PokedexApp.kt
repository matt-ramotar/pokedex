package com.dropbox.pokedex.android

import android.app.Application
import androidx.compose.runtime.Composable
import app.cash.redwood.layout.composeui.ComposeUiRedwoodLayoutWidgetFactory
import app.cash.redwood.protocol.widget.ProtocolMismatchHandler
import app.cash.redwood.treehouse.TreehouseApp
import app.cash.redwood.treehouse.TreehouseAppFactory
import app.cash.redwood.treehouse.TreehouseView
import app.cash.redwood.treehouse.lazylayout.composeui.ComposeUiRedwoodTreehouseLazyLayoutWidgetFactory
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.asZiplineHttpClient
import app.cash.zipline.loader.withDevelopmentServerPush
import com.dropbox.pokedex.android.common.scoping.AppScope
import com.dropbox.pokedex.android.common.scoping.ComponentHolder
import com.dropbox.pokedex.android.common.scoping.SingleIn
import com.dropbox.pokedex.android.common.treehouse.AndroidPokedexWidgetFactory
import com.dropbox.pokedex.android.common.treehouse.RealHostApi
import com.dropbox.pokedex.android.wiring.AppComponent
import com.dropbox.pokedex.android.wiring.DaggerAppComponent
import com.dropbox.pokedex.treehouse.launcher.PokedexAppSpec
import com.dropbox.pokedex.treehouse.schema.widget.PokedexDiffConsumingNodeFactory
import com.dropbox.pokedex.treehouse.schema.widget.PokedexWidgetFactories
import com.dropbox.pokedex.treehouse.zipline.PokedexPresenter
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class, boundType = Application::class)
class PokedexApp @Inject constructor() : Application(), ComponentHolder {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override lateinit var component: AppComponent
    lateinit var treehouseApp: TreehouseApp<PokedexPresenter>
    suspend fun build() {
        this.treehouseApp = buildTreehouseApp()
        val widgets = buildWidgets()
        this.component = DaggerAppComponent.factory().create(this.treehouseApp, applicationContext, widgets)
        println("set treehouse app + widgets + component")
    }

    private fun <T> repeatFlow(content: T, delayMillis: Long): Flow<T> {
        return flow {
            while (true) {
                emit(content)
                delay(delayMillis)
            }
        }
    }

    private suspend fun buildWidgets(): TreehouseView.WidgetSystem {
        return object : TreehouseView.WidgetSystem {
            override fun widgetFactory(
                json: Json,
                protocolMismatchHandler: ProtocolMismatchHandler,
            ) = PokedexDiffConsumingNodeFactory<@Composable () -> Unit>(
                provider = PokedexWidgetFactories(
                    Pokedex = AndroidPokedexWidgetFactory(treehouseApp),
                    RedwoodLayout = ComposeUiRedwoodLayoutWidgetFactory(),
                    RedwoodTreehouseLazyLayout = ComposeUiRedwoodTreehouseLazyLayoutWidgetFactory(
                        treehouseApp,
                        this
                    ),
                ),
                json = json,
                mismatchHandler = protocolMismatchHandler,
            )
        }
    }

    private suspend fun buildTreehouseApp(): TreehouseApp<PokedexPresenter> = try {

        val httpClient = OkHttpClient()
        val ziplineHttpClient = httpClient.asZiplineHttpClient()

        val treehouseAppFactory = TreehouseAppFactory(
            context = applicationContext,
            httpClient = httpClient,
            manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS
        )

        val manifestUrlFlow = repeatFlow("http://10.0.2.2:8080/manifest.zipline.json", 20)
            .withDevelopmentServerPush(ziplineHttpClient)


        val treehouseApp = treehouseAppFactory.create(
            appScope = coroutineScope,
            spec = PokedexAppSpec(
                manifestUrl = manifestUrlFlow,
                hostApi = RealHostApi(httpClient)
            )
        )

        treehouseApp.start()

        treehouseApp
    } catch (error: Throwable) {
        println("ERROR = $error")
        throw error
    }

}

