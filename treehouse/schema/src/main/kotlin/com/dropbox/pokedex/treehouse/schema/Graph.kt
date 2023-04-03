package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.dropbox.pokedex.treehouse.componentbox.ComponentBox
import com.dropbox.pokedex.treehouse.componentbox.ComponentBoxId
import com.dropbox.pokedex.treehouse.componentbox.Graph


@Widget(7)
data class Graph(
    @Property(1) override val start: ComponentBoxId,
    @Property(2) override val graph: Map<ComponentBoxId, ComponentBox>
) : Graph