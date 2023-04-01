package com.dropbox.pokedex.treehouse.zipline


import app.cash.zipline.Zipline

private val zipline by lazy { Zipline.get(SerializersModules.treehouse) }

@OptIn(ExperimentalJsExport::class)
@JsExport
fun preparePresenters() {
    val hostApi = zipline.take<HostApi>(
        name = "HostApi",
    )

    zipline.bind<PokedexPresenter>(
        name = "PokedexPresenter",
        instance = RealPokedexPresenter(hostApi, zipline.json)
    )
}