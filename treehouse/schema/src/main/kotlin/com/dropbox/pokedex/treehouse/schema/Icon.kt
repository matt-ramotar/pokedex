package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget

@Widget(4)
data class Icon(
    @Property(1) val name: String,
)