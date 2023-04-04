package com.dropbox.pokedex.treehouse.componentbox

/**
 * Represents a response to a user-triggered event.
 */
interface Action {
    fun run(
        navigate: ((to: ComponentBoxId) -> Unit)? = null,
        next: (() -> Unit)? = null,
        prev: (() -> Unit)? = null,
    ): () -> Unit
}
