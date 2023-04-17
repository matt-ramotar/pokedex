package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.dropbox.pokedex.treehouse.componentbox.ComponentBox

/**
 * Represents a Component Box.
 * @property root The root component.
 */
@Widget(7)
data class ComponentBox(
    @Property(1) val componentBox: ComponentBox,
)