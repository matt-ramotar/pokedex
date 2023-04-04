package com.dropbox.pokedex.treehouse.zipline

import app.cash.redwood.treehouse.FrameClockService
import app.cash.redwood.treehouse.StandardFrameClockService
import app.cash.redwood.treehouse.ZiplineTreehouseUi
import app.cash.redwood.treehouse.asZiplineTreehouseUi
import com.dropbox.pokedex.treehouse.presenter.PokedexGraphTreehouseUI
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


class RealPokedexGraphPresenter(
    private val hostApi: HostApi,
    private val json: Json,
    private val start: String,
    private val content: Map<String, (slots: Map<String, () -> Unit>) -> Unit>
) : PokedexGraphPresenter {
    override val frameClockService: FrameClockService = StandardFrameClockService
    override fun launch(): ZiplineTreehouseUi {
        val bridge = PokedexProtocolBridge.create(json)
        val treehouseUi = PokedexGraphTreehouseUI(hostApi::httpCall, bridge, start, content)
        return treehouseUi.asZiplineTreehouseUi(
            bridge = bridge,
            widgetVersion = 0U
        )
    }
}