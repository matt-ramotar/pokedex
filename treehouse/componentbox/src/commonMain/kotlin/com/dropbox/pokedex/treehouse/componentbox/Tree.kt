package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable

/**
 * A container of a root component.
 * Represents the hierarchical structure of UI components. For example, a screen.
 */

@Serializable
data class Tree(
    val root: Component
) : ComponentBox
