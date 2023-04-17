package com.dropbox.pokedex.treehouse.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data class LazyColumn(
    val modifier: Modifier,
    val events: Events?,
    val verticalArrangement: Arrangement.Vertical?,
    val horizontalAlignment: Alignment.Horizontal?,
    val contentPadding: PaddingValues?,
    val children: MutableList<Component> = mutableListOf(),
) : Component {
    @Composable
    fun child(component: Component) {
        children.add(component)
    }
}
