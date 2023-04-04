package com.dropbox.pokedex.treehouse.launcher

import app.cash.redwood.treehouse.TreehouseApp
import app.cash.zipline.Zipline
import com.dropbox.pokedex.treehouse.zipline.*
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

class PokedexGraphAppSpec(
    override val manifestUrl: Flow<String>,
    private val hostApi: HostApi,
    private val hostController: HostController
) : TreehouseApp.Spec<PokedexGraphPresenter>() {
    override val name = "pokedex"

    override val serializersModule: SerializersModule
        get() = SerializersModules.treehouse

    override fun bindServices(zipline: Zipline) {
        println(
            """
                @Zipline Binding HostApi....
            """.trimIndent()
        )
        zipline.bind<HostApi>("HostApi", hostApi)
        println(
            """
                @Zipline Bound HostApi....
            """.trimIndent()
        )

        println(
            """
                @Zipline Binding HostController!
            """.trimIndent()
        )
        zipline.bind<HostController>("HostController", hostController as HostController)
        println(
            """
                @Zipline Bound HostController!
            """.trimIndent()
        )
    }

    override fun create(zipline: Zipline): PokedexGraphPresenter {
        return zipline.take<PokedexGraphPresenter>("PokedexGraphPresenter")
    }
}