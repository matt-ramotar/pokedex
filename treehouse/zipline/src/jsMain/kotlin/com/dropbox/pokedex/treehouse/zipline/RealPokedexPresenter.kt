package com.dropbox.pokedex.treehouse.zipline

import app.cash.redwood.treehouse.StandardFrameClockService
import app.cash.redwood.treehouse.ZiplineTreehouseUi
import com.dropbox.pokedex.schema.compose.PokedexProtocolBridge
import com.dropbox.pokedex.treehouse.zipline.HostApi
import com.dropbox.pokedex.treehouse.zipline.PokedexPresenter
import kotlinx.serialization.json.Json

class RealPokedexPresenter(
    private val hostApi: HostApi,
    private val json: Json,
) : PokedexPresenter {
    override val frameClockService = StandardFrameClockService
    override fun launch(): ZiplineTreehouseUi {
        val bridge = PokedexProtocolBridge.create(json)
        val treehouseUi = Po
//        val bridge = EmojiSearchProtocolBridge.create(json)
//        val treehouseUi = EmojiSearchTreehouseUi(hostApi::httpCall, bridge)
//        return treehouseUi.asZiplineTreehouseUi(
//            bridge = bridge,
//            widgetVersion = 0U,
//        )

    }
}