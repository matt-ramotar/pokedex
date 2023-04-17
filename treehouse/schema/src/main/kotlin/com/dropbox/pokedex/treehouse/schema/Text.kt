package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.schema.Default
import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.dropbox.pokedex.treehouse.componentbox.Color
import com.dropbox.pokedex.treehouse.componentbox.TextStyle

/**
 * Represents a piece of text with optional color and text style information.
 * @property text The text content.
 * @property color The color of the text, or null if not specified.
 * @property style The style of the text, or null if not specified.
 */
@Widget(2)
data class Text(
    @Property(1) val text: String,

    @Default("null")
    @Property(2) val color: Color?,

    @Default("null")
    @Property(3) val style: TextStyle?,
)