package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable

@Serializable
sealed interface ComponentBox

typealias ComponentBoxId = String
typealias GraphId = String
typealias ForestId = String
typealias TreeId = String

