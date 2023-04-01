package com.dropbox.pokedex.treehouse.launcher

import app.cash.redwood.treehouse.TreehouseApp
import app.cash.zipline.Zipline
import com.dropbox.pokedex.treehouse.zipline.HostApi
import com.dropbox.pokedex.treehouse.zipline.PokedexPresenter
import com.dropbox.pokedex.treehouse.zipline.SerializersModules
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.modules.SerializersModule

class PokedexAppSpec(
    override val manifestUrl: Flow<String>,
    private val hostApi: HostApi,
) : TreehouseApp.Spec<PokedexPresenter>() {
    override val name = "pokedex"

    override val serializersModule: SerializersModule
        get() = SerializersModules.treehouse

    override fun bindServices(zipline: Zipline) {
        zipline.bind<HostApi>("HostApi", hostApi)
    }

    override fun create(zipline: Zipline): PokedexPresenter {
        return zipline.take<PokedexPresenter>("PokedexPresenter")
    }
}