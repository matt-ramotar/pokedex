package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents a response to a user-triggered event.
 */
@Serializable
data class Action(
    val run: () -> Unit
)

fun lambda(run: () -> Unit) = Action(run)