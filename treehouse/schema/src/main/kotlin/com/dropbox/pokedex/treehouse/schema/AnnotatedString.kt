package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.dropbox.pokedex.treehouse.componentbox.AnnotatedStringElement
import com.dropbox.pokedex.treehouse.componentbox.InlineTextContent
import com.dropbox.pokedex.treehouse.componentbox.SpanStyle
import com.dropbox.pokedex.treehouse.componentbox.TextStyle

/**
 * Enables text with inline styling.
 * @param elements List of [AnnotatedStringElement] which can be plain text or styled spans.
 * @property text Convenience method for creating and adding [AnnotatedStringElement.Text]
 * @property span Convenience method for creating and adding [AnnotatedStringElement.Span]
 * @property inlineContent Convenience method for creating and adding [AnnotatedStringElement.InlineContent]
 */
@Widget(6)
data class AnnotatedString(
    @Property(1) val elements: MutableList<AnnotatedStringElement>,
) {
    fun text(text: String, style: TextStyle? = null, softBreak: Boolean = false) {
        elements.add(AnnotatedStringElement.Text(text, style, softBreak))
    }

    fun span(start: Int, end: Int, style: SpanStyle) {
        elements.add(AnnotatedStringElement.Span(start, end, style))
    }

    fun inlineContent(id: String, content: InlineTextContent) {
        elements.add(AnnotatedStringElement.InlineContent(id, content))
    }
}