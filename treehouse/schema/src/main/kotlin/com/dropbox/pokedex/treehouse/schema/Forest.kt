package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.dropbox.pokedex.treehouse.componentbox.Forest
import com.dropbox.pokedex.treehouse.componentbox.Tree
import com.dropbox.pokedex.treehouse.componentbox.TreeId


@Widget(8)
data class Forest(
    @Property(1) override val trees: MutableMap<TreeId, Tree>
) : Forest