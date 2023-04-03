package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.dropbox.pokedex.treehouse.componentbox.LinkedForest


@Widget(9)
data class LinkedForest(
    @Property(1) override var root: LinkedForest.Node?,
    @Property(2) override val nodes: MutableList<LinkedForest.Node>
) : LinkedForest