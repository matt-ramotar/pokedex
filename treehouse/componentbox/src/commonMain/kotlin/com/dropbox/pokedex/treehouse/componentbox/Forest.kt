package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable


/**
 * A set of trees.
 * Represents a hybrid module or feature in the application.
 * For example, a screen with some of its UI components driven by Component Box.
 */
@Serializable
data class Forest(
    val trees: MutableMap<TreeId, Tree> = mutableMapOf()
) : ComponentBox

