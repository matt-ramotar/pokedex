package com.dropbox.pokedex.treehouse.zipline

import app.cash.redwood.treehouse.StandardFrameClockService
import app.cash.redwood.treehouse.ZiplineTreehouseUi
import app.cash.redwood.treehouse.asZiplineTreehouseUi
import com.dropbox.pokedex.treehouse.presenter.HttpClient
import com.dropbox.pokedex.treehouse.presenter.PokedexTreehouseUI
import com.dropbox.pokedex.treehouse.schema.compose.PokedexProtocolBridge
import kotlinx.serialization.json.Json

class RealPokedexPresenter(
    private val hostApi: HostApi,
    private val json: Json,
) : PokedexPresenter {
    override val frameClockService = StandardFrameClockService
    override fun launch(): ZiplineTreehouseUi {
        val httpClient = RealHttpClient(hostApi)
        val bridge = PokedexProtocolBridge.create(json)
        val treehouseUi = PokedexTreehouseUI(httpClient, bridge)
        return treehouseUi.asZiplineTreehouseUi(
            bridge = bridge,
            widgetVersion = 0U
        )
    }
}


class RealHttpClient(private val hostApi: HostApi) : HttpClient {
    override suspend fun call(url: String, headers: Map<String, String>): String = hostApi.httpCall(url, headers)
}