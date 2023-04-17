package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable

/**
 * A sequence of trees.
 * Represents the connection of root components.
 * For example, an onboarding flow.
 */

@Serializable
data class LinkedForest(
    var root: Node? = null,
    val nodes: MutableList<Node> = mutableListOf()
) : ComponentBox {
    @Serializable
    data class Node(
        val value: Tree,
        var parent: Node? = null,
        var child: Node? = null,
        var prev: Node? = null,
        var next: Node? = null,
    )
}







