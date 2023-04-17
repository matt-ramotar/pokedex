package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable

/**
 * A collection of forests and trails.
 * Represents the navigation hierarchy for an application.
 */

@Serializable
data class Graph(
    val start: ComponentBoxId,
    val componentBoxes: MutableMap<ComponentBoxId, ComponentBox> = mutableMapOf()
)