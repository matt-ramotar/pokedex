package com.dropbox.pokedex.treehouse.componentbox

/**
 * Represents a piece of text with optional color and text style information.
 * @property text The text content.
 * @property color The color of the text, or null if not specified.
 * @property style The style of the text, or null if not specified.
 */
interface Text : Component {
    val text: String?
    val color: Color?
    val style: TextStyle?
}