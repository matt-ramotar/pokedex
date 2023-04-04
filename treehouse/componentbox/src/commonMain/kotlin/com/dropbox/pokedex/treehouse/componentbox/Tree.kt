package com.dropbox.pokedex.treehouse.componentbox

/**
 * A container of a root component.
 * Represents the hierarchical structure of UI components. For example, a screen.
 */
interface Tree : ComponentBox {
    val id: TreeId
    val root: Component
}