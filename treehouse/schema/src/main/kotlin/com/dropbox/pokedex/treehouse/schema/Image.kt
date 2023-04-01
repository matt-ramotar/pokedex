package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget

@Widget(3)
data class Image(
    @Property(1) val url: String,
)