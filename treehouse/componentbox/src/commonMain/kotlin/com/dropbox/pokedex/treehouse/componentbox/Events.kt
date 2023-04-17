package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable

@Serializable
data class Events(
    val onClick: Action,
    val onLongClick: Action
)