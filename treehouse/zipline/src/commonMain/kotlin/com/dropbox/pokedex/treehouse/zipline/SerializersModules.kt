package com.dropbox.pokedex.treehouse.zipline


import app.cash.redwood.treehouse.lazylayout.api.treehouseLazyLayoutSerializersModule
import kotlinx.serialization.modules.SerializersModule

object SerializersModules {
    val treehouse = SerializersModule {
        include(treehouseLazyLayoutSerializersModule)
    }
}