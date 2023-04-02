package com.dropbox.pokedex.android

import android.content.Context
import app.cash.redwood.treehouse.TreehouseApp
import app.cash.redwood.treehouse.TreehouseAppFactory
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.asZiplineHttpClient
import app.cash.zipline.loader.withDevelopmentServerPush
import com.dropbox.pokedex.treehouse.launcher.PokedexAppSpec
import com.dropbox.pokedex.treehouse.zipline.PokedexPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.flowOf
import okhttp3.OkHttpClient

class PokedexApp(
    private val coroutineScope: CoroutineScope,
    private val applicationContext: Context
) {
    operator fun invoke(): TreehouseApp<PokedexPresenter> {
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