package com.dropbox.pokedex.treehouse.presenter

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable


interface Slots


@Serializable
sealed class UpgradeSlots {
    data class PlanCompare(
        val button: @Composable () -> Unit
    ) : UpgradeSlots()
}

interface HybridUpgradePage {
    fun compose(slots: UpgradeSlots): () -> @Composable () -> Unit
}

