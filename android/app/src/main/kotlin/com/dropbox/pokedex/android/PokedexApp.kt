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
import com.dropbox.pokedex.android.common.treehouse.RealHostApi
import com.dropbox.pokedex.android.wiring.AppComponent
import com.dropbox.pokedex.android.wiring.DaggerAppComponent
import com.dropbox.pokedex.treehouse.launcher.HybridUpgradePageSpec
import com.dropbox.pokedex.treehouse.presenter.HybridUpgradePage
import com.dropbox.pokedex.treehouse.presenter.RealHybridUpgradePage
import com.dropbox.pokedex.treehouse.zipline.HybridUpgradePageController
import com.dropbox.pokedex.treehouse.zipline.HybridUpgradePagePresenter
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import okhttp3.OkHttpClient

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class, boundType = Application::class)
class PokedexApp : Application(), ComponentHolder {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val hybridUpgradePage = RealHybridUpgradePage()

    override lateinit var component: AppComponent

    //    lateinit var treehouseApp: TreehouseApp<PokedexPresenter>
//    lateinit var graphTreehouseApp: TreehouseApp<PokedexGraphPresenter>
    lateinit var hybridUpgrade: TreehouseApp<HybridUpgradePagePresenter>

    override fun onCreate() {
        val application = this
        component = DaggerAppComponent.factory().create(application, applicationContext)
        hybridUpgrade = hybridUpgrade(hybridUpgradePage)

        coroutineScope.launch {
//            graphTreehouseApp = treehouseGraphApp(hostViewController)
//            treehouseApp = treehouseApp()
        }

        super.onCreate()

    }


    private fun hybridUpgrade(hybridUpgradePage: HybridUpgradePage): TreehouseApp<HybridUpgradePagePresenter> {
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
            spec = HybridUpgradePageSpec(
                manifestUrl = manifestUrlFlow,
                hostApi = RealHostApi(httpClient),
                hybridUpgradePageController = RealHybridUpgradePageController(hybridUpgradePage)
            )
        )

        treehouseApp.start()
        return treehouseApp
    }

}

@Serializable
class RealHybridUpgradePageController(private val _page: HybridUpgradePage) :
    HybridUpgradePageController {
    override fun page(): HybridUpgradePage {
        println("HITTING")
        println(_page)
        return _page
    }

}
