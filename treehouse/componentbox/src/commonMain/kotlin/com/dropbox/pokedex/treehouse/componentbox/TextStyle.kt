package com.dropbox.pokedex.treehouse.componentbox

import kotlinx.serialization.Serializable


@Serializable
sealed class TextStyle {

    @Serializable
    data class Name(val value: String) : TextStyle()

    /**
     * Represents a style to be applied to text.
     * @property color The text color to be applied to the text, or null if not specified.
     * @property fontWeight The font weight to be applied to the text, or null if not specified.
     * @property fontStyle The font style to be applied to the text, or null if not specified.
     * @property fontSize The font size to be applied to the text, or null if not specified.
     * @property letterSpacing The letter spacing to be applied to the text, or null if not specified.
     * @property lineHeight The line height to be applied to the text, or null if not specified.
     */
    @Serializable
    data class Style(
        val color: Color? = null,
        val fontWeight: FontWeight? = null,
        val fontStyle: FontStyle? = null,
        val fontSize: TextUnit? = null,
        val letterSpacing: TextUnit? = null,
        val lineHeight: TextUnit? = null
    ) : TextStyle() {
        fun color(color: Color): TextStyle = copy(color = color)
        fun fontWeight(fontWeight: FontWeight): TextStyle = copy(fontWeight = fontWeight)
    }
}
