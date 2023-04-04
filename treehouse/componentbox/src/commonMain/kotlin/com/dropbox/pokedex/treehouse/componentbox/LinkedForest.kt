package com.dropbox.pokedex.treehouse.componentbox


/**
 * A sequence of trees.
 * Represents the connection of root components.
 * For example, an onboarding flow.
 */
interface LinkedForest : ComponentBox {
    val root: Node
    val nodes: MutableList<Node>

    interface Node : Tree {
        val value: Tree
        var parent: Node?
        var child: Node?
        var prev: Node?
        var next: Node?
    }
}
