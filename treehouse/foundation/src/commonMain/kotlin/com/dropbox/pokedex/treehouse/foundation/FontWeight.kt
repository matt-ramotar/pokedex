package com.dropbox.pokedex.treehouse.foundation

import kotlinx.serialization.Serializable

/**
 * Represents a font weight.
 */
@Serializable
sealed class FontWeight {
    @Serializable
    object Thin : FontWeight()

    @Serializable
    object ExtraLight : FontWeight()

    @Serializable
    object Light : FontWeight()
    @Serializable
    object Normal : FontWeight()
    @Serializable
    object Medium : FontWeight()
    @Serializable
    object SemiBold : FontWeight()
    @Serializable
    object Bold : FontWeight()

    @Serializable
    object ExtraBold : FontWeight()
    @Serializable
    object Black : FontWeight()
}