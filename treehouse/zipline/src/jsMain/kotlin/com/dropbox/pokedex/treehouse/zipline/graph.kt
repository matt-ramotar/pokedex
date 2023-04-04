package com.dropbox.pokedex.treehouse.zipline


import app.cash.zipline.Zipline

private val zipline by lazy { Zipline.get(SerializersModules.treehouse) }

@OptIn(ExperimentalJsExport::class)
@JsExport
fun graph() {
    println("Trying to take HostApi...")

    val hostApi = zipline.take<HostApi>(
        name = "HostApi",
    )

    println("Trying to take HostController...")

    val hostController = try {
        val result = zipline.take<HostController>(
            name = "HostController",
        )
        println("HostController taken!")

        result
    } catch (error: Throwable) {
        println("Error taking HostController: $error")
        object : HostController {
            override val start: String = "pokedex"
            override val content: Map<String, (slots: Map<String, () -> Unit>) -> Unit> = mutableMapOf()

        }
    }

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