package com.dropbox.pokedex.treehouse.presenter


import androidx.compose.runtime.Composable
import app.cash.redwood.protocol.compose.ProtocolBridge
import app.cash.redwood.treehouse.TreehouseUi
import app.cash.redwood.treehouse.lazylayout.compose.LazyColumn
import app.cash.redwood.treehouse.lazylayout.compose.items
import com.dropbox.pokedex.common.client.HttpClient

class PokedexTreehouseUI(
    private val httpClient: HttpClient,
    bridge: ProtocolBridge,
) : TreehouseUi {
    private val lazyColumnProvider = LazyColumnProvider(bridge)

    @Composable
    override fun Show() {
        Pokedex(httpClient, lazyColumnProvider)
    }
}

class HybridUpgradePageTreehouseUI(
    private val httpClient: HttpClient,
    bridge: ProtocolBridge,
    private val hybridUpgradePage: HybridUpgradePageClient
) : TreehouseUi {
    private val lazyColumnProvider = LazyColumnProvider(bridge)

    @Composable
    override fun Show() {
        val composable: (() -> Unit)? = try {
            HybridUpgradePageUi(httpClient, lazyColumnProvider, hybridUpgradePage)
        } catch (error: Throwable) {
            println("error = $error")
            null
        }

        println("composable = $composable")

        composable?.invoke()
    }
}


private class LazyColumnProvider(
    private val bridge: ProtocolBridge,
) : ColumnProvider {
    @Composable
    override fun <T> lazy(items: List<T>, itemContent: @Composable (item: T) -> Unit) =
        with(bridge) {
            LazyColumn {
                items(items, itemContent)
            }
        }
}


