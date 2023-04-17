package com.dropbox.pokedex.treehouse.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data class Box(
    val modifier: Modifier,
    val children: MutableList<Component> = mutableListOf(),
    val events: Events? = null
) : Component {
    @Composable
    fun child(component: Component) {
        children.add(component)
    }
}