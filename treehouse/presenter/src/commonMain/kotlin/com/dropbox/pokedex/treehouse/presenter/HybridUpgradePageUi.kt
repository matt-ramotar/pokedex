package com.dropbox.pokedex.treehouse.presenter

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.dropbox.pokedex.common.client.HttpClient
import com.dropbox.pokedex.treehouse.componentbox.Color
import com.dropbox.pokedex.treehouse.componentbox.Modifier
import com.dropbox.pokedex.treehouse.componentbox.Shape
import com.dropbox.pokedex.treehouse.componentbox.dp
import com.dropbox.pokedex.treehouse.schema.compose.ContainedButton
import com.dropbox.pokedex.treehouse.schema.compose.Text
import kotlinx.serialization.Serializable


fun HybridUpgradePageUi(
    httpClient: HttpClient,
    columnProvider: ColumnProvider,
    hybridUpgradePage: HybridUpgradePageClient
): () -> Unit = {
    println("zipline - hitting")
    println("zipline - hitting2")
    val page = try {
        hybridUpgradePage.page()
    } catch (error: Throwable) {
        println("failed to get page = $error")
        println(error.cause)
        throw error
    }
    println("page = $page")
    page.compose(UpgradeSlots.PlanCompare {
        println("hitting in compose ")
        PlanCompareButton()
    })


}

@Composable
fun PlanCompareButton() {
    ContainedButton(
        modifier = Modifier(),
        enabled = true,
        onClick = {},
        backgroundColor = Color.named("primary"),
        contentColor = Color.named("onPrimary"),
        elevation = 8.dp,
        shape = Shape.Rectangle
    ) {
        Text("Upgrade")
    }
}


fun interface HybridUpgradePageClient {
    fun page(): HybridUpgradePage
}

@Serializable
class RealHybridUpgradePage : HybridUpgradePage {
    override fun compose(slots: UpgradeSlots): () -> @Composable () -> Unit = {
        when (slots) {
            is UpgradeSlots.PlanCompare -> {
                @Composable {
                    Text(text = "Upgrade")

                    Column {
                        Text(text = "Slot 1")
                        slots.button()
                    }

                    Text(text = "Upgrade")
                }
            }
        }
    }
}