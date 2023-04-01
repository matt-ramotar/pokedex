package com.dropbox.pokedex.treehouse.state

import kotlinx.serialization.Serializable

@Serializable
data class TextFieldState(
    val text: String = "",
    val selectionStart: Int = 0,
    val selectionEnd: Int = 0,
    val userEditCount: Long = 0L,
) {
    init {
        require(selectionStart in 0..text.length)
        require(selectionEnd in 0..text.length)
    }

    /** Returns a copy of the state initiated by a user edit. */
    fun userEdit(
        text: String = this.text,
        selectionStart: Int = this.selectionStart,
        selectionEnd: Int = this.selectionEnd,
    ) = copy(
        text = text,
        selectionStart = selectionStart.coerceIn(0, text.length),
        selectionEnd = selectionEnd.coerceIn(0, text.length),
        userEditCount = userEditCount + 1L,
    )

    /**
     * Returns true if [other] and this are equal ignoring version metadata.
     * Use this to skip no-op user edits.
     */
    fun contentEquals(other: TextFieldState): Boolean =
        copy(userEditCount = other.userEditCount) == other
}