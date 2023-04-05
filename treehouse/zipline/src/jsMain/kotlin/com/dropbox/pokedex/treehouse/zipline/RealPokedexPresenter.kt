package com.dropbox.pokedex.treehouse.zipline

import app.cash.redwood.treehouse.FrameClockService
import app.cash.redwood.treehouse.StandardFrameClockService
import app.cash.redwood.treehouse.ZiplineTreehouseUi
import app.cash.redwood.treehouse.asZiplineTreehouseUi
import com.dropbox.pokedex.treehouse.presenter.HybridUpgradePage
import com.dropbox.pokedex.treehouse.presenter.HybridUpgradePageTreehouseUI
import com.dropbox.pokedex.treehouse.presenter.PokedexTreehouseUI
import com.dropbox.pokedex.treehouse.schema.compose.PokedexProtocolBridge
import kotlinx.serialization.json.Json

class RealPokedexPresenter(
    private val hostApi: HostApi,
    private val json: Json,
) : PokedexPresenter {
    override val frameClockService = StandardFrameClockService
    override fun launch(): ZiplineTreehouseUi {
        val bridge = PokedexProtocolBridge.create(json)
        val treehouseUi = PokedexTreehouseUI(hostApi::httpCall, bridge)
        return treehouseUi.asZiplineTreehouseUi(
            bridge = bridge,
            widgetVersion = 0U
        )
    }
}

class RealHybridUpgradePagePresenter(
    private val hostApi: HostApi,
    private val json: Json,
    private val controller: HybridUpgradePageController,
    override val frameClockService: FrameClockService = StandardFrameClockService
) : HybridUpgradePagePresenter {
    override fun launch(): ZiplineTreehouseUi {
        try {
            println("launching")
            val bridge = PokedexProtocolBridge.create(json)
            val treehouseUi =
                HybridUpgradePageTreehouseUI(hostApi::httpCall, bridge, controller::page)
            return treehouseUi.asZiplineTreehouseUi(
                bridge = bridge,
                widgetVersion = 0U
            )
        } catch (error: Throwable) {
            println(error)
            throw error
        }
    }
}