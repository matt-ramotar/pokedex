package com.dropbox.pokedex.treehouse.componentbox


/**
 * A set of trees.
 * Represents a hybrid module or feature in the application.
 * For example, a screen with some of its UI components driven by Component Box.
 */

interface Forest : ComponentBox {
    val trees: MutableMap<TreeId, Tree>
}