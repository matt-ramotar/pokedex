package com.dropbox.pokedex.treehouse.schema

import app.cash.redwood.layout.RowScope
import app.cash.redwood.schema.Children
import app.cash.redwood.schema.Property
import app.cash.redwood.schema.Widget
import com.dropbox.pokedex.treehouse.componentbox.Color
import com.dropbox.pokedex.treehouse.componentbox.Dp
import com.dropbox.pokedex.treehouse.componentbox.Modifier
import com.dropbox.pokedex.treehouse.componentbox.Shape

@Widget(5)
data class ContainedButton(
    @Property(1) val name: String,
    @Property(2) val modifier: Modifier,
    @Property(3) val enabled: Boolean,
    @Property(4) val onClick: () -> Unit,
    @Property(5) val backgroundColor: Color?,
    @Property(6) val contentColor: Color?,
    @Property(7) val elevation: Dp?,
    @Property(8) val shape: Shape?,
    @Children(9) val children: RowScope.() -> Unit,
)
