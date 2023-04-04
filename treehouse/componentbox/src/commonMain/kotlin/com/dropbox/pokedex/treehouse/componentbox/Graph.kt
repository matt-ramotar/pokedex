package com.dropbox.pokedex.treehouse.componentbox


/**
 * A collection of forests and linked forests.
 * Represents the navigation hierarchy for an application.
 */

interface Graph {
    val id: GraphId
    val start: ComponentBoxId
    val graph: Map<ComponentBoxId, ComponentBox>
}
