package com.dropbox.pokedex.treehouse.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable


@Serializable
data class Column(
    val modifier: Modifier,
    val verticalArrangement: Arrangement.Vertical?,
    val horizontalAlignment: Alignment.Horizontal?,
    val children: MutableList<Component> = mutableListOf(),
    val events: Events? = null,
) : Component


