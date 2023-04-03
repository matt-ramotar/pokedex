package com.dropbox.pokedex.treehouse.componentbox

/**
 * Represents a response to a user-triggered event.
 */
sealed interface Action {
    /**
     * Models events with semantic identifiers.
     * @param Event Used on deserialization to map the event to a lambda function.
     */
    interface Semantic<out Event : Any> : Action {
        val event: Event
    }

    /**
     * Models events with lambda functions.
     */
    interface Lambda : Action {
        val run: () -> Unit
    }
}
