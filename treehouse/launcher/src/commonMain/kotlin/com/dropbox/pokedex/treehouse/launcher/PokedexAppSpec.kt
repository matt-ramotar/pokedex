package com.dropbox.pokedex.treehouse.launcher

import app.cash.redwood.treehouse.TreehouseApp
import app.cash.zipline.Zipline
import com.dropbox.pokedex.treehouse.zipline.HostApi
import com.dropbox.pokedex.treehouse.zipline.HybridUpgradePageController
import com.dropbox.pokedex.treehouse.zipline.HybridUpgradePagePresenter
import com.dropbox.pokedex.treehouse.zipline.SerializersModules
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.modules.SerializersModule


class HybridUpgradePageSpec(
    override val manifestUrl: Flow<String>,
    private val hostApi: HostApi,
    private val hybridUpgradePageController: HybridUpgradePageController
) : TreehouseApp.Spec<HybridUpgradePagePresenter>() {
    override val name = "hybrid_upgrade_page_spec"

    override val serializersModule: SerializersModule
        get() = SerializersModules.treehouse

    override fun bindServices(zipline: Zipline) {
        zipline.bind<HostApi>("HostApi", hostApi)
        zipline.bind<HybridUpgradePageController>(
            "HybridUpgradePageController",
            hybridUpgradePageController
        )
    }

    override fun create(zipline: Zipline): HybridUpgradePagePresenter {
        return zipline.take<HybridUpgradePagePresenter>("HybridUpgradePagePresenter")
    }
}

