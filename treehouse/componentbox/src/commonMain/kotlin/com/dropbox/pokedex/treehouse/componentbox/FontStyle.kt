package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents a font style.
 */
@Serializable
sealed class FontStyle {
    object Normal : FontStyle()
    object Italic : FontStyle()
    object Oblique : FontStyle()
}