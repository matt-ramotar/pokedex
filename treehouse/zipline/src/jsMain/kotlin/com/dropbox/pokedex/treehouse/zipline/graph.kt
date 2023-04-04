package com.dropbox.pokedex.treehouse.zipline


import app.cash.zipline.Zipline

private val zipline by lazy { Zipline.get(SerializersModules.treehouse) }

@OptIn(ExperimentalJsExport::class)
@JsExport
fun graph() {
    val hostApi = zipline.take<HostApi>(
        name = "HostApi",
    )

    val hostController = zipline.take<HostController>(
        name = "HostController",
    )

    zipline.bind<PokedexGraphPresenter>(
        name = "PokedexGraphPresenter",
        instance = RealPokedexGraphPresenter(
            hostApi,
            zipline.json,
            hostController.start,
            hostController.content
        )
    )
}