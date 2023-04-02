package com.dropbox.pokedex.android

import android.app.Application
import app.cash.redwood.treehouse.TreehouseApp
import app.cash.redwood.treehouse.TreehouseAppFactory
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.asZiplineHttpClient
import app.cash.zipline.loader.withDevelopmentServerPush
import com.dropbox.pokedex.android.common.scoping.AppScope
import com.dropbox.pokedex.android.common.scoping.ComponentHolder
import com.dropbox.pokedex.android.common.scoping.SingleIn
import com.dropbox.pokedex.android.wiring.AppComponent
import com.dropbox.pokedex.android.wiring.DaggerAppComponent
import com.dropbox.pokedex.treehouse.launcher.PokedexAppSpec
import com.dropbox.pokedex.treehouse.zipline.PokedexPresenter
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class, boundType = Application::class)
class PokedexApp : Application(), ComponentHolder {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override lateinit var component: AppComponent
    lateinit var treehouseApp: TreehouseApp<PokedexPresenter>

    override fun onCreate() {
        val application = this
        coroutineScope.launch {
            treehouseApp = treehouseApp()
            component = DaggerAppComponent.factory().create(application, application.treehouseApp, applicationContext)
            super.onCreate()
        }
    }

    private fun treehouseApp(): TreehouseApp<PokedexPresenter> {
        val httpClient = OkHttpClient()
        val ziplineHttpClient = httpClient.asZiplineHttpClient()

        val treehouseAppFactory = TreehouseAppFactory(
            context = applicationContext,
            httpClient = httpClient,
            manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS
        )

        val manifestUrlFlow = flowOf("http://10.0.2.2:8080/manifest.zipline.json")
            .withDevelopmentServerPush(ziplineHttpClient)

        val treehouseApp = treehouseAppFactory.create(
            appScope = coroutineScope,
            spec = PokedexAppSpec(
                manifestUrl = manifestUrlFlow,
                hostApi = RealHostApi(httpClient)
            )
        )

        treehouseApp.start()
        return treehouseApp
    }

}

