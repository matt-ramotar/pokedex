package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.schema.Default
import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.dropbox.pokedex.treehouse.state.TextFieldState

@Widget(1)
data class TextInput(
    @Property(1)
    @Default("TextFieldState()")
    val state: TextFieldState,
    @Property(2)
    @Default("\"\"")
    val hint: String,
    @Property(3)
    @Default("null")
    val onChange: (TextFieldState) -> Unit,
)
