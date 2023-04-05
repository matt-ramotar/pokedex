package com.dropbox.pokedex.treehouse.zipline

import app.cash.zipline.Zipline

private val zipline by lazy { Zipline.get(SerializersModules.treehouse) }


@OptIn(ExperimentalJsExport::class)
@JsExport
fun upgradePage() {
    val hostApi = zipline.take<HostApi>(
        name = "HostApi",
    )

    println("trying")

    try {
        val hybridUpgradePageController = zipline.take<HybridUpgradePageController>(
            name = "HybridUpgradePageController"
        )

        println("taken")

        zipline.bind<HybridUpgradePagePresenter>(
            name = "HybridUpgradePagePresenter",
            instance = RealHybridUpgradePagePresenter(
                hostApi,
                zipline.json,
                hybridUpgradePageController
            )
        )

        println("bound")
    } catch (error: Throwable) {
        println(error)
        println(error.message)
        println(error.toString())
    }

}